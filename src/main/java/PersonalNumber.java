import java.util.Calendar;

class PersonalNumber {
    String input;
    private String birthDate;
    private String birthNumber;
    private int controlNumber;

    private static int BIRTHDATE = 0;
    private static int BIRTHNUMBER = 8;
    private static int CONTROLNUMBER = 11;

    PersonalNumber(String pn) {
        this.input = pn;
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
                addCenturyPrefix('-');
                break;
            case 11:
                if(this.input.charAt(6) == '+') {
                    removePlus();
                    addCenturyPrefix('+');
                }
                break;
            case 12:
                // check if date has past yet
                break;
            default:
                throw new IllegalArgumentException("Illegal format on pn");
            }
        }


    private void addCenturyPrefix(final char option) {
        StringBuffer sb = new StringBuffer(this.input);
        final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        final String currentPrefix = Integer.toString(currentYear).substring(0,2);
        int possibleBirthYear = Integer.parseInt(currentPrefix + this.input.substring(0,2));

        switch (option) {
            case '+':
                System.out.println("possible year: " + possibleBirthYear);
                System.out.println("current year: " + currentYear);
                if(possibleBirthYear > currentYear) {
                    possibleBirthYear -= 200;
                }
                else {
                    possibleBirthYear -= 100;
                }

                break;
            case '-':
                System.out.println("possible year: " + possibleBirthYear);
                System.out.println("current year: " + currentYear);
                if(possibleBirthYear > currentYear) {
                    possibleBirthYear -= 100;
                }

                break;
        }
        final String prefix = Integer.toString(possibleBirthYear).substring(0,2);
        sb.insert(0, prefix);
        this.input = sb.toString();
    }

    private void removePlus() {
        StringBuffer sb = new StringBuffer(this.input);
        this.input = sb.deleteCharAt(6).toString();
    }

    void parseBirthDate() {
        String birthDate = this.input.substring(BIRTHDATE,BIRTHNUMBER);
        setBirthDate(birthDate);
    }

    void parseBirthNumber() {
        String birthNumber = this.input.substring(BIRTHNUMBER,CONTROLNUMBER);
        setBirthNumber(birthNumber);
    }

    void parseControlNumber() {
        int controlNumber = Character.getNumericValue(this.input.charAt(CONTROLNUMBER));
        setControlNumber(controlNumber);
    }
}

