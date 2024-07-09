grammar aglv2;
program: stat* EOF;

stat:
        instantiation ';'
    |   assignment ';'
    |   functions ';'
    |   view
    |   graphicalObject
    |   for_loop
    |   if_stat
    |   while_loop
    ;

assignment:  
        ID '=' expr             #AssignmentExisting // done
    |   instantiation '=' expr  #AssignmentInstatiation // done
    |   ID'.'ID '=' expr        #AssignmentObjectAttribute
    ;
            
instantiation:  
        ID ':' ID // done
    ;

expr: 
        e1=expr op=('+' | '-') e2=expr                      #ExprOperation
    |   sign=('-' | '+') expr                               #ExprUnaryOperator
    |   '(' expr ')'                                        #ExprParenthesis
    |   events                                              #ExprEvent
    |   point                                               #ExprPoint
    |   vector                                              #ExprVector
    |   Number                                              #ExprRealNumber
    |   String                                              #ExprString
    |   ID                                                  #ExprID
    |   Boolean                                             #ExprBoolean
    |   expr '&&' expr                                      #ExprBooleanAND          
    |   expr '||' expr                                      #ExprBooleanOR
    |   expr ('==' | '!=' | '<' | '<=' | '>' | '>=') expr   #ExprBoolCompare
    // Metemos 'and' 'or' ? Eu meti os simbolos usuais
    ;

events:
    'wait' event;

event:
      'mouse click' #EventMouseClick
    | 'input'       #EventInput
    ;

functions:
            'close' ID                          #FunctionClose
        |   'refresh' ID ('after' time)?        #FunctionRefreshTime
        |   'print' (String | ID)+              #FunctionPrint
        |   'move' ID 'by' point                #FunctionMoveVector
        |   'move' ID 'by' ID                   #FunctionMoveID
        ;

time: Number ts=('ms' | 's');

if_stat:
          'if' '(' expr ')' '{' stat* '}'                       #IfStat
        | 'if' '(' expr ')' '{' stat* '}' 'else' if_stat        #IfElseIf
        | 'if' '(' expr ')' '{' stat* '}' 'else' '{' stat* '}'  #IfElseStat
    ;

while_loop:
        'while' '(' expr ')' '{' stat* '}' #WhileLoop
        ;

for_loop:
        'for' '(' ID '=' expr ';' expr ';' expr ')' '{' stat* '}'   #ForLoop 
    |   'for' ID 'in' from=Number'..'to=Number 'do' '{' stat* '}'   #ForRange
    ;

Boolean:
        'true' | 'false'
    ;


// Rever graphicalObject e View por 
// Podemos alterar no contexto de assignment o ID para o ID do graphical object e a logica do assignment perdura (?) 
graphicalObject:
                    ( ID | instantiation ) 'at' point 'with' '{' (assignment ';')*'}'   #GraphicalObjectInstatiationCoords
                |   ( ID | instantiation ) 'at' ID 'with' '{' (assignment ';')*'}'      #GraphicalObjectInstatiationID
                |   'with' ID 'do' '{' (assignment ';')*'}'                             #GraphicalObjectUpdate
                ;

view:
        instantiation 'with' '{' (assignment ';')* '}' 
        ;


ID:
    [a-zA-Z_][a-zA-Z0-9_]*
    ;

// Angle: Pode nao ser necessario

point: '(' expr ',' expr ')' ;

// Definir vetor como '(' Point ',' Point ')'
vector :    point                                  #VectorPoint
        |   '(' Number ':' Number ')'              #VectorPolar
        ;

Number: [0-9]+('.'[0-9]+)? ;
String: '"' .*? '"' ;

COMMENT: '#' .*? NL -> skip;
MLCOMMENT: '#(' .*? '#)' -> skip;
WS: [ \t\r\n] -> skip;
NL: '\r'?'\n';

// IMOPEDIR A SOMA DE PONTOS (SOMO UM PONTO COM UM VETOR)