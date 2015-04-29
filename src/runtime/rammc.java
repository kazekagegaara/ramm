import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ramm {

    public static void main(String args[]){                     
        run(args[0]);        
    }

    private static void run(String filename){
        SymbolTable st = new SymbolTable(new Tokens(filename).getTokens()); 
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

class Token {
    TokenType type;
    String stringValue;

    public Token(TokenType type, String token) {
        this.type = type;
        this.stringValue = token;
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
    }

    public SymbolTable(List<Token> tokens){
        this.init(tokens);
    }

    private void init(List<Token> tokens){
        int counter = 0;
        symbolTableGlobal.push(symbolTable);
        for(int i=0; i<tokens.size(); i++){
            Token t = tokens.get(i);

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
                    List<Token> newTokens = new ArrayList<Token>();   
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
                    List<Token> newTokensList = null;
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

    private void insert(String symbolName, Symbol symbol){                    
        symbolTable.put(symbolName,symbol);
    }

    private void insertScoped(HashMap<String, Symbol> scopedSymbolTable, String symbolName, Symbol symbol){
        scopedSymbolTable.put(symbolName,symbol);
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