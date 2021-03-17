package project7;

import java.io.File;

public class VMTranslator {

    public static void main(String [] args){
        String fileName = args[0];
        System.out.println("File Name: " + fileName);
        File fileToParse = new File(fileName);

        System.out.println("Path: " + fileToParse.getAbsolutePath());
    }
}