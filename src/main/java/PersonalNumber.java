import java.util.Calendar;

class PersonalNumber {
    String input;
    String fixed;
    private String prefix;
    private String year;
    private String month;
    private String day;
    private String birthDate;
    private String birthNumber;
    private int controlNumber;
    Type type = new Type();
    Logger logger;





    PersonalNumber(String pn) {
        this.input = pn;
        this.fixed = pn;
        this.logger = new Logger(this);
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




    void checkFormat() {
        logger.startParsing();
        final int len = this.input.length();
        switch (len) {
            case 10:
                check('/');
                addCenturyPrefix('-');
                break;

            case 11:
                if(this.input.charAt(6) == '+' || this.input.charAt(6) == '-' ) {
                    char separator = this.input.charAt(6);
                    removeSeparator(6);
                    check(separator);
                    addCenturyPrefix(separator);
                    logger.fixed(Character.toString(separator));
                }

                else {
                    invalidateFormat();
                }
                break;

            case 12:
                if(validFormat()) {
                    removePrefix();
                    logger.fixed(this.input.substring(0,2));
                }
                break;

            case 13:
                if(this.input.charAt(8) == '-') {
                    removeSeparator(8);

                    if(validFormat()) {
                        removePrefix();
                        logger.fixed(this.input.substring(0,2));
                        logger.fixed("-");
                    }
                }
                else {
                    invalidateFormat();
                }
                break;

            default:
                invalidateFormat();
            }
        }


    private void invalidateFormat() {
        this.type.isInvalid = true;
    }


    private void check(char separator) {
        logger.length();
        if(onlyDigits()) {
            logger.format(separator);
        }
        else {
            invalidateFormat();
        }
    }


    private boolean validFormat() {
        logger.length();
        if(onlyDigits()) {
            logger.format();
            return true;
        }
        else {
            invalidateFormat();
            return false;
        }

    }

    private void removePrefix() {
        StringBuffer sb = new StringBuffer(this.fixed);
        this.prefix = this.input.substring(0,2);
        this.fixed = sb.delete(0,2).toString();

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

        this.prefix = prefix;
    }



    private void removeSeparator(int index) {
        StringBuffer sb = new StringBuffer(this.fixed);
        this.fixed = sb.deleteCharAt(index).toString();
    }



    boolean onlyDigits() {
        for(int c = 0; c < this.fixed.length(); ++c) {
            if(!Character.isDigit(this.fixed.charAt(c))){
                return false;
            }
        }
        return true;
    }




    void parseBirthDate() {
        String birthDate = this.fixed.substring(ValidityChecker.BIRTHDATE,ValidityChecker.BIRTHNUMBER);
        this.year = this.prefix + birthDate.substring(0,2);
        this.month = birthDate.substring(2,4);
        this.day = birthDate.substring(4,6);
        this.birthDate = birthDate;

    }

    void parseBirthNumber() {
        String birthNumber = this.fixed.substring(ValidityChecker.BIRTHNUMBER,ValidityChecker.CONTROLNUMBER);
        this.birthNumber = birthNumber;
    }

    void parseControlNumber() {
        int controlNumber = Character.getNumericValue(this.fixed.charAt(ValidityChecker.CONTROLNUMBER));
        this.controlNumber = controlNumber;
    }

    String getDate() {
        return this.day + "/" + this.month + "/" + this.year;
    }
}

