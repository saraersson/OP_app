import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            String input = in.nextLine();
            ValidityChecker checker = new ValidityChecker(input);
            
            if(checker.isValid()) {
                checker.pn.logger.valid();
            }
            else {
                checker.pn.logger.invalid();
            }



        }
    }
}
