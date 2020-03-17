import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            String input = in.nextLine();
            ValidityChecker checker = new ValidityChecker(input);
            
            if(checker.isValid()) {
                System.out.println("input: " + input);
                System.out.println("fixed: " + checker.pn.fixed);
                System.out.println("birth date: " + checker.pn.getBirthDate());
                System.out.println("birth number: " + checker.pn.getBirthNumber());
                System.out.println("control number: " + checker.pn.getControlNumber());
                System.out.println();
            }



        }
    }
}
