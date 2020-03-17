import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalNumberTest {


    // parsing tests
    @Test
    public void legitSwedish_1() {
        ValidityChecker vc = new ValidityChecker("0005254776");
        vc.isValid();

        assertEquals(vc.pn.fixed,"0005254776");
        assertEquals(vc.pn.getBirthDate(),"000525");
        assertEquals(vc.pn.getBirthNumber(),"477");
        assertEquals(vc.pn.getControlNumber(),6);
        assertFalse(vc.pn.type.isInvalid);
        assertTrue(vc.isSwedish());
    }
/*
    @Test
    public void legitSwedish_2() {
        ValidityChecker vc = new ValidityChecker("9502167829");
        vc.isValid();

        assertEquals(vc.pn.fixed,"9502167829");
        assertEquals(vc.pn.getBirthDate(),"950216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(), 9);
        assertFalse(vc.pn.type.isInvalid);
        assertTrue(vc.isSwedish());
    }


    @Test
    public void legitSwedish_3() {
        ValidityChecker vc = new ValidityChecker("9402122429");
        vc.isValid();

        assertEquals(vc.pn.fixed,"9402122429");
        assertEquals(vc.pn.getBirthDate(),"940212");
        assertEquals(vc.pn.getBirthNumber(),"242");
        assertEquals(vc.pn.getControlNumber(), 9);
        assertFalse(vc.pn.type.isInvalid);
        assertTrue(vc.isSwedish());
    }

    @Test
    public void legitSwedishPlus_1() {
        ValidityChecker vc = new ValidityChecker("000525+4776");
        vc.isValid();

        assertEquals(vc.pn.fixed,"0005254776");
        assertEquals(vc.pn.getBirthDate(),"000525");
        assertEquals(vc.pn.getBirthNumber(),"477");
        assertEquals(vc.pn.getControlNumber(),6);
        assertFalse(vc.pn.type.isInvalid);
    }

    @Test
    public void legitSwedishPlus_2() {
        ValidityChecker vc = new ValidityChecker("950216+7829");
        vc.isValid();

        assertEquals(vc.pn.fixed,"9502167829");
        assertEquals(vc.pn.getBirthDate(),"950216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(),9);
        assertFalse(vc.pn.type.isInvalid);
    }


    @Test
    public void legitSwedishMinus_1() {
        ValidityChecker vc = new ValidityChecker("000525-4776");
        vc.isValid();

        assertEquals(vc.pn.fixed,"0005254776");
        assertEquals(vc.pn.getBirthDate(),"000525");
        assertEquals(vc.pn.getBirthNumber(),"477");
        assertEquals(vc.pn.getControlNumber(),6);
        assertFalse(vc.pn.type.isInvalid);
    }

    @Test
    public void legitSwedishMinus_2() {
        ValidityChecker vc = new ValidityChecker("940212-2429");
        vc.isValid();

        assertEquals(vc.pn.fixed,"9402122429");
        assertEquals(vc.pn.getBirthDate(),"940212");
        assertEquals(vc.pn.getBirthNumber(),"242");
        assertEquals(vc.pn.getControlNumber(), 9);
        assertFalse(vc.pn.type.isInvalid);
        assertTrue(vc.isSwedish());
    }


    @Test
    public void legit12() {
        ValidityChecker vc = new ValidityChecker("199502167829");
        vc.isValid();

        assertEquals(vc.pn.fixed,"9502167829");
        assertEquals(vc.pn.getBirthDate(),"950216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(),9);
        assertFalse(vc.pn.type.isInvalid);
    }


    @Test
    public void legit13() {
        ValidityChecker vc = new ValidityChecker("20000525-4776");
        vc.isValid();

        assertEquals(vc.pn.fixed,"0005254776");
        assertEquals(vc.pn.getBirthDate(),"000525");
        assertEquals(vc.pn.getBirthNumber(),"477");
        assertEquals(vc.pn.getControlNumber(),6);
        assertFalse(vc.pn.type.isInvalid);
    }

    @Test
    public void invalidFormat_1() {
        ValidityChecker vc = new ValidityChecker("20000525-782");
        vc.pn.checkFormat();
        assertTrue(vc.pn.type.isInvalid);

    }

    @Test
    public void invalidFormat_2() {
        ValidityChecker vc = new ValidityChecker("2000052-78292");
        vc.pn.checkFormat();
        assertTrue(vc.pn.type.isInvalid);

    }

    @Test
    public void invalidFormat_3() {
        ValidityChecker vc = new ValidityChecker("950216782");
                vc.pn.checkFormat();
        assertTrue(vc.pn.type.isInvalid);

    }

    @Test
    public void invalidFormat_4() {
        ValidityChecker vc = new ValidityChecker("95021678229");
        vc.pn.checkFormat();
        assertTrue(vc.pn.type.isInvalid);
    }

    @Test
    public void invalidFormat_5() {
        ValidityChecker vc = new ValidityChecker("1995021678229");
        vc.pn.checkFormat();
        assertTrue(vc.pn.type.isInvalid);

    }*/


}