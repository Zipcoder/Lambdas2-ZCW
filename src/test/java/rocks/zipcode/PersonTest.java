package rocks.zipcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class PersonTest {

    @Before
    public void setUp() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");
    }

    @Test
    public void getAge() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");
        int actual = person1.getAge();
        int expected = 33;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void printPerson() {
    }

    @Test
    public void getName() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");
        String actual = person1.getName();
        String expected = "Brian";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setName() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");
        person2.setName("Muffin");
        String actual = person2.getName();
        String expected = "Muffin";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBirthday() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");

        LocalDate actual = person2.getBirthday();
        LocalDate expected = LocalDate.of(1999, 5, 05);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBirthday() {
            Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
            Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");
            person2.setBirthday(LocalDate.of(1998,5,20));
            LocalDate actual = person2.getBirthday();
            LocalDate expected = LocalDate.of(1998, 5, 20);
            Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGender() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");
        Person.Sex actual = person1.getGender();
        Person.Sex expected = Person.Sex.MALE;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmailAddress() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");
        String actual = person1.getEmailAddress();
        String expected = "email@address.com";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEmailAddress() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 5, 05), Person.Sex.FEMALE, "random@email.com");
        person1.setEmailAddress("emailz@address.com");
        String actual = person1.getEmailAddress();
        String expected = "emailz@address.com";
        Assert.assertEquals(expected, actual);
    }
}
