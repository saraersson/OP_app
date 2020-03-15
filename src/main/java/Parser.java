

class Parser {

    PersonalNumber pn;

    Parser(String input) {
        this.pn = new PersonalNumber(input);
    }

    void parse() {
        this.pn.setAge();
        System.out.println(this.pn.input);
        System.out.println(this.pn.isYoungerThanHundred());


    }



}
