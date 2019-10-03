package org.improving.tag;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInputOutput implements InputOutput {
    private Scanner scan;

    public ConsoleInputOutput(Scanner scan) {
        this.scan = scan;
    }

//    @Override
//    public (InputOutput io, scanner){
//        return new Scanner(System.in);
//        this.io;
//        this.scanner;

    //public String receiveInput(){
    //return scanner.nextLine();
//}

    @Override
    public String receiveInput() {
        return scan.nextLine();
    }

    @Override
    public void displayText(Object text){
        if (!"".equals(text.toString()))
        System.out.println(text);
    }
    @Override
    public void displayNewLine() {
        System.out.println();
    }
    @Override
    public void displayPrompt(String prompt){
        System.out.print(prompt);
    }

    }
