package lambdaslab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class testSearch {
    List<Person> roster;

    @Before
    public void setUp() {
        PersonWareHouse pw = new PersonWareHouse();
        roster = pw.getRoster();
    }

    @Test
    public void testPrintPersonsOlderThan() {
        Integer actual = Search.printPersonsOlderThan(roster, 40).length();
        Integer expected = 162;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintPersonsWithinAgeRange() {
        Integer actual = Search.printPersonsWithinAgeRange(roster, 25, 55).length();
        Integer expected = 241;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintPersons1() {
        Integer actual = Search.printPersons(roster, new Check(0)).length();
        Integer expected = 158;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintPersons2() {
        Integer actual = Search.printPersons(roster, new Check(1)).length();
        Integer expected = 160;
        Assert.assertEquals(expected, actual);
    }
}
