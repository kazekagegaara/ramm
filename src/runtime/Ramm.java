import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ramm Class is the triggering class for the Ramm VM. It contains the call to public static void main(String args[]).
 * @author Aditya Narasimhamurthy
 * @author Manit Singh Kalsi
 * @author Mohit Kumar
 * @author Richa Mittal
 */

public class Ramm {

    /** 
     *  It makes a call to the run method along with the filename read from the command line arguments
     * 
     * @param args          An array of String that contains the command line arguments
     */

    public static void main(String args[]){                     
        run(args[0]);        
    }

    /** 
     *  It kicks off the VM for the given filename that contains intermediate code
     * 
     * @param filename          String value that holds the filename(intermediate code) to feed to the VM
     */

    private static void run(String filename){
        RammVM st = new RammVM(new Tokens(filename).getTokens()); 
    }
}

/** 
 * Tokens class generates tokens from a given file
 * @author Aditya Narasimhamurthy
 * @author Manit Singh Kalsi
 * @author Mohit Kumar
 * @author Richa Mittal
 */

class Tokens {

    private List<SingleToken> tokens = new ArrayList<SingleToken>();    
    private Pattern pttrn;
    private Matcher matcher;

    /** 
     *  The Tokens constructor builds up the pattern to be used for regex matching. It reads all tokentypes from the Token type enum and forms pattern. It thens read the input file line by line and tokenizes it.
     * 
     * @param filename          String value that holds the filename(intermediate code) to feed to the VM
     */

    public Tokens(String filename){
        StringBuilder regex = new StringBuilder();
        for (TokenType t: TokenType.values()) {
            regex.append("|(?<").append(t.name()).append(">").append(t.pattern).append(")");
        }                
        pttrn = Pattern.compile(regex.substring(1));        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {                
                tokenize(line);            
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /** 
     *  This method takes in a line and add it to the tokens list after finding out what type of Token it is and associating the tokentype and tokenvalue.
     * 
     * @param line          String value that holds a line from the intermediate code that has to be tokenized
     */

    private void tokenize(String line){
        matcher = pttrn.matcher(line);
        while (matcher.find()) {            
            String tokenValue;
            for (TokenType tokentype : TokenType.values()){
                if ( (tokenValue = matcher.group(tokentype.name())) != null) {
                    tokens.add(new SingleToken(tokentype, tokenValue));
                    break;
                }
            }
        }
    }

    /** 
     *  Getter method for returning the generated tokens list
     *      
     * @return Tokens list
     */

    public List<SingleToken> getTokens(){
        return this.tokens;
    }    
}

/** 
 * This is the representation of each token, it contains tokentype and String value of token
 * @author Aditya Narasimhamurthy
 * @author Manit Singh Kalsi
 * @author Mohit Kumar
 * @author Richa Mittal
 */

class SingleToken {
    TokenType type;
    String stringValue;

    /** 
     *  The constructor assigns the token type and the string value of a given token
     * 
     * @param type          TokenType of the token
     * @param token          String value of the token
     */

    public SingleToken(TokenType type, String token) {
        this.type = type;
        this.stringValue = token;
    }
}

/** 
 * This enum holds the regex patterns for various possible Token types for the intermediate code
 * @author Aditya Narasimhamurthy
 * @author Manit Singh Kalsi
 * @author Mohit Kumar
 * @author Richa Mittal
 */

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

    /** 
     *  The constructor assigns the token type regex pattern
     * 
     * @param pattern          Regex pattern for a particular token
     */
    private TokenType(String pattern){
        this.pattern = pattern;
    }
}

/** 
 * This is the representation of each Symbol on the Symbol Table
 * @author Aditya Narasimhamurthy
 * @author Manit Singh Kalsi
 * @author Mohit Kumar
 * @author Richa Mittal
 */

class Symbol {        
    private String symbolValue;
    private int symbolScope;        
    private List<SingleToken> symbolValueList;

    /** 
     *  This constructor assigns the Symbol a value and a scope
     * 
     * @param symbolValue          Symbol Value
     * @param symbolScope          Symbol Scope
     */

    Symbol(String symbolValue, int symbolScope){                
        this.symbolValue = symbolValue;
        this.symbolScope = symbolScope;     
    }

    /** 
     *  This constructor assigns the Symbol a value and a scope
     * 
     * @param symbolValue          Symbol Value
     * @param symbolScope          Symbol Scope
     */

