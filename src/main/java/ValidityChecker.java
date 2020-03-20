
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;

import java.util.List;



class ValidityChecker {

    PersonalNumber pn;

    final static int BIRTHDATE = 0;
    final static int COORDINATION = 9;
    final static int BIRTHNUMBER = 6;
    final static int CONTROLNUMBER = 9;

    ValidityChecker(final String input) {
        this.pn = new PersonalNumber(input);
    }


    boolean isValid() {
        this.pn.checkFormat();
        if(this.pn.getType().isInvalid) {
            this.pn.getLogger().invalidFormat();
            return false;
        }
        this.parseFormat();
        this.pn.getLogger().start("validating");

        final int luhns = calculateLuhns();
        if (this.isRegular(luhns)) {
            pn.getLogger().isRegular(true);
            return true;
        }
        else {
            pn.getLogger().isRegular(false);
        }

        if(this.isCoordination(luhns)) {
            pn.getLogger().isCoordination(true);
            return true;
        }
        else {
            pn.getLogger().isCoordination(false);
        }

        if(this.isOrganisation(luhns)) {
            pn.getLogger().isOrganisation(true);
            return true;
        }
        else {
            pn.getLogger().isOrganisation(false);
        }
        return false;

    }


    private void parseFormat() {
            this.pn.parseBirthDate();
            this.pn.parseControlNumber();
            this.pn.getLogger().parsed();
    }

   private boolean isRegular(final int luhns) {
        pn.getLogger().isType("regular");

        final T_Date date = pn.getDate();
        if(isValidDate(date)) {
            pn.getLogger().date(true);
            if(luhns == this.pn.getControlNumber()) {
                pn.getLogger().luhns(luhns, true);
                pn.getType().isRegular = true;
                return true;
            }
            pn.getLogger().luhns(luhns, false);
            return false;
        }
        pn.getLogger().date(false);
        return false;
    }

    private boolean isValidDate(final T_Date dateToCheck) {
        final String date = dateToCheck.day + "/" + dateToCheck.month + "/" + dateToCheck.year;
        DateTimeFormatter f = DateTimeFormatter.ofPattern ("dd/MM/uuuu");
        f = f.withResolverStyle ( ResolverStyle.STRICT );
        try {
            LocalDate.parse (date , f );
            return true;
        } catch ( DateTimeParseException e ) {
            return false;
        }
    }

    private int calculateLuhns() {
        List result = new ArrayList();
        for(int c = 0; c < this.pn.getFixed().length()-1; ++c) {
            String value;
            if(isEven(c)) {
                final char a = this.pn.getFixed().charAt(c);
                final int aValue = Character.getNumericValue(a) * 2;
                value = Integer.toString(aValue);
            }
            else {
                final char a = this.pn.getFixed().charAt(c);
                final int aValue = Character.getNumericValue(a);
                value = Integer.toString(aValue);
            }

            for(int i = 0; i < value.length(); ++i) {
                result.add(Character.getNumericValue(value.charAt(i)));
            }
        }
        int finalResult = 0;
        for(final Object value: result) {
            finalResult += (Integer) value;
        }
        finalResult = ( 10 - (finalResult % 10) ) % 10;
        return finalResult;
    }

    private boolean isEven(final int c) {
        return ((c/2)*2 == c);
    }


    private boolean isCoordination(final int luhns) {
        pn.getLogger().isType("coordination");
        final T_Date date = pn.getDate();
        final int coordValue = Integer.valueOf(pn.getDate().day);

        if(coordValue >= 61 && coordValue <= 91) {
            String underLyingDate = Integer.toString(coordValue - 60);
            date.day = underLyingDate;
            pn.getLogger().coordValue(true, coordValue);
            if(isValidDate(date)) {
                pn.getLogger().date(true);
                if(luhns == this.pn.getControlNumber()) {
                    pn.getLogger().luhns(luhns, true);
                    pn.getType().isCoordination = true;
                    return true;
                }
                pn.getLogger().luhns(luhns, false);
                return false;
            }
            pn.getLogger().date(false);
            return false;
        }
        pn.getLogger().coordValue(false, coordValue);
        return false;
    }

    private boolean isOrganisation(final int luhns) {
        pn.getLogger().isType("organisation");
        if(this.pn.getPrefix().equals("16") || this.pn.getInput().length() == 11) {
            this.pn.getLogger().prefixOrLength(true);
            if(luhns == this.pn.getControlNumber()) {
                pn.getLogger().luhns(luhns, true);
                int orgValue = this.pn.getOrganisationNumber();
                if(orgValue >= 20) {
                    this.pn.getLogger().orgValue(true, orgValue);
                    pn.getType().isOrganisation = true;
                    return true;
                }
                this.pn.getLogger().orgValue(false, orgValue);
                return false;
            }
            pn.getLogger().luhns(luhns, false);
            return false;
        }
        this.pn.getLogger().prefixOrLength(false);
        return false;
    }




}
