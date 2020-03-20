import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a social security number to validate...");

        while(in.hasNext()) {
            String input = in.nextLine();
            System.out.println("Number to validate: " + input);
            System.out.println();
            ValidityChecker checker = new ValidityChecker(input);
            
            if(checker.isValid()) {
                checker.pn.logger.valid(true);
            }
            else {
                checker.pn.logger.valid(false);
            }
            System.out.println();
            System.out.println("Enter another social security number to validate...");


        }
    }
}
