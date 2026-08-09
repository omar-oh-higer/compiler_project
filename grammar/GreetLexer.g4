lexer grammar GreetLexer;

GREETING : 'hello' | 'hi' ;
NAME     : [a-zA-Z]+ ;
WS       : [ \t\r\n]+ -> skip ;
