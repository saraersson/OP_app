class ValidityChecker {
    PersonalNumber pn;

    ValidityChecker(PersonalNumber pn) {
        this.pn = pn;
    }


    public void narrowDownPossibilities() {
        this.pn.parseFormat();
        this.pn.parseBirthDate();
        this.pn.parseBirthNumber();
        this.pn.parseControlNumber();

    }

   /* boolean isSwedish() {

        return true;
    }


    boolean isCoordination() {

        int coordValue = Character.getNumericValue(pn.input.charAt(pn.COORDINATION));
        if(coordValue >= 61 && coordValue <= 91) {
            return true;
        }

    }*/

    boolean isOrganisation() {

        return true;
    }


}
