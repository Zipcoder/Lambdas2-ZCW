import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class PersonTest {
    Person person = new Person();

@Test
public void personConstructor(){
    String expectedName = "";
    LocalDate expectedBirthday= LocalDate.of(1976, Month.JANUARY, 10);
    Person.Sex expectedGender = Person.Sex.MALE;
    String expectedEmailAddress ="";
    Person person = new Person(expectedName,expectedBirthday,expectedGender,expectedEmailAddress);
    person.setName(expectedName);
    person.setBirthday(expectedBirthday);
    person.setGender(expectedGender);
    person.setEmailAddress(expectedEmailAddress);
    String actualName = person.getName();
    LocalDate actualBirthday = person.getBirthday();
    Person.Sex actualGender = person.getGender();
    String actualEmailAddress = person.getEmailAddress();
    Assert.assertEquals(expectedName,actualName);
    Assert.assertEquals(expectedBirthday,actualBirthday);
    Assert.assertEquals(expectedGender,actualGender);
    Assert.assertEquals(expectedEmailAddress,actualEmailAddress);
}
    @Test
    public void setName() {
        String expectedName = "Ricardo Montana";
        person.setName("Ricardo Montana");
        String actual = person.getName();
        Assert.assertEquals(expectedName, actual);
    }

    @Test
    public void setBirthday() {
        LocalDate expected = LocalDate.of(1993, Month.APRIL, 22);
        person.setBirthday(expected);
        LocalDate actual = person.getBirthday();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setGender() {
        Person.Sex expected = Person.Sex.FEMALE;
        person.setGender(expected);
        Person.Sex actual = person.getGender();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEmailAddress() {
        String expectedEmail = "JD455@hotmail.com";
        person.setEmailAddress(expectedEmail);
        String actualEmail = person.getEmailAddress();
        Assert.assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void print () {
        person.printPerson();
    }
}


