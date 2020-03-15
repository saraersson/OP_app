import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalNumberTest {
    PersonalNumber pn;

    @Test
    public void legitLength10_1() {
        this.pn = new PersonalNumber("0002167829");
        this.pn.parseFormat();
        assert(this.pn.input.equals("200002167829"));
    }

    @Test
    public void legitLength10_2() {
        this.pn = new PersonalNumber("9502167829");
        this.pn.parseFormat();
        assert(this.pn.input.equals("199502167829"));
    }

    @Test
    public void legitWithPlus_1() {
        this.pn = new PersonalNumber("000216+7829");
        this.pn.parseFormat();
        assert(this.pn.input.equals("190002167829"));
    }

    @Test
    public void legitWithPlus_2() {
        this.pn = new PersonalNumber("950216+7829");
        this.pn.parseFormat();
        assert(this.pn.input.equals("189502167829"));
    }

    @Test
    public void legit12Under() {
        this.pn = new PersonalNumber("199502167829");
        this.pn.parseFormat();
        assert(this.pn.input.equals("199502167829"));
    }

    @Test
    public void legit12Above() {
        this.pn = new PersonalNumber("189502167829");
        this.pn.parseFormat();
        assert(this.pn.input.equals("189502167829"));
    }

}