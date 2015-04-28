import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class rammc {

	public static void main(String args[]){				        
        // List<Token> tokens = new Tokens(args[0]).getTokens();
        // for(Token t:tokens){
        //     System.out.println(t.type.toString());
        // }
        run(args[0]);        
	}

    private static void run(String filename){
        SymbolTable st = new SymbolTable(new Tokens(filename).getTokens()); 
    }

}

enum TokenType {
    BLOCKSTART("\\{")                   , 
    BLOCKEND("\\}")                     ,
    COMMA(",")                          ,
    STRING("\"(\\.|[^\"])*\"")          ,    
    NUMBER ("(\\+|-)?\\d+(\\.\\d+)?")   ,
    BOOLEAN ( "TRUE|FALSE")             ,
    PROC ("PROC")                       ,
    PROCLOAD ("LOAD")                   ,
    PREDEFINEDIDENT("[A-Z][A-Z]*")      ,    
    IDENTIFIER ( "[a-z_][A-Za-z0-9]*")  ;

    public final String pattern;
    private TokenType(String pattern){
        this.pattern = pattern;
    }
}

class Token {
    private List<Token> tokens = new ArrayList<Token>(); 
    TokenType type;
    String stringValue;

    public Token(TokenType type, String token) {
        this.type = type;
        this.stringValue = token;
    }

    public Tokens(String filename){
        StringBuilder regex = new StringBuilder();
        for (TokenType t: TokenType.values()) {
            regex.append("|(?<").append(t.name()).append(">").append(t.pattern).append(")");
        }                
        pttrn = Pattern.compile(regex.substring(1));        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {                
                // System.out.println(line); 
                tokenize(line);            
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
	
	private void tokenize(String line){
        matcher = pttrn.matcher(line);
        while (matcher.find()) {            
            String tokenValue;
            for (TokenType tokentype : TokenType.values()){
                if ( (tokenValue = matcher.group(tokentype.name())) != null) {
                    tokens.add(new Token(tokentype, tokenValue));
                    break;
                }
            }
        }
    }

    public List<Token> getTokens(){
        return this.tokens;
    }  
}

class Symbol {        
    private String symbolValue;
    private int symbolScope;        
    private List<Token> symbolValueList;

    public String getSymbolValue(){
        return this.symbolValue;
    }

    public List<Token> getSymbolValueList(){
        return this.symbolValueList;
    }    

    public int getScopeValue(){
        return this.symbolScope;
    }    

    
}
