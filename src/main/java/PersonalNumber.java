import java.util.Calendar;

class PersonalNumber {
    String input;
    private String birthDate;
    private String birthNumber;
    private int controlNumber;
    private boolean isYoungerThanHundred;

    PersonalNumber(String pn) {
        this.input = pn;
    }

    PersonalNumber(String birthDate, String birthNumber, int controlNumber, boolean isYoungerThanHundred) {
        this.birthDate = birthDate;
        this.birthNumber = birthNumber;
        this.controlNumber = controlNumber;
        this.isYoungerThanHundred = isYoungerThanHundred;
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

    void setIsYoungerThanHundred(boolean isYoungerThanHundred) {
        this.isYoungerThanHundred = isYoungerThanHundred;
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

    boolean isYoungerThanHundred() {
        return this.isYoungerThanHundred;
    }




    void setAge() {
        int len = this.input.length();
        // check if under 100 years old
        if(len == 10) {
            setIsYoungerThanHundred(true);
            return;
        }

        // check if over 100 years old
        if(len == 11 && this.input.charAt(6) == '+') {
            setIsYoungerThanHundred(false);
            return;
        }
        // check if over 100 years old
        if(len == 12) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int birthYear = Integer.parseInt((String) this.input.subSequence(0, 4));
            if(currentYear - birthYear > 100) {
                setIsYoungerThanHundred(false);
                return;
            }
            setIsYoungerThanHundred(true);
            return;
        }
    }
}

