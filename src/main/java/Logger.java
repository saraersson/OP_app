public class Logger {

    static void invalidFormat(PersonalNumber pn, int len){      // throwing the exceptions

        if (len < 10)
            System.out.println("A social security number must be at least 10 characters long.");
        else if (len > 13)
            System.out.println("A social security number must not be more than 13 characters long.");
        else {
            System.out.println("Invalid characters in given input: " + pn.input);
        }

    }

    static void printResult(PersonalNumber pn) {
        System.out.println("The input given is a valid blabla");
    }

    static void cantBeSwedish() {
        System.out.println("The input given is not a Swedish social security number.");
    }

    static void cantBeCoordination() {
        System.out.println("The input given is not a coordination nr.");
    }

    static void cantBeOrganisation() {
        System.out.println("The input given is not an organisation nr.");
    }

    static void length(int len) {
        System.out.println("The length " + " of the input is between 10 and 13.");
    }

    static void format(PersonalNumber pn, int len) {
        switch(len) {
            case 10:
                System.out.println(pn.input + ": The given input is in the format YYMMDDXXXX");
                break;
            case 11:
                System.out.println(pn.input + ": The given input is in the format YYMMDD-XXXX");
                break;
            case 12:
                System.out.println(pn.input + ": The given input is in the format YYYYMMDDXXXX");
                break;
            case 13:
                System.out.println(pn.input + ": The given input is in the format YYYYMMDD-XXXX");
                break;
            default:
                System.out.println("No idea...");
        }

    }

    static void format(PersonalNumber pn, char separator) {
        if (separator == '/') {
            System.out.println(pn.input + ": The given input is in the format YYMMDDXXXX");
        }
        else {
            System.out.println(pn.input + ": The given input is in the format YYMMDD" + separator + "XXXX");
        }


    }


}

