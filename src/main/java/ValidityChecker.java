import java.util.ArrayList;
import java.util.List;

class ValidityChecker {

    PersonalNumber pn;

    static int BIRTHDATE = 0;
    static int COORDINATION = 9;
    static int BIRTHNUMBER = 6;
    static int CONTROLNUMBER = 9;

    ValidityChecker(String input) {
        this.pn = new PersonalNumber(input);
    }


    boolean isValid() {
        this.pn.checkFormat();
        if(this.pn.type.isInvalid) {
            return false;
        }
        this.parseFormat();

        if (this.isSwedish()) {
            return true;
        }

     /*   if(vc.isCoordination()) {
            return true;
        }

        if(vc.isOrganisation()) {
            return true;
        }
        */
        return false;

    }


    void parseFormat() {
            this.pn.parseBirthDate();
            this.pn.parseBirthNumber();
            this.pn.parseControlNumber();
    }

    boolean isSwedish() {
        int luhns = calculateLuhns();
        int date = Integer.valueOf(this.pn.getBirthDate().substring(BIRTHDATE + 4, BIRTHNUMBER));
        if(date <= 31 && date >= 1 && luhns == this.pn.getControlNumber()) {
            return true;
        }
        return false;
    }

    private int calculateLuhns() {
        List result = new ArrayList();
        for(int c = 0; c < this.pn.fixed.length()-1; ++c) {
            String value;
            if(isEven(c)) {
                char a = this.pn.fixed.charAt(c);
                int aValue = Character.getNumericValue(a) * 2;
                value = Integer.toString(aValue);



            }
            else {
                char a = this.pn.fixed.charAt(c);
                int aValue = Character.getNumericValue(a);
                value = Integer.toString(aValue);
            }

            for(int i = 0; i < value.length(); ++i) {
                result.add(Character.getNumericValue(value.charAt(i)));
            }
        }
        int finalResult = 0;
        for(Object value: result) {
            finalResult += (Integer) value;
        }

        // skriv modulon babe
        finalResult = ( 10 - (finalResult % 10) ) % 10;

        return finalResult;

    }

    private boolean isEven(int c) {
        return ((c/2)*2 == c);
    }


  /*  boolean isCoordination() {

        int coordValue = Character.getNumericValue(pn.input.charAt(pn.COORDINATION));
        if(coordValue >= 61 && coordValue <= 91) {
            return true;
        }

    }

    boolean isOrganisation() {

        return true;
    }*/




}
