package project7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Parser {

    private final String PUSH = "push";
    private final String POP = "pop";
    private final List<String> arithmeticCommands =  List.of("add", "sub", "neg", "eq", "gt", "lt", "and", "or", "not");
    private final List<String> memoryAccessCommands =  List.of(PUSH, POP);


    private final Scanner fileScanner;
    private String currentCommand;

    public Parser(File fileToParse) throws FileNotFoundException {
        this.fileScanner = new Scanner(fileToParse);
    }

    private boolean hasMoreCommands(){
        return fileScanner.hasNext();
    }

    private void advance(){
        String dirtyCommand = fileScanner.next();
        if(isInstruction(dirtyCommand)){
            currentCommand = cleanUpInstruction(dirtyCommand);
        }else{
            if(hasMoreCommands()){
                advance();
            }
        }
    }

    /**
     * Method that determines the type of command that the variable currentCommand holds.
     * @return
     * @throws Exception
     */
    private CommandType commandType() throws Exception {
        if(arithmeticCommands.contains(currentCommand)){
            return CommandType.C_ARITHMETIC;
        }else if (memoryAccessCommands.contains(currentCommand)){
            return currentCommand.contains(PUSH) ? CommandType.C_PUSH : CommandType.C_POP;
        }else {
            throw new Exception("Could not determine command type, currentCommand: " + currentCommand);
        }
    }

    private String arg1() throws Exception {
        CommandType commandType = commandType();
        if (commandType == CommandType.C_ARITHMETIC){
            return currentCommand.trim();
        }else if (commandType == CommandType.C_PUSH || commandType == CommandType.C_POP){
            return currentCommand.split(" ")[1];// the second element would be the arg 1 in this case
        }else{
            return currentCommand.trim();// logical commands
        }
    }

    private boolean isInstruction(String potentialInstruction){
        return !potentialInstruction.startsWith("//") && !potentialInstruction.isEmpty();
    }

    /**
     * Method to clean up a dirty instruction. Dirty meaning it could have an inline comment or white space after the
     * instruction. This method will remove the comment if there as well as any white space. returning the clean
     * Instruction
     * @param dirtyInstruction the instruction to clean
     * @return clean instruction
     */
    private String cleanUpInstruction(String dirtyInstruction){
        int potentialCommentLocation = dirtyInstruction.indexOf("//");
        if(potentialCommentLocation > 0){
            // further clean up the string of potential comments after the instruction and then remove white spaces
            dirtyInstruction = dirtyInstruction.substring(0, potentialCommentLocation);
        }
        // if no comments after instruction remove white spaces only
        return dirtyInstruction.trim(); // return the cleaned up instruction
    }


}
