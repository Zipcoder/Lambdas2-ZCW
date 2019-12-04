package lambdaslab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class testPerson {
    Person person;

    @Before
    public void setUp() {
        person = new Person("Wes", Person.Sex.MALE, LocalDate.of(1997, 8, 5), "wes@jones.com", true);
    }

    @Test
    public void testGetAge() {
        Integer actual = person.getAge();
        Integer expected = 22;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintPerson() {
        String actual = person.toString();
        String expected = "\nPerson:\n" +
                "\tName:\t\tWes\n" +
                "\tSex:\t\tMALE\n" +
                "\tBirthday:\t08-05-1997\n" +
                "\tEmail:\t\twes@jones.com\n";
        Assert.assertEquals(expected, actual);
    }
}
