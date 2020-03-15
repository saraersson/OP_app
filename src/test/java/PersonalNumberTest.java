import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalNumberTest {


    @Test
    public void legitLength10_1() {
        PersonalNumber pn = new PersonalNumber("0002167829");
        pn.parseFormat();
        assert(pn.input.equals("200002167829"));
    }

    @Test
    public void legitLength10_2() {
        PersonalNumber pn = new PersonalNumber("9502167829");
        pn.parseFormat();
        assert(pn.input.equals("199502167829"));
    }

    @Test
    public void legitWithPlus_1() {
        PersonalNumber pn = new PersonalNumber("000216+7829");
        pn.parseFormat();
        assert(pn.input.equals("190002167829"));
    }

    @Test
    public void legitWithPlus_2() {
        PersonalNumber pn = new PersonalNumber("950216+7829");
        pn.parseFormat();
        assert(pn.input.equals("189502167829"));
    }

    @Test
    public void legit12Under() {
        PersonalNumber pn = new PersonalNumber("199502167829");
        pn.parseFormat();
        assert(pn.input.equals("199502167829"));
    }

    @Test
    public void legit12Above() {
        PersonalNumber pn = new PersonalNumber("189502167829");
        pn.parseFormat();
        assert(pn.input.equals("189502167829"));
    }

}