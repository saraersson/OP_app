public class Logger {

    PersonalNumber pn;

    Logger(PersonalNumber pn) {
        this.pn = pn;

    }


    void startParsing() {
        System.out.println("Beginning parsing of number: " + this.pn.input);
    }

    void startValidating() {
        System.out.println("Beginning validity check on parsed number: " + this.pn.fixed);
    }

    void invalidFormat(){      // throwing the exceptions
        int len = this.pn.input.length();

        if (len < 10)
            System.out.println(this.pn.input + " is not a Swedish social security number: a social security number must be at least 10 characters long.");
        else if (len > 13)
            System.out.println(this.pn.input + " is not a Swedish social security number: A social security number must not be more than 13 characters long.");
        else {
            System.out.println(this.pn.input + " is not a Swedish social security number: invalid characters in given input");
        }

    }

    void printResult() {
        System.out.println("The input given is a valid Swedish social security number");
    }


    void length() {
        System.out.println("The length of " + this.pn.input +" is between 10 and 13.");
    }

    void format() {
        switch(this.pn.input.length()) {
            case 10:
                System.out.println("The given input " + this.pn.input + " is in the format YYMMDDXXXX");
                break;
            case 11:
                System.out.println("The given input " + this.pn.input + " is in the format YYMMDD-XXXX");
                break;
            case 12:
                System.out.println("The given input " + this.pn.input + " is in the format YYYYMMDDXXXX");
                break;
            case 13:
                System.out.println("The given input " + this.pn.input + " is in the format YYYYMMDD-XXXX");
                break;
            default:
                System.out.println("No idea...");
        }

    }

    void format(char separator) {
        if (separator == '/') {
            System.out.println("The given input " + this.pn.input + " is in the format YYMMDDXXXX");
        }
        else {
            System.out.println("The given input " + this.pn.input + " is in the format YYMMDD" + separator + "XXXX");
        }


    }

    void fixed(String noise) {
        System.out.println("Removed \"" + noise + "\" from input");
    }

    void parsed() {
        System.out.println("Parsing result: " + this.pn.input + " --> " + this.pn.fixed);
        System.out.println();
    }

    void isRegular() {
        System.out.println("Checking if " + this.pn.fixed + " is a valid regular number");
    }

    void isRegular(boolean valid) {
        if(valid) {
            System.out.println(this.pn.fixed + " is a valid regular number");
        }
        else {
            System.out.println(this.pn.fixed + " is NOT a regular number");
            System.out.println();
        }
    }

    void valid() {
        System.out.println(this.pn.fixed + " is a valid social security number");
    }

    void invalid() {
        System.out.println(this.pn.fixed + " is NOT a valid social security number");
        System.out.println();
    }

    void isCoordination() {
        System.out.println("Checking if " + this.pn.fixed + " is a valid coordination number");
    }

    void isCoordination(boolean valid) {
        if(valid) {
            System.out.println(this.pn.fixed + " is a valid coordination number");
            System.out.println();
        }
        else {
            System.out.println(this.pn.fixed + " is NOT a valid coordination number");
            System.out.println();
        }
    }

    void luhns(int luhns, boolean matches) {
        if(matches) {
            System.out.println("The calculated control number (" + luhns + ") of " + this.pn.fixed + " matches given control number (" + this.pn.getControlNumber() + ")");
        }
        else {
            System.out.println("The calculated control number (" + luhns + ") of " + this.pn.fixed + " DOES not match given control number (" + this.pn.getControlNumber() + ")");
        }
    }

    void date(boolean valid) {
        if(valid) {
            System.out.println("The date of " + this.pn.fixed + " is valid");
        }
        else {
            System.out.println("The date of " + this.pn.fixed + " is NOT valid");
        }
    }
}

