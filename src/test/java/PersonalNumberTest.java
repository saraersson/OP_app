import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalNumberTest {


    // parsing tests
    @Test
    public void legit10_1() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("0002167829"));
        vc.narrowDownPossibilities();

        assertEquals(vc.pn.fixed,"200002167829");
        assertEquals(vc.pn.getBirthDate(),"20000216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(),9);
        assertFalse(vc.pn.type.isInvalid);
    }

    @Test
    public void legit10_2() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("9502167829"));
        vc.narrowDownPossibilities();

        assertEquals(vc.pn.fixed,"199502167829");
        assertEquals(vc.pn.getBirthDate(),"19950216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(), 9);
        assertFalse(vc.pn.type.isInvalid);
    }

    @Test
    public void legit11Plus_1() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("000216+7829"));
        vc.narrowDownPossibilities();

        assertEquals(vc.pn.fixed,"190002167829");
        assertEquals(vc.pn.getBirthDate(),"19000216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(),9);
        assertFalse(vc.pn.type.isInvalid);
    }

    @Test
    public void legit11Plus_2() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("950216+7829"));
        vc.narrowDownPossibilities();

        assertEquals(vc.pn.fixed,"189502167829");
        assertEquals(vc.pn.getBirthDate(),"18950216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(),9);
        assertFalse(vc.pn.type.isInvalid);
    }

    @Test
    public void legit11Minus_1() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("890216-7829"));
        vc.narrowDownPossibilities();

        assertEquals(vc.pn.fixed,"198902167829");
        assertEquals(vc.pn.getBirthDate(),"19890216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(),9);
        assertFalse(vc.pn.type.isInvalid);
    }



    @Test
    public void legit12() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("199502167829"));
        vc.narrowDownPossibilities();

        assertEquals(vc.pn.fixed,"199502167829");
        assertEquals(vc.pn.getBirthDate(),"19950216");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(),9);
        assertFalse(vc.pn.type.isInvalid);
    }


    @Test
    public void legit13() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("20000525-7829"));
        vc.narrowDownPossibilities();

        assertEquals(vc.pn.fixed,"200005257829");
        assertEquals(vc.pn.getBirthDate(),"20000525");
        assertEquals(vc.pn.getBirthNumber(),"782");
        assertEquals(vc.pn.getControlNumber(), 9);
        assertFalse(vc.pn.type.isInvalid);
    }

    @Test
    public void invalid12_1() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("20000525-782"));
        vc.narrowDownPossibilities();

        assertTrue(vc.pn.type.isInvalid);
    }

    @Test
    public void invalid12_2() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("2000052-78292"));
        vc.narrowDownPossibilities();

        assertTrue(vc.pn.type.isInvalid);
    }

    @Test
    public void invalidShort() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("950216782"));
        vc.narrowDownPossibilities();

        assertTrue(vc.pn.type.isInvalid);
    }

    @Test
    public void invalidLong_1() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("95021678229"));
        vc.narrowDownPossibilities();

        assertTrue(vc.pn.type.isInvalid);
    }

    @Test
    public void invalidLong_2() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("1995021678229"));
        vc.narrowDownPossibilities();

        assertTrue(vc.pn.type.isInvalid);
    }
    @Test
    public void invalidLong_3() {
        ValidityChecker vc = new ValidityChecker(new PersonalNumber("19950216782290"));
        vc.narrowDownPossibilities();

        assertTrue(vc.pn.type.isInvalid);
    }


}