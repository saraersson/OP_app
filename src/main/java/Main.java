import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        Parser parser = new Parser(input);
        parser.parse();
        //  System.out.println(input);
    }
}
