

class Validator {

    PersonalNumber pn;

    Validator(String input) {
        this.pn = new PersonalNumber(input);
    }

    void parse() {
        this.pn.parseFormat();
        this.pn.parseBirthDate();
        this.pn.parseBirthNumber();
        this.pn.parseControlNumber();
    }






}