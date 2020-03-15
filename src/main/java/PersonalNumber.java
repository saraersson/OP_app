import java.util.Calendar;

class PersonalNumber {
    String input;
    private String birthDate;
    private String birthNumber;
    private int controlNumber;
    private boolean isOld;

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

    void setIsOld(boolean isOld) {
        this.isOld = isOld;
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

    boolean isOld() {
        return this.isOld;
    }



    void parseFormat() {
        int len = this.input.length();
        // check if under 100 years old
        if(len == 10) {
            setIsOld(false);
            return;
        }

        // check if over 100 years old
        if(len == 11 && this.input.charAt(6) == '+') {
            // remove '+' from String
            StringBuffer sb = new StringBuffer(this.input);
            this.input = sb.deleteCharAt(6).toString();
            setIsOld(true);
            return;
        }
        // check if over 100 years old
        if(len == 12) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int birthYear = Integer.parseInt((String) this.input.subSequence(0, 4));
            if(currentYear - birthYear > 100) {
                setIsOld(true);
                return;
            }
            setIsOld(false);
            return;
        }
    }

    void parseBirthDate() {



    }

    void parseBirthNumber() {

    }
}

