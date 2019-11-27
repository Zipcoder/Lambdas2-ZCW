import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class PersonTest {
    Person tp;


    @Test
    public void testConstructorWithParameters() {
        // Given
        Integer expectedAge = 37;
        String expectedName = "Waldo";
        LocalDate birthdayExpected = LocalDate.parse("07-08-1982");
        Person.Sex expectedSex = Person.Sex.MALE;
        String emailExpected = "wheresWaldo@gmail.com";

        // When
        Person person = new Person(expectedName, birthdayExpected, expectedSex, emailExpected);

        // Then

        String actualName = person.getName();
        Integer actualAge = person.getAge();
        Person.Sex actualSex = person.getGender();
        String actualEmail = person.getEmailAddress();
        LocalDate actualBirthday = person.getBirthday();

        Assert.assertEquals(expectedAge, actualAge);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSex, actualSex);
        Assert.assertEquals(emailExpected, actualEmail);
        Assert.assertEquals(birthdayExpected, actualBirthday);
    }

    @Before
    public void setUp() throws Exception {
        tp = new Person("John Doe", LocalDate.of(1976, Month.JANUARY, 10), Person.Sex.MALE, "johndoe@gmail.com");
    }

    @Test
    public void setName() {
        String expectedName = "Ricardo Montana";
        tp.setName("Ricardo Montana");
        String actual = tp.getName();
        Assert.assertEquals(expectedName, actual);
    }

    @Test
    public void setBirthday() {
        LocalDate expected = LocalDate.of(1993, Month.APRIL, 22);
        tp.setBirthday(expected);
        LocalDate actual = tp.getBirthday();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setGender() {
        Person.Sex expected = Person.Sex.FEMALE;
        tp.setGender(expected);
        Person.Sex actual = tp.getGender();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEmailAddress() {
        String expectedEmail = "JD455@hotmail.com";
        tp.setEmailAddress(expectedEmail);
        String actualEmail = tp.getEmailAddress();
        Assert.assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void print () {
        tp.printPerson();
    }
}
