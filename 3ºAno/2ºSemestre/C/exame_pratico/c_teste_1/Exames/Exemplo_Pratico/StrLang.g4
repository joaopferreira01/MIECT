grammar StrLang;

main: stat* EOF;

stat:
    print
    | assignment
    ;

print: 'print' expr;

assigment: Identifier ':' expr;

expr:
    'input' '(' expr ')'                #ExprInput
    | expr '+' expr                     #ExprConcat
    | '(' expr '/' expr '/' expr ')'    #ExprSubst
    | String                            #ExprString
    | Identifier                        #ExprIdentifier
    ;

String: '"' .*? '"';
Identifier: [a-zA-Z][a-zA-Z0-9];
WhiteSpace: [\t\r\n]+ -> skip;
Comment: '//' .*? '\n' -> skip
