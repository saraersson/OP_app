
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
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
            this.pn.logger.invalidFormat();
            return false;
        }
        this.parseFormat();
        this.pn.logger.startValidating();

        int luhns = calculateLuhns();
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

    boolean isRegular(int luhns) {
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


    private boolean isValidDate(T_Date dateToCheck) {
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

        finalResult = ( 10 - (finalResult % 10) ) % 10;

        return finalResult;
    }

    private boolean isEven(int c) {
        return ((c/2)*2 == c);
    }


    boolean isCoordination(int luhns) {
        pn.logger.isType("coordination");
        T_Date date = pn.getDate();
        int coordValue = Integer.valueOf(pn.getDate().day);

        if(coordValue >= 61 && coordValue <= 91) {
            String underLyingDate = Integer.toString(coordValue - 60);
            date.day = underLyingDate;

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
        return false;
    }

    boolean isOrganisation(int luhns) {
        pn.logger.isType("organisation");
        if(this.pn.getPrefix() == "16" || this.pn.input.length() == 11) {
            this.pn.logger.prefixOrLength(true);
            if(luhns == this.pn.getControlNumber()) {
                pn.logger.luhns(luhns, true);
                pn.type.isOrganisation = true;
                return true;
            }
        }
        else {
            this.pn.logger.prefixOrLength(false);
        }


        return true;
    }




}
