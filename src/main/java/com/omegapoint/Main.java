package com.omegapoint;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the SSN validator!");
        System.out.println("Type \"exit\" to exit program");
        System.out.println("Enter a social security number to validate...");
        System.out.print("> ");

        while(in.hasNext()) {
            final String input = in.nextLine();
            // if user wants to exit program
            if(input.toLowerCase().trim().equals("exit")){
                break;
            }
            System.out.println(); 
            System.out.println("Number to validate: " + input);
            System.out.println();

            // create a validity checker with input
            final ValidityChecker checker = new ValidityChecker(input);

            // check if input is valid or not
            if(checker.isValid()) {
                checker.pn.getLogger().valid(true);
            }
            else {
                checker.pn.getLogger().valid(false);
            }

            // get ready for another value to evaluate
            System.out.println();
            System.out.println("Enter another social security number to validate...");
            System.out.print("> ");
        }
    }
}
