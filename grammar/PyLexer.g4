lexer grammar PyLexer;

tokens { INDENT, DEDENT }

@lexer::members {
    private final java.util.ArrayDeque<Integer> indentStack = new java.util.ArrayDeque<>();
    private final java.util.ArrayDeque<Token> pendingTokens = new java.util.ArrayDeque<>();
    private int bracketDepth = 0;
    private boolean emittedFinalDedents = false;

    {
        indentStack.push(0);
    }

    private int indentWidthOf(String newlineText) {
        int lastNewline = newlineText.lastIndexOf('\n');
        String tail = newlineText.substring(lastNewline + 1);
        int width = 0;
        for (int i = 0; i < tail.length(); i++) {
            width += (tail.charAt(i) == '\t') ? 4 : 1;
        }
        return width;
    }

    private Token offsideToken(int type, Token basedOn) {
        CommonToken t = new CommonToken(basedOn);
        t.setType(type);
        t.setText("");
        return t;
    }

    private void queueIndentation(Token newlineToken) {
        pendingTokens.add(newlineToken);
        int width = indentWidthOf(newlineToken.getText());

        if (width > indentStack.peek()) {
            indentStack.push(width);
            pendingTokens.add(offsideToken(INDENT, newlineToken));
        } else {
            while (width < indentStack.peek()) {
                indentStack.pop();
                pendingTokens.add(offsideToken(DEDENT, newlineToken));
            }
        }
    }

    @Override
    public Token nextToken() {
        if (!pendingTokens.isEmpty()) {
            return pendingTokens.poll();
        }

        Token token = super.nextToken();

        if (token.getType() == NEWLINE) {
            queueIndentation(token);
            return pendingTokens.poll();
        }

        if (token.getType() == Token.EOF && !emittedFinalDedents) {
            emittedFinalDedents = true;
            while (indentStack.peek() > 0) {
                indentStack.pop();
                pendingTokens.add(offsideToken(DEDENT, token));
            }
            pendingTokens.add(token);
            return pendingTokens.poll();
        }

        return token;
    }
}

// keywords
FROM   : 'from' ;
IMPORT : 'import' ;
DEF    : 'def' ;
RETURN : 'return' ;
IF     : 'if' ;
ELIF   : 'elif' ;
ELSE   : 'else' ;
WHILE  : 'while' ;
FOR    : 'for' ;
IN     : 'in' ;
IS     : 'is' ;
NOT    : 'not' ;
AND    : 'and' ;
OR     : 'or' ;
TRUE   : 'True' ;
FALSE  : 'False' ;
NONE   : 'None' ;
BREAK  : 'break' ;
WITH   : 'with' ;
AS     : 'as' ;
OPEN   : 'open' ;

// operators / punctuation
PLUS_EQ  : '+=' ;
MINUS_EQ : '-=' ;
STAR_EQ  : '*=' ;
SLASH_EQ : '/=' ;
EQ       : '==' ;
NEQ      : '!=' ;
LE       : '<=' ;
GE       : '>=' ;
ASSIGN   : '=' ;
LT       : '<' ;
GT       : '>' ;
PLUS     : '+' ;
MINUS    : '-' ;
STAR     : '*' ;
SLASH    : '/' ;
COLON    : ':' ;
COMMA    : ',' ;
DOT      : '.' ;
AT       : '@' ;

LPAREN : '(' { bracketDepth++; } ;
RPAREN : ')' { if (bracketDepth > 0) bracketDepth--; } ;
LBRACK : '[' { bracketDepth++; } ;
RBRACK : ']' { if (bracketDepth > 0) bracketDepth--; } ;
LBRACE : '{' { bracketDepth++; } ;
RBRACE : '}' { if (bracketDepth > 0) bracketDepth--; } ;

// literals
NUMBER : [0-9]+ ('.' [0-9]+)? ;
STRING : '"' (~["\\\r\n])* '"' | '\'' (~['\\\r\n])* '\'' ;
IDENT  : [a-zA-Z_][a-zA-Z0-9_]* ;

// line structure — inside brackets, newlines are swallowed so multi-line
// list/dict literals don't need special grammar rules for embedded NEWLINEs
NEWLINE
    : ( '\r'? '\n' [ \t]* )+
      { if (bracketDepth > 0) skip(); }
    ;

COMMENT : '#' ~[\r\n]* -> skip ;
WS      : [ \t]+ -> skip ;
