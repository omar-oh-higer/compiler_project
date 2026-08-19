parser grammar TplParser;

options { tokenVocab = TplLexer; }

document : node* EOF ;

node
    : doctype           #DoctypeNode
    | htmlComment        #CommentNode
    | htmlVoidElement     #VoidElementNode
    | htmlElement          #ElementNode
    | styleElement           #StyleNode
    | jinjaIfStmt              #IfNode
    | jinjaForStmt               #ForNode
    | jinjaExprTag                 #ExprNode
    | TEXT                          #TextNode
    ;

doctype     : LT BANG DOCTYPE_KW TAG_NAME GT ;
htmlComment : COMMENT_OPEN COMMENT_TEXT* COMMENT_CLOSE ;

// <div class="card"> ... </div>  (nestable, needs a matching closing tag)
htmlElement : LT TAG_NAME attribute* GT node* LT SLASH TAG_NAME GT ;

// <img src="..."> / <input ...>  (explicit whitelist, never needs a closing tag)
htmlVoidElement : LT VOID_TAG_NAME attribute* SLASH? GT ;

attribute : TAG_NAME (EQUALS attrValue)? ;
attrValue : DQUOTE (ATTR_TEXT | jinjaExprTag)* DQUOTE_END ;

// <style> ... </style>            (reuses cssRule)
styleElement : STYLE_TAG_OPEN cssRule* STYLE_TAG_CLOSE ;
// entry point used for a standalone external .css file (same cssRule)
stylesheet : cssRule* EOF ;

cssRule     : cssSelector LBRACE cssProperty* RBRACE ;
cssSelector : CSS_IDENT (CSS_DOT CSS_IDENT)* (COLON CSS_IDENT)?    // tag, tag.class, tag.class:hover
            | CSS_DOT CSS_IDENT (COLON CSS_IDENT)?                 // .class, .class:hover
            ;
cssProperty : CSS_IDENT COLON cssValue SEMI ;
cssValue    : cssValueItem+ ;
cssValueItem: CSS_IDENT | CSS_NUMBER UNIT? | COLOR | CSS_STRING ;

// {{ product.price | round(2) }}
jinjaExprTag : JOPEN_EXPR jinjaExpr jFilter* JCLOSE_EXPR ;
jFilter      : PIPE IDENT (LPAREN jFilterArgs? RPAREN)? ;
jFilterArgs  : jinjaExpr (COMMA jinjaExpr)* ;

// {% if cond %} ... {% elif cond %} ... {% else %} ... {% endif %}
jinjaIfStmt
    : JOPEN_STMT IF jinjaExpr JCLOSE_STMT node*
      (JOPEN_STMT ELIF jinjaExpr JCLOSE_STMT node*)*
      (JOPEN_STMT ELSE JCLOSE_STMT node*)?
      JOPEN_STMT ENDIF JCLOSE_STMT
    ;

// {% for item in items %} ... {% else %} ... {% endfor %}
jinjaForStmt
    : JOPEN_STMT FOR IDENT IN jinjaExpr JCLOSE_STMT node*
      (JOPEN_STMT ELSE JCLOSE_STMT node*)?
      JOPEN_STMT ENDFOR JCLOSE_STMT
    ;

// precedence chain, same style as the Python expression grammar (phase 2)
jinjaExpr      : jOr ;
jOr            : jAnd (OR jAnd)* ;
jAnd           : jNot (AND jNot)* ;
jNot           : NOT jNot | jComparison ;
jComparison    : jAtomPath (compOp jAtomPath)? ;
compOp         : CMP_EQ | CMP_NEQ | CMP_LT | CMP_GT | CMP_LE | CMP_GE ;
jAtomPath      : IDENT (DOT IDENT)*  #PathAtom
               | NUMBER               #NumberAtom
               | STRING                #StringAtom
               | TRUE                   #TrueAtom
               | FALSE                   #FalseAtom
               | NONE                     #NoneAtom
               ;
