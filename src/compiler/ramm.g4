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