

class Validator {

    PersonalNumber pn;

    private static int T_SWEDISH = 0;
    private static int T_COORDINATION = 1;
    private static int T_ORGANISATION = 2;

    Validator(String input) {
        this.pn = new PersonalNumber(input);
    }


    boolean isValid() {

        ValidityChecker vc = new ValidityChecker(this.pn);

        vc.validateFormat();
        if (this.pn.type.isInvalid) {
            return false;
        }


        if (vc.isSwedish()) {
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




}
