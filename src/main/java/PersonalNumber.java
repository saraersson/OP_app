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
                this.type.canBeSwedish = true;
                addCenturyPrefix('-');
                break;

            case 11:
                System.out.println("Length 11");
                if(this.input.charAt(6) == '+') {
                    System.out.println("found +");
                    this.type.canBeSwedish = true;
                    this.type.canBeCoordination = true;
                    removeSeparator(6);
                    addCenturyPrefix('+');
                }
                else if(this.input.charAt(6) == '-') {
                    this.type.canBeSwedish = true;
                    this.type.canBeCoordination = true;
                    removeSeparator(6);
                    addCenturyPrefix('-');
                }
                else {
                    this.type.canBeSwedish = false;
                    this.type.canBeCoordination = false;
                    Logger.cantBeSwedish();
                    Logger.cantBeCoordination();
                    Logger.cantBeOrganisation();

                }

                break;
            case 12:
                this.type.canBeSwedish = true;
                this.type.canBeCoordination = true;

                break;
            case 13:
                if(this.input.charAt(8) == '-') {
                    this.type.canBeSwedish = true;
                    this.type.canBeCoordination = true;
                    removeSeparator(8);
                }
                else {
                    Logger.checkLen(len);
                }

            default:
                Logger.checkLen(len);
            }
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
        String birthNumber = this.fixed.substring(BIRTHNUMBER,CONTROLNUMBER);
        setBirthNumber(birthNumber);
    }

    void parseControlNumber() {
        int controlNumber = Character.getNumericValue(this.fixed.charAt(CONTROLNUMBER));
        setControlNumber(controlNumber);
    }
}

