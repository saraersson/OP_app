class Logger {

    PersonalNumber pn;

    Logger(PersonalNumber pn) {
        this.pn = pn;

    }

    void start(final String mechanism) {
        System.out.println("start: " + mechanism);
        System.out.println();
    }

    void invalidFormat() {      // throwing the exceptions
        int len = this.pn.getInput().length();

        if (len < 10)
            System.out.println("[!] invalid: a social security number must be at least 10 characters long.");
        else if (len > 13)
            System.out.println("[!] invalid: a social security number must not be more than 13 characters long.");
        else {
            System.out.println("[!] invalid: invalid characters in given input");
        }
    }

    void length() {
        System.out.println("[V] criteria: " + this.pn.getInput() + " is between 10 and 13.");
    }

    void format() {
        switch (this.pn.getInput().length()) {
            case 10:
                System.out.println("[V] format: " + this.pn.getInput() + " is in the format YYMMDDXXXX");
                break;
            case 11:
                System.out.println("[V] format: " + this.pn.getInput() + " is in the format YYMMDD-XXXX");
                break;
            case 12:
                System.out.println("[V] format: " + this.pn.getInput() + " is in the format YYYYMMDDXXXX");
                break;
            case 13:
                System.out.println("[V] format: " + this.pn.getInput() + " is in the format YYYYMMDD-XXXX");
                break;
            default:
                System.out.println("No idea...");
        }
    }

    void format(final char separator) {
        if (separator == '/') {
            System.out.println("[V] format: " + this.pn.getInput() + " is in the format YYMMDDXXXX");
        } else {
            System.out.println("[V] format: " + this.pn.getInput() + " is in the format YYMMDD" + separator + "XXXX");
        }
    }

    void fixed(final String noise) {
        switch (noise) {
            case "+":
                System.out.println("[V] fix: removed \"" + noise + "\" from input and stored calculated century prefix (" + this.pn.getPrefix() + ")");
                break;
            case "-":
                System.out.println("[V] fix: removed \"" + noise + "\" from input");
                break;
            default:
                System.out.println("[V] fix: removed \"" + noise + "\" from input and stored as century prefix");
                break;
        }
    }

    void parsed() {
        System.out.println("[V] parse result: " + this.pn.getInput() + " --> " + this.pn.getFixed());
        System.out.println();
    }

    void isType(final String type) {
        System.out.println("check type: " + type);
    }

    void isRegular(final boolean valid) {
        if (valid) {
            System.out.println("[V] result: " + this.pn.getFixed() + " is a valid regular number");
        } else {
            System.out.println("[X] result: " + this.pn.getFixed() + " is NOT a regular number");
            System.out.println();
        }
    }

    void valid(final boolean valid) {
        System.out.println();
        if (valid) {
            System.out.println("[V] final result: " + this.pn.getFixed() + " is a valid social security number");
        } else {
            System.out.println("[X] final result: " + this.pn.getFixed() + " is a NOT valid social security number");
        }

        System.out.println();
    }


    void isCoordination(final boolean valid) {
        if (valid) {
            System.out.println("[V] result: " + this.pn.getFixed() + " is a valid coordination number");
            System.out.println();
        } else {
            System.out.println("[X] result: " + this.pn.getFixed() + " is NOT a valid coordination number");
            System.out.println();
        }
    }

    void isOrganisation(final boolean valid) {
        if (valid) {
            System.out.println("[V] result: " + this.pn.getFixed() + " is a valid organisation number");
            System.out.println();
        } else {
            System.out.println("[X] result: " + this.pn.getFixed() + " is NOT a valid organisation number");
            System.out.println();
        }
    }

    void luhns(final int luhns, final boolean matches) {
        if (matches) {
            System.out.println("[V] criteria: the calculated control number (" + luhns + ") of " + this.pn.getFixed() + " matches given control number (" + this.pn.getControlNumber() + ")");
        } else {
            System.out.println("[!] criteria: the calculated control number (" + luhns + ") of " + this.pn.getFixed() + " does NOT match given control number (" + this.pn.getControlNumber() + ")");
        }
    }

    void date(final boolean valid) {
        T_Date date = this.pn.getDate();
        String formattedDate = date.day + "/" + date.month + "-" + date.year;
        if (valid) {
            System.out.println("[V] criteria: " + formattedDate + " is a valid date");
        } else {
            System.out.println("[!] criteria: " + formattedDate + " is NOT a valid date");
        }
    }

    void prefixOrLength(final boolean correct) {
        if (correct) {
            System.out.println("[V] criteria: either the prefix (" + this.pn.getPrefix() + ") of " + this.pn.getFixed() + " is valid, or the length is 11");
        } else {
            System.out.println("[!] criteria: the prefix (" + this.pn.getPrefix() + ") of " + this.pn.getFixed() + " is not 16 and the length is not 11");
        }
    }

    void coordValue(final boolean valid, final int coordValue) {
        if (valid) {
            assert (coordValue <= 91 && coordValue >= 61);
            System.out.println("[V] criteria: coordination value (" + coordValue + ") is between 61 and 91");
        } else {
            System.out.println("[!] criteria: coordination value (" + coordValue + ") is NOT between 61 and 91");
        }
    }

    void orgValue(final boolean valid, final int orgValue) {
        if (valid) {
            assert (orgValue >= 20);
            System.out.println("[V] criteria: organisation value (" + orgValue + ") is over 20");
        } else {
            assert (orgValue < 20);
            System.out.println("[X] criteria: organisation value (" + orgValue + ") is under 20");
        }
    }
}