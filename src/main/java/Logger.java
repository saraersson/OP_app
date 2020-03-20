public class Logger {

    PersonalNumber pn;

    Logger(PersonalNumber pn) {
        this.pn = pn;

    }


    void start(String mechanism) {
        System.out.println("start: " + mechanism);
        System.out.println();
    }

    void invalidFormat(){      // throwing the exceptions
        int len = this.pn.input.length();

        if (len < 10)
            System.out.println("invalid: a social security number must be at least 10 characters long.");
        else if (len > 13)
            System.out.println("invalid: a social security number must not be more than 13 characters long.");
        else {
            System.out.println("invalid: invalid characters in given input");
        }

    }

    void length() {
        System.out.println("criteria: " + this.pn.input +" is between 10 and 13.");
    }

    void format() {
        switch(this.pn.input.length()) {
            case 10:
                System.out.println("format: " + this.pn.input + " is in the format YYMMDDXXXX");
                break;
            case 11:
                System.out.println("format: " + this.pn.input + " is in the format YYMMDD-XXXX");
                break;
            case 12:
                System.out.println("format: " + this.pn.input + " is in the format YYYYMMDDXXXX");
                break;
            case 13:
                System.out.println("format: " + this.pn.input + " is in the format YYYYMMDD-XXXX");
                break;
            default:
                System.out.println("No idea...");
        }

    }

    void format(char separator) {
        if (separator == '/') {
            System.out.println("format: " + this.pn.input + " is in the format YYMMDDXXXX");
        }
        else {
            System.out.println("format: " + this.pn.input + " is in the format YYMMDD" + separator + "XXXX");
        }


    }

    void fixed(String noise) {
        switch (noise) {
            case "+":
                System.out.println("fix: removed \"" + noise + "\" from input and stored calculated century prefix (" + this.pn.getPrefix() + ")");
                break;
            case "-":
                System.out.println("fix: removed \"" + noise + "\" from input");
                break;
            default:
                System.out.println("fix: removed \"" + noise + "\" from input and stored as century prefix");
                break;
        }

    }

    void parsed() {
        System.out.println("parse result: " + this.pn.input + " --> " + this.pn.fixed);
        System.out.println();
    }

    void isType(String type) {
        System.out.println("check type: " + type);
    }

    void isRegular(boolean valid) {
        if(valid) {
            System.out.println("result: " + this.pn.fixed + " is a valid regular number");
        }
        else {
            System.out.println("result: " + this.pn.fixed + " is NOT a regular number");
            System.out.println();
        }
    }

    void valid(boolean valid) {
        System.out.println();
        if(valid) {
            System.out.println("final result: " + this.pn.fixed + " is a valid social security number");
        }
        else {
            System.out.println("final result: " + this.pn.fixed + " is a NOT valid social security number");
        }

        System.out.println();
    }





    void isCoordination(boolean valid) {
        if(valid) {
            System.out.println("result: " + this.pn.fixed + " is a valid coordination number");
            System.out.println();
        }
        else {
            System.out.println("result: " + this.pn.fixed + " is NOT a valid coordination number");
            System.out.println();
        }
    }


    void isOrganisation(boolean valid) {
        if(valid) {
            System.out.println("result: " + this.pn.fixed + " is a valid organisation number");
            System.out.println();
        }
        else {
            System.out.println("result: " + this.pn.fixed + " is NOT a valid organisation number");
            System.out.println();
        }
    }

    void luhns(int luhns, boolean matches) {
        if(matches) {
            System.out.println("criteria: the calculated control number (" + luhns + ") of " + this.pn.fixed + " matches given control number (" + this.pn.getControlNumber() + ")");
        }
        else {
            System.out.println("criteria: the calculated control number (" + luhns + ") of " + this.pn.fixed + " DOES not match given control number (" + this.pn.getControlNumber() + ")");
        }
    }

    void date(boolean valid) {
        T_Date date = this.pn.getDate();
        String formattedDate = date.day + "/" + date.month + "-" + date.year;
        if(valid) {
            System.out.println("criteria: " + formattedDate + " is a valid date");
        }
        else {
            System.out.println("criteria: " + formattedDate + " is NOT a valid date");
        }
    }

    void prefixOrLength(boolean correct) {
        if(correct) {
            System.out.println("criteria: either the prefix (" + this.pn.getPrefix() + ") of " + this.pn.fixed + " is valid, or the length is 11");
        }
        else {
            System.out.println("criteria: the prefix (" + this.pn.getPrefix() + ") of " + this.pn.fixed + " is not 16 and the length is not 11");
        }
    }

    void coordValue(boolean valid, int coordValue) {
        if(valid){
            assert(coordValue <= 91 && coordValue >= 61);
            System.out.println("criteria: coordination value (" + coordValue + ") is between 61 and 91");
        }
        else {
            System.out.println("criteria: coordination value (" + coordValue + ") is NOT between 61 and 91");
        }
    }
}

