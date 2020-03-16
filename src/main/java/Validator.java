

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

        vc.narrowDownPossibilities();
        if(this.pn.type.isInvalid) {
            return false;
        }
        else return true;
       /* if(this.pn.type.canBeSwedish) {
            System.out.println("Could be Swedish");
           /* if (vc.isSwedish()) {
                return true;
            }*/
       /* }/*
        else if(vc.isCoordination(this.pn)) {
            return true;
        }
        else if(vc.isOrganisation(this.pn)) {
            return true;
        }
        */

    }






}
