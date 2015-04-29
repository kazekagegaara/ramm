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
    TokenType type;
    String stringValue;

    public Token(TokenType type, String token) {
        this.type = type;
        this.stringValue = token;
    }
}

class Tokens {

    private List<Token> tokens = new ArrayList<Token>();    
    private Pattern pttrn;
    private Matcher matcher;

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
		int counter = 0;
        symbolTableGlobal.push(symbolTable);
        for(int i=0; i<tokens.size(); i++){
            // Token t: tokens
            Token t = tokens.get(i);
            // System.out.println(t.type.toString());
            // System.out.println(checkConditionFlag);            
            if(ignoreBlockExecution){                                                                
                if(tokens.get(counter).type.toString().equals("BLOCKEND")){
                    ignoreBlockExecution = !ignoreBlockExecution;
                }                
                counter++;
                continue;
            }
            switch(t.type.toString()){
                case "PREDEFINEDIDENT":                       
                    if(t.stringValue.equals("LOOP")){
                        if(tokens.get(counter+1).type.toString().equals("PREDEFINEDIDENT")){
                            // System.out.println("while loop");
                            whileLoopFlag = true;
                        } // else if(tokens.get(counter+1).toString().equals("IDENTIFIER")){
                        //     System.out.println("for loop");
                        // }
                    } else {                        
                        predefinedident(t.stringValue);
                    }                                                     
                    break;
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
                case "PROC":
                    // System.out.println("Found proc");
                    List<Token> newTokens = new ArrayList<Token>();   
                    int procScope = 0;  
                    String name = "";
                    boolean startProcBody = false;                  
                    for(int j = i; j<tokens.size(); j++){                                            
                        // System.out.println(tokens.get(j).stringValue);
                        if(j == i){
                            name = tokens.get(j+1).stringValue;
                        }
                        if(tokens.get(j).stringValue.equals("{")){
                            procScope++;                                                        
                            startProcBody = true;
                        }
                        if(startProcBody){
                            newTokens.add(tokens.get(j));
                        }
                        if(tokens.get(j).stringValue.equals("}")){
                            procScope--;                        
                            if(procScope == 0){
                                startProcBody = false;
                                // System.out.println("Proc completed");
                                i = j;
                                counter = j;
                                break;                                
                            }                            
                        }
                    }                    
                    insert(name,new Symbol(newTokens,scope));   
                    // SymbolTable st = new SymbolTable(newTokens);                    
                    // System.out.println("Stack --> " + stack.toString());
                    // System.out.println("Symbol Table --> " + symbolTable.toString());
                    // System.out.println("Symbol Table Global --> " + symbolTableGlobal.toString());
                    break;
                case "PROCLOAD":
                    String procName = "";
                    List<Token> newTokensList = null;
                    for(int j = i; j<tokens.size(); j++){
                        // System.out.println(tokens.get(j).stringValue);
                        if(j == i){
                            procName = tokens.get(j+1).stringValue;
                        }       
                        if(j+1 < tokens.size()){
                            if(!(tokens.get(j+1).type.toString().equals("IDENTIFIER") || tokens.get(j+1).type.toString().equals("COMMA") || tokens.get(j+1).type.toString().equals("NUMBER"))){
                                i = j;
                                counter = j;
                                break;
                            }
                        }
                        if(j == tokens.size()-1){
                            i = j;
                            counter = j;
                            break;
                        }                                                             
                    }                    
                    // System.out.println(procName);
                    for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){
                        Symbol findSymbol = tempSymbolTable.get(procName);                                    
                        if(findSymbol != null){
                            newTokensList = findSymbol.getSymbolValueList();                            
                            break;
                        }
                    }                    
                    // System.out.println(newTokensList.toString());
                    SymbolTable st = new SymbolTable(newTokensList,symbolTable,symbolTableGlobal);
                    stack.push(st.getReturnValue());
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
                    break;    
                case "BLOCKSTART":
                    if(whileLoopFlag){
                        if(!whileLoopExecutionFlag){
                            boolean foundLoopEnd = false;
                            while(!foundLoopEnd){
                                if(tokens.get(counter).stringValue.equals("}")){
                                    foundLoopEnd = true;
                                } else {
                                    counter++;
                                }
                            }
                        i = counter;
                        }
                    } 
                    scope++;
                    oldSymbolTableReference = symbolTable;
                    symbolTable = new HashMap<String, Symbol>();
                    symbolTableGlobal.push(symbolTable);                                                                                                                  
                    // System.out.println("Symbol Table Global --> " + symbolTableGlobal.toString());
                    // System.out.println("Symbol Table Global --> " + symbolTableGlobal.toString());
                    break;
                case "BLOCKEND":                    
                    // System.out.println("Symbol Table Global --> " + symbolTableGlobal.toString());                                                      
                    scope--;
                    symbolTableGlobal.pop();
                    symbolTable = oldSymbolTableReference;                    
                    if(checkConditionFlag){
                        checkConditionFlag = false;
                    }
                    if(whileLoopExecutionFlag){
                        // System.out.println("execute again");
                        boolean foundLoopStart = false;
                        while(!foundLoopStart){
                            if(tokens.get(counter).stringValue.equals("LOOP")){
                                foundLoopStart = true;
                            } else {
                                counter--;
                            }
                        }
                        i = counter;                                            
                    } else {
                        whileLoopFlag = false;
                    }
                    // System.out.println("Symbol Table Global --> " + symbolTableGlobal.toString());
                    break;
            }
            // System.out.println(stack.size() + " " + stack.toString());    
            // System.out.println("Stack --> " + stack.toString());
            // System.out.println("Symbol Table --> " + symbolTable.toString());
            // System.out.println("Symbol Table Global --> " + symbolTableGlobal.toString());
            // System.out.println(printFlag);
            
