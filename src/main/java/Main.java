import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            String input = in.nextLine();
            Validator validator = new Validator(input);
            
            if(validator.isValid()) {
                System.out.println("input: " + input);
                System.out.println("fixed: " + validator.pn.fixed);
                System.out.println("birth date: " + validator.pn.getBirthDate());
                System.out.println("birth number: " + validator.pn.getBirthNumber());
                System.out.println("control number: " + validator.pn.getControlNumber());
                System.out.println();
            }



        }
    }
}
