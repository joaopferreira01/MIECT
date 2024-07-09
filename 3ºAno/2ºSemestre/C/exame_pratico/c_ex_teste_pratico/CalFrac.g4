grammar CalFrac;

main: (NL | (stat ';' NL?))* EOF;

stat: print
    | defVar
    ;

print: 'print' expr;

defVar: expr '->' VAR;

expr: expr op=('*'|':') expr  #PrdDiv
    | expr op=('+'|'-') expr  #SumSub
    | '(' expr ')'            #Parent
    | '(' expr ')' '^' num    #Power
    | n=num ('/' d=NUM)?      #Frac
    | VAR                     #VarExpr
    | 'read' STRING           #Input
    | 'reduce' expr           #Reduce
    ;

num: op=('+'|'-')? NUM;

VAR: [a-z]+;
NUM: [0-9]+;
STRING: '"' .*? '"';
NL: '\r'? '\n';
COMMENT: '//' .*? '\n' -> skip;
WS: [ \t]+ -> skip;
ERROR: .;
