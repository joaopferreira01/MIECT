grammar agl;

program: statement* EOF;

statement:
    instantiation ';'
    | view
    | assignment ';'
    ;

assignment:  
    ID ('.' ID)? '=' expr
    | instantiation '=' expr   
    ;

instantiation:  
    ID ':' ID
    ;

expr: 
    literal
    ;

literal:
    Number
    | String
    ;

view:
    instantiation 'with' '{' (assignment ';')* '}'
    ;

ID: [a-zA-Z_] [a-zA-Z0-9_]* ;
Number: [0-9]+ ('.' [0-9]+)? ;
String: '"' ~["\r\n]* '"' ;

COMMENT: '#' ~[\r\n]* -> skip;
MLCOMMENT: '#(' .*? '#)' -> skip;
WS: [ \t]+ -> skip;
NL: '\r'? '\n' -> skip;
