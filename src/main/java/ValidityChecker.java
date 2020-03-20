
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
        if(this.pn.type.isInvalid) {
            this.pn.logger.invalidFormat();
            return false;
        }
        this.parseFormat();
        this.pn.logger.start("validating");

        final int luhns = calculateLuhns();
        if (this.isRegular(luhns)) {
            pn.logger.isRegular(true);
            return true;
        }
        else {
            pn.logger.isRegular(false);
        }

        if(this.isCoordination(luhns)) {
            pn.logger.isCoordination(true);
            return true;
        }
        else {
            pn.logger.isCoordination(false);
        }

        if(this.isOrganisation(luhns)) {
            pn.logger.isOrganisation(true);
            return true;
        }
        else {
            pn.logger.isOrganisation(false);
        }
        return false;

    }


    void parseFormat() {
            this.pn.parseBirthDate();
            this.pn.parseBirthNumber();
            this.pn.parseControlNumber();
            this.pn.logger.parsed();
    }

    boolean isRegular(final int luhns) {
        pn.logger.isType("regular");

        T_Date date = pn.getDate();
        if(isValidDate(date)) {
            pn.logger.date(true);
            if(luhns == this.pn.getControlNumber()) {
                pn.logger.luhns(luhns, true);
                pn.type.isRegular = true;
                return true;
            }
            pn.logger.luhns(luhns, false);
        }
        pn.logger.date(false);
        return false;
    }


    private boolean isValidDate(final T_Date dateToCheck) {
        String date = dateToCheck.day + "/" + dateToCheck.month + "/" + dateToCheck.year;
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
        for(int c = 0; c < this.pn.fixed.length()-1; ++c) {
            String value;
            if(isEven(c)) {
                final char a = this.pn.fixed.charAt(c);
                final int aValue = Character.getNumericValue(a) * 2;
                value = Integer.toString(aValue);
            }
            else {
                final char a = this.pn.fixed.charAt(c);
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


    boolean isCoordination(final int luhns) {
        pn.logger.isType("coordination");
        final T_Date date = pn.getDate();
        int coordValue = Integer.valueOf(pn.getDate().day);

        if(coordValue >= 61 && coordValue <= 91) {
            String underLyingDate = Integer.toString(coordValue - 60);
            date.day = underLyingDate;
            pn.logger.coordValue(true, coordValue);
            if(isValidDate(date)) {
                pn.logger.date(true);
                if(luhns == this.pn.getControlNumber()) {
                    pn.logger.luhns(luhns, true);
                    pn.type.isCoordination = true;
                    return true;
                }
                else {
                    pn.logger.luhns(luhns, false);
                }
            }
            pn.logger.date(false);
        }
        else {
            pn.logger.coordValue(false, coordValue);
        }
        return false;
    }

    boolean isOrganisation(final int luhns) {
        pn.logger.isType("organisation");
        if(this.pn.getPrefix().equals("16") || this.pn.input.length() == 11) {
            this.pn.logger.prefixOrLength(true);
            if(luhns == this.pn.getControlNumber()) {
                pn.logger.luhns(luhns, true);
                pn.type.isOrganisation = true;
                return true;
            }
        }
        this.pn.logger.prefixOrLength(false);
        return false;
    }




}
