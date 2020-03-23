package com.omegapoint;

import java.util.Calendar;

class PersonalNumber {
    private String input;
    private String fixed;
    private String prefix;

    private int controlNumber;

    private Type type = new Type();
    private T_Date date;
    private Logger logger;


    PersonalNumber(String pn) {
        this.input = pn;
        this.fixed = pn;
        this.logger = new Logger(this);
        this.date = new T_Date();
    }

    String getInput() {
        return this.input;
    }
    String getFixed() {
        return this.fixed;
    }

    String getPrefix() {
        return this.prefix;
    }
    int getControlNumber() {
        return this.controlNumber;
    }

    int getOrganisationNumber() {
        return Integer.parseInt(this.date.month);
    }

    Type getType() {
        return this.type;
    }

    Logger getLogger() {
        return this.logger;
    }



    void checkFormat() {
        logger.start("parsing");

        this.input = this.input.trim();
        this.fixed = this.input.trim();
        final int len = this.input.length();
        switch (len) {
            case 10:
                if(!validFormat('/')){
                    break;
                }
                addCenturyPrefix('-');
                break;

            case 11:
                if(this.input.charAt(6) == '+' || this.input.charAt(6) == '-' ) {
                    char separator = this.input.charAt(6);
                    removeSeparator(6);
                    if(!validFormat('/')){
                        break;
                    }
                    addCenturyPrefix(separator);
                    logger.fixed(Character.toString(separator));
                    break;
                }
                invalidateFormat();
                break;

            case 12:
                if(!validFormat()) {
                    break;
                }
                removePrefix();
                logger.fixed(this.input.substring(0,2));
                break;

            case 13:
                if(this.input.charAt(8) == '-') {
                    removeSeparator(8);

                    if(!validFormat()) {
                        break;
                    }
                    removePrefix();
                    logger.fixed(this.input.substring(0,2));
                    logger.fixed("-");
                    break;

                }
                invalidateFormat();
                break;

            default:
                invalidateFormat();
            }
        }


    private void invalidateFormat() {
        this.type.isInvalid = true;
    }


    private boolean validFormat(final char separator) {
        logger.length();
        if (onlyDigits()) {
            logger.format(separator);
            return true;
        }
        invalidateFormat();
        return false;
    }

    private boolean validFormat() {
        logger.length();
        if(onlyDigits()) {
            logger.format();
            return true;
        }
        invalidateFormat();
        return false;
    }

    private void removePrefix() {
        StringBuffer sb = new StringBuffer(this.fixed);
        this.prefix = this.input.substring(0,2);
        this.fixed = sb.delete(0,2).toString();

    }

    private void addCenturyPrefix(final char option) {
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

    private void removeSeparator(final int index) {
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
        final String birthDate = this.fixed.substring(ValidityChecker.BIRTHDATE, ValidityChecker.BIRTHNUMBER);
        this.date.year = this.prefix + birthDate.substring(0,2);
        this.date.month = birthDate.substring(2,4);
        this.date.day = birthDate.substring(4,6);
    }

    void parseControlNumber() {
        final int controlNumber = Character.getNumericValue(this.fixed.charAt(ValidityChecker.CONTROLNUMBER));
        this.controlNumber = controlNumber;
    }

    T_Date getDate() {
        return this.date;
    }
}

