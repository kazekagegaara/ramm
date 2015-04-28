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

    Symbol(String symbolValue, int symbolScope){                
        this.symbolValue = symbolValue;
        this.symbolScope = symbolScope;     
    }

    Symbol(List<Token> symbolValue,int symbolScope){
        this.symbolValueList = symbolValue;
        this.symbolScope = symbolScope; 
    }

    // Symbol(TokenType symbolType, int symbolScope){        
    //     this.symbolType = symbolType;   
    //     this.symbolScope = symbolScope;     
    // }       
    
    // public void setSymbolValue(String symbolValue){
    //     this.symbolValue = symbolValue;
    // } 

    public String getSymbolValue(){
        return this.symbolValue;
    }

    public List<Token> getSymbolValueList(){
        return this.symbolValueList;
    }    

    public int getScopeValue(){
        return this.symbolScope;
    }

	@Override
    public String toString() {
        return "Scope : " + this.symbolScope + " -> Value : " + this.symbolValue + " | " + " -> Value : " + this.symbolValueList;
    }

}

// class SymbolEntry {
//     private String name;
//     private int scope;

//     SymbolEntry(String name,int scope){
//         this.name = name;
//         this.scope = scope;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if(obj != null && obj instanceof SymbolEntry) {
//             SymbolEntry s = (SymbolEntry)obj;
//             return name.equals(s.name) && scope == s.scope;
//         }
//         return false;
//     }

//     @Override
//     public int hashCode() {
//         return (name + String.valueOf(scope)).hashCode();
//     }
// }

class SymbolTable {

    private HashMap<String, Symbol> symbolTable = new HashMap<String, Symbol>();  
    private HashMap<String, Symbol> oldSymbolTableReference;
    private LinkedList<HashMap<String, Symbol>> symbolTableGlobal = new LinkedList<HashMap<String,Symbol>>();
    private Stack<String> stack = new Stack<String>(); 
    private boolean setFlag = false; 
    private boolean printFlag = false;
    private boolean printFlag2 = false;
    private boolean numericOpFlag = false;  
    private boolean compOpFlag = false;
    private boolean whileLoopFlag = false;
    private boolean whileLoopExecutionFlag = false;
    private boolean checkConditionFlag = false;
    private boolean ignoreBlockExecution = false;
    private boolean returnFlag = false;
    private String toExecuteCheckBlock = "";    
    private String toReturnValue = "";
    private int numericOpCode = 0;    
    private int compOpCode = 0;
    private int scope = 0;    
    private ArrayList<String> parameterList = new ArrayList<String>();

    public SymbolTable(List<Token> tokens,HashMap<String, Symbol> symbolTableRef,LinkedList<HashMap<String, Symbol>> symbolTableGlobalRef){
        this.symbolTableGlobal = symbolTableGlobalRef;
        this.symbolTable = symbolTableRef;
        this.init(tokens);
        // this(symbolTableRef,symbolTableGlobalRef);
        // this(tokens);
    }

    // public SymbolTable(HashMap<String, Symbol> symbolTableRef,LinkedList<HashMap<String, Symbol>> symbolTableGlobalRef){
    //     this.symbolTableGlobal = symbolTableGlobalRef;
    //     this.symbolTable = symbolTableRef;
    // }

    public SymbolTable(List<Token> tokens){
        this.init(tokens);
    }

    private void init(List<Token> tokens){
		
		switch(t.type.toString()){
		
			case "IDENTIFIER":
                    stack.push(t.stringValue);                    
                    if(counter+1 < tokens.size()){
                        if(tokens.get(counter+1).type.toString().equals("COMMA")){                            
                            // if(scope != 0){                                                                
                                String stackSymbol = stack.pop();
                                for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){
                                    Symbol findSymbol = tempSymbolTable.get(stackSymbol);                                    
                                    if(findSymbol != null){
                                        parameterList.add(findSymbol.getSymbolValue());
                                        break;
                                    }
                                }
                            // }else {                                
                            //     parameterList.add(symbolTable.get(stack.pop()).getSymbolValue());  
                            // }                            
                        }                            
                    }
                    break;
			
			case "NUMBER":
                    stack.push(t.stringValue);
                    if(counter+1 < tokens.size()){
                        if(tokens.get(counter+1).type.toString().equals("COMMA")){
                            parameterList.add(stack.pop());                            
                        }
                    }                    
                    break;
            case "STRING":
                    stack.push(t.stringValue);
                    if(counter+1 < tokens.size()){
                        if(tokens.get(counter+1).type.toString().equals("COMMA")){
                            parameterList.add(stack.pop());                            
                        }
                    }
		
		}
		
    }
}
