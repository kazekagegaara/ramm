grammar ramm;

parse
  :  (t=. 
          {System.out.printf("text: %-7s  type: %s \n", 
           $t.text, tokenNames[$t.type]);}
     )* 
     EOF
  ;

block
 : (statement | functionDecl)* expression?
 ;

 statement
 : assignment 
 | functionCall 
 | ifStatement
 | forStatement
 | whileStatement
 ;

assignment
 : Identifier indexes? '=' expression
 ;

Number
 : Int ('.' Digit*)?
 ;

Identifier
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

String
 : ["] (~["\r\n] | '\\\\' | '\\"')* ["]
 | ['] (~['\r\n] | '\\\\' | '\\\'')* [']
 ;
Comment
 : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip
 ;
Space
 : [ \t\r\n\u000C] -> skip
 ;
fragment Int
 : [1-9] Digit*
 | '0'
 ;
  
fragment Digit 
 : [0-9]
 ;