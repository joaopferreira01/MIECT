grammar FracLang;

program: stat* EOF;

stat:   assig ';'           #StatAssig
    |   display ';'         #StatDisplay
    ;

display: 'display' expr;

assig: ID '<=' expr;

expr:   
        '(' expr ')'                #ExprParent
    |   expr op=('*'|':') expr      #ExprMultDiv
    |   expr op=('+'|'-') expr      #ExprAddSub
    |   op=('+'|'-') expr           #ExprPlusMinus
    |   Number '/' Number           #ExprFraction   
    |   Number                      #ExprNumber
    |   ID                          #ExprID
    ;



STRING: '"' .*? '"';
Number: [0-9]+;
ID: [a-z]+;
WS: [ \t\r\n]+ -> skip;
Comment: '--' .*? '\n' -> skip;