    Symbol(List<SingleToken> symbolValue,int symbolScope){
        this.symbolValueList = symbolValue;
        this.symbolScope = symbolScope; 
    }
    
    /** 
     *  This is a getter method to get the symbol value
     * 
     * @return      Returns the symbol value as a String     
     */

    public String getSymbolValue(){
        return this.symbolValue;
    }

    /** 
     *  This is a getter method to get the symbol value
     * 
     * @return      Returns the symbol value as a List     
     */

    public List<SingleToken> getSymbolValueList(){
        return this.symbolValueList;
    }    

    /** 
     *  This is a getter method to get the symbol scope
     * 
     * @return      Returns the symbol scope as an int
     */

    public int getScopeValue(){
        return this.symbolScope;
    }    

    /** 
     *  Intended only for debugging
     * 
     * @return      Returns the String representation of the Symbol
     */    

    @Override
    public String toString() {
        return "Scope : " + this.symbolScope + " -> Value : " + this.symbolValue + " | " + " -> Value : " + this.symbolValueList;
    }
}

/** 
 * This is the VM for the Ramm Intermdiate Code. It handles Symbol Table generation, calls stacks, expression evaluations, etc.
 * @author Aditya Narasimhamurthy
 * @author Manit Singh Kalsi
 * @author Mohit Kumar
 * @author Richa Mittal
 */

class RammVM {

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

    /** 
     *  The constructor is for tokens that are not in the global scope, it creates a new scope Symbol Table for these tokens
     * 
     * @param tokens                      tokens in the new block
     * @param symbolTableRef              reference of the new symbol table
     * @param symbolTableGlobalRef        reference of the global symbol table
     */

    public RammVM(List<SingleToken> tokens,HashMap<String, Symbol> symbolTableRef,LinkedList<HashMap<String, Symbol>> symbolTableGlobalRef){
        this.symbolTableGlobal = symbolTableGlobalRef;
        this.symbolTable = symbolTableRef;
        this.init(tokens);
    }

    /** 
     *  The constructor is for tokens in the global scope
     * 
     * @param tokens                      tokens in the block     
     */

    public RammVM(List<SingleToken> tokens){
        this.init(tokens);
    }

    /** 
     *  This method processes the tokens and generates Symbol table and does execution when needed
     * 
     * @param tokens    List of tokens to process
     */

    private void init(List<SingleToken> tokens){
        int counter = 0;
        symbolTableGlobal.push(symbolTable);
        for(int i=0; i<tokens.size(); i++){
            SingleToken t = tokens.get(i);

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
                            whileLoopFlag = true;
                        }
                    } 
					else {                        
                        predefinedident(t.stringValue);
                    }                                                     
                    break;
                
				case "IDENTIFIER":
                    stack.push(t.stringValue);                    
                    if(counter+1 < tokens.size()){
                        if(tokens.get(counter+1).type.toString().equals("COMMA")){                            
                                String stackSymbol = stack.pop();
                                for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){
                                    Symbol findSymbol = tempSymbolTable.get(stackSymbol);                                    
                                    if(findSymbol != null){
                                        parameterList.add(findSymbol.getSymbolValue());
                                        break;
                                    }
                                }
                        }                            
                    }
                    break;
                
