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
    public void testExWithLocalClass() {
        // get Persons with age >= 42
        String actual = Search.exWithLocalClass(roster);
        String expected = "\n" +
                "Person:\n" +
                "\tName:\t\tKai\n" +
                "\tSex:\t\tFEMALE\n" +
                "\tBirthday:\t04-02-1970\n" +
                "\tEmail:\t\tKai@email.com\n" +
                "\n" +
                "Person:\n" +
                "\tName:\t\tRyan\n" +
                "\tSex:\t\tMALE\n" +
                "\tBirthday:\t02-29-1960\n" +
                "\tEmail:\t\tRyan@email.com\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testExWithLambdas() {
        // get Persons with age >= 42
        String actual = Search.exWithLambdas(roster);
        String expected = "\n" +
                "Person:\n" +
                "\tName:\t\tKai\n" +
                "\tSex:\t\tFEMALE\n" +
                "\tBirthday:\t04-02-1970\n" +
                "\tEmail:\t\tKai@email.com\n" +
                "\n" +
                "Person:\n" +
                "\tName:\t\tRyan\n" +
                "\tSex:\t\tMALE\n" +
                "\tBirthday:\t02-29-1960\n" +
                "\tEmail:\t\tRyan@email.com\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testExWithAnonClass() {
        // get Persons with gender MALE
        String actual = Search.exWithAnonClass(roster);
        String expected = "\n" +
                "Person:\n" +
                "\tName:\t\tWes\n" +
                "\tSex:\t\tMALE\n" +
                "\tBirthday:\t05-22-1980\n" +
                "\tEmail:\t\tWes@email.com\n" +
                "\n" +
                "Person:\n" +
                "\tName:\t\tRyan\n" +
                "\tSex:\t\tMALE\n" +
                "\tBirthday:\t02-29-1960\n" +
                "\tEmail:\t\tRyan@email.com\n";
        Assert.assertEquals(expected, actual);
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
