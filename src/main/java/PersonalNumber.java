import java.util.Calendar;

class PersonalNumber {
    String input;
    String fixed;
    private String birthDate;
    private String birthNumber;
    private int controlNumber;
    Type type = new Type();


    private static int BIRTHDATE = 0;
    static int COORDINATION = 11;
    private static int BIRTHNUMBER = 8;
    private static int CONTROLNUMBER = 11;


    PersonalNumber(String pn) {
        this.input = pn;
        this.fixed = pn;
    }


    void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    void setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
    }

    void setControlNumber(int controlNumber) {
        this.controlNumber = controlNumber;
    }


    String getBirthDate() {
        return this.birthDate;
    }

    String getBirthNumber() {
        return this.birthNumber;
    }

    int getControlNumber() {
        return this.controlNumber;
    }




    void parseFormat() {
        final int len = this.input.length();
        switch (len) {
            case 10:
                System.out.println("Length 10");
                checkAndFix10('-');
                break;

            case 11:
                System.out.println("Length 11");
                if(this.input.charAt(6) == '+' || this.input.charAt(6) == '-' ) {
                    char separator = this.input.charAt(6);
                    removeSeparator(6);
                    checkAndFix10(separator);
                }

                else {
                    invalidate(len);

                }
                break;

            case 12:
                System.out.println("Length 12");
                check12();

                break;
            case 13:
                System.out.println(13);
                if(this.input.charAt(8) == '-') {
                    removeSeparator(8);
                    check12();
                }

                else {
                    invalidate(len);
                }

            default:
                invalidate(len);
            }
        }


    private void invalidate(int len) {
        this.type.isInvalid = true;
        Logger.invalidFormat(len);

    }

    private void checkAndFix10(char separator) {
        if(onlyDigits()) {
            this.type.canBeSwedish = true;
            this.type.canBeCoordination = true;
            addCenturyPrefix(separator);
        }
        else {
            invalidate(this.input.length());
        }

    }

    private void check12() {
        if(onlyDigits()) {
            this.type.canBeSwedish = true;
            this.type.canBeCoordination = true;
        }
        else {
            this.type.isInvalid = true;
            Logger.invalidFormat(this.input.length());
        }

    }



    boolean onlyDigits() {
        for(int c = 0; c < this.fixed.length(); ++c) {
            if(!Character.isDigit(this.fixed.charAt(c))){
                return false;
            }
        }
        return true;

    }


    private void addCenturyPrefix(final char option) {
        StringBuffer sb = new StringBuffer(this.fixed);
        final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        final String currentPrefix = Integer.toString(currentYear).substring(0,2);
        int possibleBirthYear = Integer.parseInt(currentPrefix + this.fixed.substring(0,2));

        switch (option) {
            case '+':
            //    System.out.println("possible year: " + possibleBirthYear);
            //    System.out.println("current year: " + currentYear);
                if(possibleBirthYear > currentYear) {
                    possibleBirthYear -= 200;
                }
                else {
                    possibleBirthYear -= 100;
                }

                break;
            case '-':
              //  System.out.println("possible year: " + possibleBirthYear);
              //  System.out.println("current year: " + currentYear);
                if(possibleBirthYear > currentYear) {
                    possibleBirthYear -= 100;
                }

                break;
        }
        final String prefix = Integer.toString(possibleBirthYear).substring(0,2);
        sb.insert(0, prefix);
        this.fixed = sb.toString();
    }

    private void removeSeparator(int index) {
        StringBuffer sb = new StringBuffer(this.fixed);
        this.fixed = sb.deleteCharAt(index).toString();
    }

    void parseBirthDate() {
        String birthDate = this.fixed.substring(BIRTHDATE,BIRTHNUMBER);
        setBirthDate(birthDate);
    }

    void parseBirthNumber() {
        System.out.println(this.fixed);
        String birthNumber = this.fixed.substring(BIRTHNUMBER,CONTROLNUMBER);
        setBirthNumber(birthNumber);
    }

    void parseControlNumber() {
        int controlNumber = Character.getNumericValue(this.fixed.charAt(CONTROLNUMBER));
        setControlNumber(controlNumber);
    }
}

