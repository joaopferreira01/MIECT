grammar csv;

file : header row+;

header : row;

row : field (',' field)* '\r'? '\n';

field : TEXT | STRING;

STRING : '"' (~["\r\n])* '"';

TEXT : ~[,\r\n"]+;
