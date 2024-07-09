grammar Dict;
program: stat* EOF;
stat: expr? NEWLINE;
expr:
    Integer ' - ' Word;

Integer: [0-9]+;
Word: [a-z]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;