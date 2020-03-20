import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the SSN validator!");
        System.out.println("Type \"exit\" to exit program");
        System.out.println("Enter a social security number to validate...");
        System.out.print("> ");

        while(in.hasNext()) {
            final String input = in.nextLine();
            if(input.toLowerCase().equals("exit")){
                break;
            }
            System.out.println(); 
            System.out.println("Number to validate: " + input);
            System.out.println();
            final ValidityChecker checker = new ValidityChecker(input);
            
            if(checker.isValid()) {
                checker.pn.getLogger().valid(true);
            }
            else {
                checker.pn.getLogger().valid(false);
            }
            System.out.println();
            System.out.println("Enter another social security number to validate...");
            System.out.print("> ");
        }
    }
}