				case "PROC":
                    List<SingleToken> newTokens = new ArrayList<SingleToken>();   
                    int procScope = 0;  
                    String name = "";
                    boolean startProcBody = false;                  
                    for(int j = i; j<tokens.size(); j++){                                            
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
                                i = j;
                                counter = j;
                                break;                                
                            }                            
                        }
                    }                    
                    insert(name,new Symbol(newTokens,scope));   
                    break;
                
				case "PROCLOAD":
                    String procName = "";
                    List<SingleToken> newTokensList = null;
                    for(int j = i; j<tokens.size(); j++){
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

                    for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){
                        Symbol findSymbol = tempSymbolTable.get(procName);                                    
                        if(findSymbol != null){
                            newTokensList = findSymbol.getSymbolValueList();                            
                            break;
                        }
                    }                    
                    RammVM st = new RammVM(newTokensList,symbolTable,symbolTableGlobal);
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
                    break;

                case "BLOCKEND":                    
                    scope--;
                    symbolTableGlobal.pop();
                    symbolTable = oldSymbolTableReference;                    
                    if(checkConditionFlag){
                        checkConditionFlag = false;
                    }
                    if(whileLoopExecutionFlag){
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
                    break;
            }

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
                        }
                    }                    
                }
                if(t.type.toString().equals("BOOLEAN")){
                    if(t.stringValue.equals(toExecuteCheckBlock)){
                        ignoreBlockExecution = false;
                    } else {
                        ignoreBlockExecution = true;
                    }                    
                }                                                                
            } 
            if(numericOpFlag){
                if(counter+1 < tokens.size()){
                    if(tokens.get(counter+1).type.toString().equals("PREDEFINEDIDENT") || tokens.get(counter+1).type.toString().equals("BLOCKEND") || tokens.get(counter+1).type.toString().equals("PROCLOAD")){
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
    }

    /** 
     *  This method inserts a symbol into the symbol table
     * 
     * @param symbolName    name of the symbol
     * @param symbol        internal representation of the symbol
     */

    private void insert(String symbolName, Symbol symbol){                    
        symbolTable.put(symbolName,symbol);
    }

    /** 
     *  This method inserts a symbol into the symbol table that is not a global symbol table
     *
     * @param scopedSymbolTable     reference of the symbol table to insert this symbol into
     * @param symbolName            name of the symbol
     * @param symbol                internal representation of the symbol
     */

    private void insertScoped(HashMap<String, Symbol> scopedSymbolTable, String symbolName, Symbol symbol){
        scopedSymbolTable.put(symbolName,symbol);
    }

    /** 
     *  This method sets the return value of a function in a call stack
     *     
     */

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

    /** 
     *  This method returns the return value of a function in a call stack
     *     
     * @return      Returns the return value of any function on the call stack
     */

    public String getReturnValue(){
        return toReturnValue;
    }

    /** 
     *  This method handles user input
     *     
     */

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

    /** 
     *  This method handles print operations
     *     
     */

    private void printToConsole(){     
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

    /** 
     *  This method handles assignment operations
     *     
     */

    private void doSetOperation(){
        String value = stack.pop();
        String name = stack.pop();
        if(scope != 0){
            boolean symbolFound = false;
            for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){                
                Symbol findSymbol = tempSymbolTable.get(name);
                if(findSymbol != null){
                    insertScoped(tempSymbolTable,name,new Symbol(value,findSymbol.getScopeValue()));
                    symbolFound = true;
                    break;        
                }
            }
            if(!symbolFound){
                insert(name,new Symbol(value,scope));   
            }
        } else {
            boolean symbolFound = false;
            for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){                                
                Symbol findSymbol = tempSymbolTable.get(name);                
                if(findSymbol != null){
                    insertScoped(tempSymbolTable,name,new Symbol(value,findSymbol.getScopeValue()));
                    symbolFound = true;
                    break;        
                }
            }

            if(!symbolFound){
                if(parameterList.size() == 0){                
                    insert(name,new Symbol(value,scope));
                }
                else {
                    parameterList.add(value);                
                    insert(name,new Symbol(parameterList.toString(),scope));
                    parameterList.clear();
                }
            }
        }            
    }

    /** 
     *  This method handles numeric operations
     *     
     */

    private void doNumericOperation(){       
        float result = 0;
        int count = 0;
        String value = stack.pop();        
        boolean symbolFound = false;                        
        for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){                                
            Symbol findSymbol = tempSymbolTable.get(value);                
            if(findSymbol != null){
                parameterList.add(findSymbol.getSymbolValue());
                symbolFound = true;
                break;        
            }
        }
        if(!symbolFound){
            parameterList.add(value);
        }                                    
        for(String s:parameterList){
            if(count == 0){
                result = Float.parseFloat(s);
                count++;
                continue;
            }
            switch(numericOpCode){
                case 1:
                    result = result + Float.parseFloat(s);
                    break;
                case 2:
                    result = result - Float.parseFloat(s);
                    break;
                case 3:
                    result = result * Float.parseFloat(s);
                    break;
                case 4:
                    result = result / Float.parseFloat(s);
                    break;
                case 5:
                    result = result % Float.parseFloat(s);
                    break;
            }            
            count++;            
        }
        stack.push(Float.toString(result));        
        numericOpFlag = false;
        parameterList.clear();
    }

    /** 
     *  This method handles comparison operations
     *     
     */

    private void doCompOperation(){                          
        String value = stack.pop();        
        boolean symbolFound = false;                        
        for(HashMap<String, Symbol> tempSymbolTable : symbolTableGlobal){                                
            Symbol findSymbol = tempSymbolTable.get(value);                
            if(findSymbol != null){
                parameterList.add(findSymbol.getSymbolValue());
                symbolFound = true;
                break;        
            }
        }
        if(!symbolFound){
            parameterList.add(value);
        }
        boolean isFloat = false;        
        String one = parameterList.get(parameterList.size() - 2);
        String two = parameterList.get(parameterList.size() - 1);
        float onef = 0;
        float twof = 0;        
        if(isNumeric(one) && isNumeric(two))
        {
            onef = Float.parseFloat(one);
            twof = Float.parseFloat(two);
            isFloat = true;
        }        
        switch(compOpCode){
            case 1: 
                if(isFloat){
                    if(onef < twof)
                        stack.push("TRUE");
                    else
                        stack.push("FALSE");
                } else {
                    System.out.println("Incomparable types");
                }
                break;
            case 2:
                if(isFloat){
                    if(onef > twof)
                        stack.push("TRUE");
                    else
                        stack.push("FALSE");
                } else {
                    System.out.println("Incomparable types");
                }
                break;
            case 3:
                if(isFloat){
                    if(onef >= twof)
                        stack.push("TRUE");
                    else
                        stack.push("FALSE");
                } else {
                    System.out.println("Incomparable types");
                }
                break;
            case 4:
                if(isFloat){
                    if(onef <= twof)
                        stack.push("TRUE");
                    else
                        stack.push("FALSE");
                } else {
                    System.out.println("Incomparable types");
                }
                break;
            case 5:
                if(isFloat){
                    if(onef == twof)
                        stack.push("TRUE");
                    else
                        stack.push("FALSE");
                } else {
                    if(one.equals(two))
                        stack.push("TRUE");
                    else
                        stack.push("FALSE");
                }
                break;
            case 6:
                if(isFloat){
                    if(onef != twof)
                        stack.push("TRUE");
                    else
                        stack.push("FALSE");
                } else {
                    if(!one.equals(two))
                        stack.push("TRUE");
                    else
                        stack.push("FALSE");
                }
                break;
        }            
        compOpFlag = false;
        parameterList.clear();  
        if(whileLoopFlag){
            if(stack.pop().equals("TRUE")){
                whileLoopExecutionFlag = true;
            } else {
                whileLoopExecutionFlag = false;
            }            
        }     
    }

    /** 
     *  This method checks if a given String is numeric or not
     *     
     * @return  Returns boolean value that tells if the String is numeric or not
     */

    private static boolean isNumeric(String str)  
    {  
      try  
      {  
        Float d = Float.parseFloat(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }

    /** 
     *  This method performs operations for all the predefined variables in the intermediate code
     *     
     * @param value         String value of the predefined variable
     */

    private void predefinedident(String value){                
        switch(value){
            case "SET":
                setFlag = true;
                break;
            case "INPUT":
                inputReader();
                break;
            case "PRINT":                
                printFlag = true;
                break;
            case "ADD":    
                numericOpCode = 1;
                numericOpFlag = true;
                break;
            case "SUB":                
                numericOpCode = 2;
                numericOpFlag = true;
                break;
            case "MUL":                
                numericOpCode = 3;
                numericOpFlag = true;
                break;
            case "DIV":                
                numericOpCode = 4;
                numericOpFlag = true;
                break;
            case "MOD":
                numericOpCode = 5;
                numericOpFlag = true;
                break;
            case "LT":
                compOpCode = 1;
                compOpFlag = true;
                break;
            case "GT":
                compOpCode = 2;
                compOpFlag = true;
                break;
            case "GE":
                compOpCode = 3;
                compOpFlag = true;
                break;
            case "LE":
                compOpCode = 4;
                compOpFlag = true;
                break;
            case "E":
                compOpCode = 5;
                compOpFlag = true;
                break;
            case "NE":
                compOpCode = 6;
                compOpFlag = true; 
                break;
            case "CHECK":
                checkConditionFlag = true;
                break;            
            case "RETURN":
                returnFlag = true;
                break;
        }
    }
}