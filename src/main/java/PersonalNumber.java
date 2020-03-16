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
                checkAndFix10('/');
                break;

            case 11:
                if(this.input.charAt(6) == '+' || this.input.charAt(6) == '-' ) {
                    char separator = this.input.charAt(6);
                    removeSeparator(6);
                    checkAndFix10(separator);
                }

                else {
                    invalidate();
                }
                break;

            case 12:
                check12();
                break;

            case 13:
                if(this.input.charAt(8) == '-') {
                    removeSeparator(8);
                    check12();
                }
                else {
                    invalidate();
                }
                break;

            default:
                invalidate();
            }
        }


    private void invalidate() {
        this.type.isInvalid = true;
        Logger.invalidFormat(this, this.input.length());

    }

    private void checkAndFix10(char separator) {
        Logger.length(this.input.length());
        if(onlyDigits()) {
            this.type.canBeSwedish = true;
            this.type.canBeCoordination = true;
            if(separator == '/') {
                addCenturyPrefix('-');
            }
            else {
                addCenturyPrefix(separator);
            }
            Logger.format(this,  separator);
        }
        else {
            invalidate();
        }

    }

    private void check12() {
        if(onlyDigits()) {
            this.type.canBeSwedish = true;
            this.type.canBeCoordination = true;
            Logger.format(this, this.input.length());
        }
        else {
            invalidate();
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
        final int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        final int currentDate = Calendar.getInstance().get(Calendar.DATE);


        final String currentPrefix = Integer.toString(currentYear).substring(0,2);
        int possibleBirthYear = Integer.parseInt(currentPrefix + this.fixed.substring(0,2));
        final int month = Integer.parseInt(this.fixed.substring(2,4));
        final int date = Integer.parseInt(this.fixed.substring(4,6));

        switch (option) {
            case '+':
                if(possibleBirthYear > currentYear) {
                    possibleBirthYear -= 200;
                }

                else if(possibleBirthYear == currentYear && (month > currentMonth || month == currentMonth && date > currentDate)) {
                    possibleBirthYear -= 200;
                }

                else {
                    possibleBirthYear -= 100;
                }

                break;
            case '-':

                if(possibleBirthYear > currentYear) {
                    possibleBirthYear -= 100;
                }
                else if(possibleBirthYear == currentYear && (month > currentMonth || month == currentMonth && date > currentDate)) {
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
        this.birthDate = birthDate;
    }

    void parseBirthNumber() {
        String birthNumber = this.fixed.substring(BIRTHNUMBER,CONTROLNUMBER);
        this.birthNumber = birthNumber;
    }

    void parseControlNumber() {
        int controlNumber = Character.getNumericValue(this.fixed.charAt(CONTROLNUMBER));
        this.controlNumber = controlNumber;
    }
}

