grammar StrLang;

main: stat* EOF;

stat:
                print           #StatPrint
        |       assignment      #StatAssignment
        ;

print:
                'print' expr            #PrintExpr
        ;       

assignment:
                ID ':'  expr                            #AssignmentExpr
        |       ID ':' 'input' '(' expr ')'             #AssignmentTerminal
        ;

expr:
                '(' expr ')'            #ExprParent
        |       expr '/' expr '/' expr  #ExprReplace
        |       expr '+' expr           #ExprAdd
        |       expr '-' expr           #ExprSub
        |       'trim' expr             #ExprTrim
        |       String                  #ExprString
        |       ID                      #ExprID
        ;

String: '"' .*? '"';
ID: [a-zA-Z][a-zA-Z0-9];
WS: [ \t\r\n]+ -> skip;
Comment: '//' .*? '\n' -> skip;

