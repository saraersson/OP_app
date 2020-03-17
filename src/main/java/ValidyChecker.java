import java.util.ArrayList;
import java.util.List;

class ValidityChecker {
    PersonalNumber pn;

    ValidityChecker(PersonalNumber pn) {
        this.pn = pn;
    }


    void validateFormat() {
        this.pn.parseFormat();
        if(!this.pn.type.isInvalid) {
            this.pn.parseBirthDate();
            this.pn.parseBirthNumber();
            this.pn.parseControlNumber();
        }

    }

    boolean isSwedish() {
        int luhns = calculateLuhns();
        return true;
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
