parser grammar PyParser;

options { tokenVocab = PyLexer; }

program : (statement | NEWLINE)* EOF ;

statement
    : importStatement      #ImportDecl
    | appInit               #AppInitDecl
    | routeDeclaration       #RouteDecl
    | functionDeclaration     #FunctionDecl
    | globalAssignment          #GlobalAssignDecl
    | ifStatement                 #GlobalIfDecl
    ;

importStatement
    : FROM IDENT IMPORT IDENT (COMMA IDENT)* NEWLINE   #FromImport
    | IMPORT IDENT NEWLINE                              #PlainImport
    ;

// app = Flask(__name__)
appInit : IDENT ASSIGN IDENT LPAREN callArguments? RPAREN NEWLINE ;

// @app.route("/add", methods=["GET", "POST"])
// def add(): ...
routeDeclaration : routeDecorator+ functionDeclaration ;
routeDecorator : AT IDENT DOT IDENT LPAREN STRING (COMMA callArgument)* RPAREN NEWLINE ;

functionDeclaration
    : DEF IDENT LPAREN paramList? RPAREN COLON NEWLINE INDENT functionBody DEDENT ;
paramList : IDENT (COMMA IDENT)* ;
functionBody : (stmtInFunction | NEWLINE)+ ;

stmtInFunction
    : returnStatement       #ReturnStmt
    | ifStatement             #IfStmt
    | whileStatement            #WhileStmt
    | forStatement                #ForStmt
    | withOpenStatement             #WithOpenStmt
    | assignmentStatement              #AssignStmt
    | expressionStatement                 #ExprStmt
    | BREAK NEWLINE                          #BreakStmt
    ;

ifStatement
    : IF expression COLON block
      (ELIF expression COLON block)*
      (ELSE COLON block)?
    ;

whileStatement : WHILE expression COLON block ;
forStatement : FOR IDENT IN expression COLON block ;

block : NEWLINE INDENT (stmtInFunction | NEWLINE)+ DEDENT ;

// with open("data/products.json", "w") as f:
withOpenStatement
    : WITH OPEN LPAREN expression (COMMA expression)? RPAREN AS IDENT COLON block ;

assignmentStatement : postfixExpr assignOp expression NEWLINE ;
assignOp : ASSIGN | PLUS_EQ | MINUS_EQ | STAR_EQ | SLASH_EQ ;

expressionStatement : expression NEWLINE ;
returnStatement : RETURN expression? NEWLINE ;

// global-scope: SEED_PRODUCTS = [ {...}, {...} ]
globalAssignment : IDENT ASSIGN expression NEWLINE ;

// ---- expressions, precedence climbing (lowest to highest) ----
expression : orExpr ;
orExpr : andExpr (OR andExpr)* ;
andExpr : notExpr (AND notExpr)* ;
notExpr : NOT notExpr | comparisonExpr ;
comparisonExpr : additiveExpr (compOp additiveExpr)* ;
compOp : EQ | NEQ | LT | GT | LE | GE | IS NOT? | NOT IN | IN ;
additiveExpr : multiplicativeExpr ((PLUS | MINUS) multiplicativeExpr)* ;
multiplicativeExpr : unaryExpr ((STAR | SLASH) unaryExpr)* ;
unaryExpr : MINUS unaryExpr | postfixExpr ;

// atom + trailer* covers indexing, attribute access and calls uniformly,
// so chains like request.form.get("name")[0] parse without dedicated rules
postfixExpr : atom trailer* ;
trailer
    : LBRACK expression RBRACK        #IndexTrailer
    | DOT IDENT                        #AttrTrailer
    | LPAREN callArguments? RPAREN      #CallTrailer
    ;

atom
    : IDENT                                            #NameAtom
    | NUMBER                                            #NumberAtom
    | STRING                                            #StringAtom
    | TRUE                                              #TrueAtom
    | FALSE                                             #FalseAtom
    | NONE                                              #NoneAtom
    | LBRACK (expression (COMMA expression)*)? RBRACK   #ListAtom
    | LBRACE (dictItem (COMMA dictItem)*)? RBRACE       #DictAtom
    | LPAREN expression RPAREN                          #ParenAtom
    ;

callArguments : callArgument (COMMA callArgument)* ;
callArgument : (IDENT ASSIGN)? expression ;
dictItem : expression COLON expression ;
