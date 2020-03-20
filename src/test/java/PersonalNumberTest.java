import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalNumberTest {


    // parsing tests
    @Test
    public void legitSwedish_1() {
        ValidityChecker vc = new ValidityChecker("1701102384");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }

    @Test
    public void legitSwedish_2() {
        ValidityChecker vc = new ValidityChecker("1412062380");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }


    @Test
    public void legitSwedish_3() {
        ValidityChecker vc = new ValidityChecker("7101169295");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }

    @Test
    public void legitSwedishPlus_1() {
        ValidityChecker vc = new ValidityChecker("900118+9811");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }

    @Test
    public void legitSwedishPlus_2() {
        ValidityChecker vc = new ValidityChecker("950216+7829");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }


    @Test
    public void legitSwedishMinus_1() {
        ValidityChecker vc = new ValidityChecker("20080903-2386");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }

    @Test
    public void legitSwedishMinus_2() {
        ValidityChecker vc = new ValidityChecker("940212-2429");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }


    @Test
    public void legit12() {
        ValidityChecker vc = new ValidityChecker("189102279800");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }


    @Test
    public void legit13() {
        ValidityChecker vc = new ValidityChecker("19451016-8885");
        assertTrue(vc.isValid());
        assertTrue(vc.pn.type.isRegular);
    }

    @Test
    public void legitcoor_1() {
        ValidityChecker vc = new ValidityChecker("190910799824");
        assertTrue(vc.isValid());
        assertFalse(vc.pn.type.isRegular);
        assertTrue(vc.pn.type.isCoordination);
    }




    @Test
    public void invalidNumber_1() {
        ValidityChecker vc = new ValidityChecker("20000525-4777");
        assertFalse(vc.isValid());
        assertFalse(vc.pn.type.isRegular);
        assertFalse(vc.pn.type.isCoordination);
        assertFalse(vc.pn.type.isOrganisation);

    }

    @Test
    // test invalid control number
    public void invalidNumber_2() {
        ValidityChecker vc = new ValidityChecker("201701272394");
        assertFalse(vc.isValid());

    }

    @Test
    // test invalid date
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

    @Test
    public void legitOrganisation_1() {
        ValidityChecker vc = new ValidityChecker("16556601-6399");
        assertTrue(vc.isValid());
        assertFalse(vc.pn.type.isRegular);
        assertFalse(vc.pn.type.isCoordination);
        assertTrue(vc.pn.type.isOrganisation);
    }

    @Test
    public void legitOrganisation_2() {
        ValidityChecker vc = new ValidityChecker("857202-7566");
        assertTrue(vc.isValid());
        assertFalse(vc.pn.type.isRegular);
        assertFalse(vc.pn.type.isCoordination);
        assertTrue(vc.pn.type.isOrganisation);

    }

    @Test
    public void legitOrganisation_3() {
        ValidityChecker vc = new ValidityChecker("262000-1111");
        assertTrue(vc.isValid());
        assertFalse(vc.pn.type.isRegular);
        assertFalse(vc.pn.type.isCoordination);
        assertTrue(vc.pn.type.isOrganisation);

    }


    @Test
    public void legitOrganisation_4() {
        ValidityChecker vc = new ValidityChecker("556614-3185");
        assertTrue(vc.isValid());
        assertFalse(vc.pn.type.isRegular);
        assertFalse(vc.pn.type.isCoordination);
        assertTrue(vc.pn.type.isOrganisation);


    }


}