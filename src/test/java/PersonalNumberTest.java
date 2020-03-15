import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalNumberTest {
    PersonalNumber pn;

    @Test
    public void legitLength10_1() {
        this.pn = new PersonalNumber("0002167829");
        this.pn.parseFormat();
        this.pn.parseBirthDate();
        this.pn.parseBirthNumber();
        this.pn.parseControlNumber();

        assertEquals(this.pn.input,"200002167829");
        assertEquals(this.pn.getBirthDate(),"20000216");
        assertEquals(this.pn.getBirthNumber(),"782");
        assertEquals(this.pn.getControlNumber(),9);
    }

    @Test
    public void legitLength10_2() {
        this.pn = new PersonalNumber("9502167829");
        this.pn.parseFormat();
        this.pn.parseBirthDate();
        this.pn.parseBirthNumber();
        this.pn.parseControlNumber();

        assertEquals(this.pn.input,"199502167829");
        assertEquals(this.pn.getBirthDate(),"19950216");
        assertEquals(this.pn.getBirthNumber(),"782");
        assertEquals(this.pn.getControlNumber(), 9);
    }

    @Test
    public void legitWithPlus_1() {
        this.pn = new PersonalNumber("000216+7829");
        this.pn.parseFormat();
        this.pn.parseBirthDate();
        this.pn.parseBirthNumber();
        this.pn.parseControlNumber();

        assertEquals(this.pn.input,"190002167829");
        assertEquals(this.pn.getBirthDate(),"19000216");
        assertEquals(this.pn.getBirthNumber(),"782");
        assertEquals(this.pn.getControlNumber(),9);
    }

    @Test
    public void legitWithPlus_2() {
        this.pn = new PersonalNumber("950216+7829");
        this.pn.parseFormat();
        this.pn.parseBirthDate();
        this.pn.parseBirthNumber();
        this.pn.parseControlNumber();

        assertEquals(this.pn.input,"189502167829");
        assertEquals(this.pn.getBirthDate(),"18950216");
        assertEquals(this.pn.getBirthNumber(),"782");
        assertEquals(this.pn.getControlNumber(),9);
    }

    @Test
    public void legit12Under() {
        this.pn = new PersonalNumber("199502167829");
        this.pn.parseFormat();
        this.pn.parseBirthDate();
        this.pn.parseBirthNumber();
        this.pn.parseControlNumber();

        assertEquals(this.pn.input,"199502167829");
        assertEquals(this.pn.getBirthDate(),"19950216");
        assertEquals(this.pn.getBirthNumber(),"782");
        assertEquals(this.pn.getControlNumber(),9);
    }

    @Test
    public void legit12Above() {
        this.pn = new PersonalNumber("189502167829");
        this.pn.parseFormat();
        this.pn.parseBirthDate();
        this.pn.parseBirthNumber();
        this.pn.parseControlNumber();

        assertEquals(this.pn.input,"189502167829");
        assertEquals(this.pn.getBirthDate(),"18950216");
        assertEquals(this.pn.getBirthNumber(),"782");
        assertEquals(this.pn.getControlNumber(), 9);
    }




}