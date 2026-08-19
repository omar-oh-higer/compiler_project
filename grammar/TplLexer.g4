lexer grammar TplLexer;

// ===================== DEFAULT mode (plain HTML text) =====================

COMMENT_OPEN   : '<!--' -> pushMode(HTML_COMMENT) ;
STYLE_TAG_OPEN : '<style>' -> pushMode(CSS) ;
LT             : '<' -> pushMode(TAG) ;
JOPEN_EXPR     : '{{' -> pushMode(JINJA) ;
JOPEN_STMT     : '{%' -> pushMode(JINJA) ;
TEXT           : ~[<{]+ ;

// ===================== HTML_COMMENT mode: <!-- ... --> =====================

mode HTML_COMMENT;
COMMENT_CLOSE : '-->' -> popMode ;
COMMENT_TEXT  : . ;

// ===================== TAG mode: <tagname attr="val" ...> =====================

mode TAG;
GT           : '>' -> popMode ;
SLASH        : '/' ;
EQUALS       : '=' ;
DQUOTE       : '"' -> pushMode(ATTR_VALUE) ;
BANG         : '!' ;
DOCTYPE_KW   : [Dd][Oo][Cc][Tt][Yy][Pp][Ee] ;
VOID_TAG_NAME: 'img' | 'input' | 'br' | 'hr' | 'meta' | 'link' ;
TAG_NAME     : [a-zA-Z][a-zA-Z0-9]* ;
TAG_WS       : [ \t\r\n]+ -> skip ;

// ===================== ATTR_VALUE mode: inside "..." of an attribute =====================

mode ATTR_VALUE;
DQUOTE_END     : '"' -> popMode ;
ATTR_JOPEN_EXPR: '{{' -> type(JOPEN_EXPR), pushMode(JINJA) ;
ATTR_TEXT      : ~["{]+ ;

// ===================== JINJA mode: {{ expr }} or {% stmt %} =====================

mode JINJA;
JCLOSE_EXPR: '}}' -> popMode ;
JCLOSE_STMT: '%}' -> popMode ;
IF         : 'if' ;
ELIF       : 'elif' ;
ELSE       : 'else' ;
ENDIF      : 'endif' ;
FOR        : 'for' ;
ENDFOR     : 'endfor' ;
IN         : 'in' ;
NOT        : 'not' ;
AND        : 'and' ;
OR         : 'or' ;
TRUE       : 'True' ;
FALSE      : 'False' ;
NONE       : 'None' ;
CMP_EQ     : '==' ;
CMP_NEQ    : '!=' ;
CMP_LE     : '<=' ;
CMP_GE     : '>=' ;
CMP_LT     : '<' ;
CMP_GT     : '>' ;
DOT        : '.' ;
PIPE       : '|' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
COMMA      : ',' ;
NUMBER     : [0-9]+ ('.' [0-9]+)? ;
STRING     : '"' (~["\\\r\n])* '"' | '\'' (~['\\\r\n])* '\'' ;
IDENT      : [a-zA-Z_][a-zA-Z0-9_]* ;
JINJA_WS   : [ \t\r\n]+ -> skip ;

// ===================== CSS mode: <style> content or an external .css file =====================

mode CSS;
STYLE_TAG_CLOSE: '</style>' -> popMode ;
LBRACE  : '{' ;
RBRACE  : '}' ;
COLON   : ':' ;
SEMI    : ';' ;
CSS_DOT : '.' ;
COLOR   : '#' [0-9a-fA-F]+ ;
UNIT    : 'px' | 'em' | 'rem' | '%' ;
CSS_NUMBER: [0-9]+ ('.' [0-9]+)? ;
CSS_STRING: '"' (~["\\\r\n])* '"' | '\'' (~['\\\r\n])* '\'' ;
CSS_IDENT : [a-zA-Z-][a-zA-Z0-9-]* ;
CSS_WS    : [ \t\r\n]+ -> skip ;
