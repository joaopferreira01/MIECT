grammar Hello; 
more : any* | EOF;
any : greetings | bye;
greetings : 'hello' ID+; 
bye : 'bye' ID+;
ID : [a-zA-Z]+ ;
WS : [ \t\r\n]+ -> skip ;


// antlr4 faz analise sintatica usando a gramatica
// semantica verifica a atribuição do valor à variavel
// Da erro se ela n tiver um valor atribuido mesmo que esteja declarada
// int n; é diferente de int n = 10;  // Sintatica || Semantica