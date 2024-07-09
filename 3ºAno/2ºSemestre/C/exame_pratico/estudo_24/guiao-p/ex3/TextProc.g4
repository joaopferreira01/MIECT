grammar TextProc;

program: stat* EOF;

stat:
        output ';'
    |   store ';'   
    ;

output:
        'output' expr       #OutpuExpr
    ;

store:
        '$' ID '=' expr     #StoreExpr
    ;

expr:
        String              #ExprString
    |   ID                  #ExprID
    |   '$' ID              #ExprDollarID
    ;

String: '"' .*? '"';
ID: [a-zA-Z0-9]+;
WS: [ \t\r\n]+ -> skip;
Comment: '#' .*? '\n' -> skip; 