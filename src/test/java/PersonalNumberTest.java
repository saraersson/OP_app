import org.junit.Test;

import static org.junit.Assert.*;


public class PersonalNumberTest {


    @Test
    public void legitLength10() {
        PersonalNumber pn = new PersonalNumber("9502167829");
        pn.setAge();
        assert(pn.isYoungerThanHundred() == true);
    }

    @Test
    public void legitWithPlus() {
        PersonalNumber pn = new PersonalNumber("950216+7829");
        pn.setAge();
        assert(pn.isYoungerThanHundred() == false);
    }

    @Test
    public void legit12Under() {
        PersonalNumber pn = new PersonalNumber("199502167829");
        pn.setAge();
        assert(pn.isYoungerThanHundred() == true);
    }

    @Test
    public void legit12Above() {
        PersonalNumber pn = new PersonalNumber("189502167829");
        pn.setAge();
        assert(pn.isYoungerThanHundred() == false);
    }

}