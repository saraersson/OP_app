import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalNumberTest {


    // parsing tests
    @Test
    public void legitSwedish_1() {
        ValidityChecker vc = new ValidityChecker("0005254776");
        assertTrue(vc.isValid());
    }

    @Test
    public void legitSwedish_2() {
        ValidityChecker vc = new ValidityChecker("9502167829");
        assertTrue(vc.isValid());
    }


    @Test
    public void legitSwedish_3() {
        ValidityChecker vc = new ValidityChecker("9402122429");
        assertTrue(vc.isValid());
    }

    @Test
    public void legitSwedishPlus_1() {
        ValidityChecker vc = new ValidityChecker("000525+4776");
        assertTrue(vc.isValid());
    }

    @Test
    public void legitSwedishPlus_2() {
        ValidityChecker vc = new ValidityChecker("950216+7829");
        assertTrue(vc.isValid());
    }


    @Test
    public void legitSwedishMinus_1() {
        ValidityChecker vc = new ValidityChecker("000525-4776");
        assertTrue(vc.isValid());
    }

    @Test
    public void legitSwedishMinus_2() {
        ValidityChecker vc = new ValidityChecker("940212-2429");
        assertTrue(vc.isValid());
    }


    @Test
    public void legit12() {
        ValidityChecker vc = new ValidityChecker("199502167829");
        assertTrue(vc.isValid());
    }


    @Test
    public void legit13() {
        ValidityChecker vc = new ValidityChecker("20000525-4776");
        assertTrue(vc.isValid());
    }

    @Test
    public void invalidNumber_1() {
        ValidityChecker vc = new ValidityChecker("20000525-4777");
        assertFalse(vc.isValid());

    }

    @Test
    public void invalidNumber_2() {
        ValidityChecker vc = new ValidityChecker("201701272394");
        assertFalse(vc.isValid());

    }

    @Test
    public void invalidNumber_3() {
        ValidityChecker vc = new ValidityChecker("190302299813");
        assertFalse(vc.isValid());

    }


    @Test
    public void invalidFormat_1() {
        ValidityChecker vc = new ValidityChecker("20000525-782");
        assertFalse(vc.isValid());

    }

    @Test
    public void invalidFormat_2() {
        ValidityChecker vc = new ValidityChecker("2000052-78292");
        assertFalse(vc.isValid());

    }

    @Test
    public void invalidFormat_3() {
        ValidityChecker vc = new ValidityChecker("950216782");
        assertFalse(vc.isValid());

    }

    @Test
    public void invalidFormat_4() {
        ValidityChecker vc = new ValidityChecker("95021678229");
        assertFalse(vc.isValid());
    }

    @Test
    public void invalidFormat_5() {
        ValidityChecker vc = new ValidityChecker("1995021678229");
        assertFalse(vc.isValid());

    }


}