import java.util.Calendar;

class PersonalNumber {
    String input;
    String fixed;
    private String birthDate;
    private String birthNumber;
    private int controlNumber;
    Type type = new Type();


    private static int BIRTHDATE = 0;
    static int COORDINATION = 9;
    private static int BIRTHNUMBER = 6;
    private static int CONTROLNUMBER = 9;


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
                check('/');
                break;

            case 11:
                if(this.input.charAt(6) == '+' || this.input.charAt(6) == '-' ) {
                    char separator = this.input.charAt(6);
                    removeSeparator(6);
                    check(separator);
                }

                else {
                    invalidate();
                }
                break;

            case 12:
                if(validFormat()) {
                    removePrefix();
                }
                break;

            case 13:
                if(this.input.charAt(8) == '-') {
                    removeSeparator(8);
                    if(validFormat()) {
                        removePrefix();
                    }
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


    private void check(char separator) {
        Logger.length(this.input.length());
        if(onlyDigits()) {
            Logger.format(this,  separator);
        }
        else {
            invalidate();
        }


    }


    private boolean validFormat() {
        Logger.length(this.input.length());
        if(onlyDigits()) {
            Logger.format(this);
            return true;
        }
        else {
            invalidate();
            return false;
        }

    }

    private void removePrefix() {
        System.out.println(this.fixed);
        StringBuffer sb = new StringBuffer(this.fixed);
        this.fixed = sb.delete(0,2).toString();
        System.out.println(this.fixed);

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


   /* private void addCenturyPrefix(final char option) {
        StringBuffer sb = new StringBuffer(this.fixed);
        final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        final int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        final int currentDate = Calendar.getInstance().get(Calendar.DATE);


        final String currentPrefix = Integer.toString(currentYear).substring(0,2);
        int possibleBirthYear = Integer.parseInt(currentPrefix + this.fixed.substring(0,2));
        final int month = Integer.parseInt(this.fixed.substring(2,4));
        final int date = Integer.parseInt(this.fixed.substring(4,6));


        }
        */




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