			if(setFlag && stack.size() >= 2 && !(compOpFlag || numericOpFlag)){                                                                  
                doSetOperation();
                setFlag = false;                
            }
            if(printFlag && stack.size() >= 1){                
                printToConsole();                
            } 
            if(returnFlag && stack.size() >= 1){
                setReturnValue();
            }
            if(checkConditionFlag){                                           
                if(!compOpFlag){     
                    if(stack.size() > 0){                        
                        if(stack.peek().equals("TRUE") || stack.peek().equals("FALSE")){
                            toExecuteCheckBlock = stack.pop();
                            // System.out.println(toExecuteCheckBlock + " block to execute");
                        }
                    }                    
                }
                if(t.type.toString().equals("BOOLEAN")){
                    if(t.stringValue.equals(toExecuteCheckBlock)){
                        // System.out.println("execute this block"); 
                        ignoreBlockExecution = false;
                    } else {
                        // System.out.println("Ignore this block");
                        ignoreBlockExecution = true;
                    }                    
                }                                                                
            } 
            if(numericOpFlag){
                if(counter+1 < tokens.size()){
                    if(tokens.get(counter+1).type.toString().equals("PREDEFINEDIDENT") || tokens.get(counter+1).type.toString().equals("BLOCKEND") || tokens.get(counter+1).type.toString().equals("PROCLOAD")){
                        // System.out.println("here" + tokens.get(counter+1).type.toString());
                        doNumericOperation();
                        numericOpFlag = false;
                    }    
                } else {
                    doNumericOperation();
                    numericOpFlag = false;
                }                        
            }                
            if(compOpFlag){
                if(counter+1 < tokens.size()){
                    if(tokens.get(counter+1).type.toString().equals("PREDEFINEDIDENT") || tokens.get(counter+1).type.toString().equals("BOOLEAN") || tokens.get(counter+1).type.toString().equals("BLOCKSTART")){                        
                        doCompOperation();
                        numericOpFlag = false;
                    }    
                } else {
                    doCompOperation();
                    numericOpFlag = false;
                }
            }     
            if(counter+1 < tokens.size()){
                if(tokens.get(counter+1).stringValue.equals("PRINT")){
                   printFlag2 = true;
                } else {
                    printFlag2 = false;
                }
            }            
            counter++;                                      
        }
		if(printFlag && stack.size() >= 1){                
            printToConsole();                
        }   
        if(setFlag && stack.size() >= 2){
            doSetOperation();
            setFlag = false;   
        }       
        // System.out.println("Stack --> " + stack.toString());
        // System.out.println("Symbol Table --> " + symbolTable.toString());
        // System.out.println("Symbol Table Global --> " + symbolTableGlobal.toString());
			
    }

    private void insert(String symbolName, Symbol symbol){                    
        symbolTable.put(symbolName,symbol);
    }

    private void insertScoped(HashMap<String, Symbol> scopedSymbolTable, String symbolName, Symbol symbol){
        scopedSymbolTable.put(symbolName,symbol);
    }

    private void inputReader(){
        String userInput;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            userInput = br.readLine();
            stack.push(userInput);
        } catch (IOException ioe) {
            System.out.println("IO error!");        
        }
    }

    private void printToConsole(){     
        // System.out.println("Stack --> " + stack.toString()); 
        // System.out.println("Symbol Table Global --> " + symbolTableGlobal.toString());          
        if(!numericOpFlag && !compOpFlag){            
            String toPrint = stack.pop();
            boolean symbolFound = false;                         
            for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){                                
                Symbol findSymbol = tempSymbolTable.get(toPrint);                
                if(findSymbol != null){
                    System.out.println(findSymbol.getSymbolValue());                        
                    symbolFound = true;
                    break;        
                }
            }
            if(!symbolFound){
                System.out.println(toPrint);
            }                                                
            if(printFlag2)
                printFlag = true;
            else
                printFlag = false;
        }
    }
	
	private void setReturnValue(){
        String toReturn = "";
        String stackTop = stack.pop();
        boolean symbolFound = false;                         
        for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){                                
            Symbol findSymbol = tempSymbolTable.get(stackTop);                
            if(findSymbol != null){
                toReturn = findSymbol.getSymbolValue();
                symbolFound = true;
                break;        
            }
        }
        if(!symbolFound){
            toReturn = stackTop;            
        }
        toReturnValue = toReturn;
        returnFlag = false;
    }

    public String getReturnValue(){
        return toReturnValue;
    }
}
