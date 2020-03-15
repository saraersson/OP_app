import org.junit.Test;

import static org.junit.Assert.*;


public class PersonalNumberTest {


    @Test
    public void testUnder() {
        PersonalNumber pn = new PersonalNumber("9502167829");
        pn.setAge();
        assert(pn.isYoungerThanHundred() == true);
    }

    @Test
    public void testAbove() {
        PersonalNumber pn = new PersonalNumber("950216+7829");
        pn.setAge();
        assert(pn.isYoungerThanHundred() == false);
    }

    @Test
    public void testAbove2() {
        PersonalNumber pn = new PersonalNumber("199502167829");
        pn.setAge();
        assert(pn.isYoungerThanHundred() == false);
    }

}