import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class PersonTest {

    @Test
    public void getAgeTest(){
        //given
        String name = "Roy";
        Person.Sex sex = Person.Sex.MALE;
        LocalDate birthday = LocalDate.of(1994,03, 04);
        String emailaddress = "me@whatever.com";
        Person person = new Person(name, sex, birthday, emailaddress);
        int expected = 27;

        //when
        int actual = person.getAge();

        //then
        Assert.assertEquals(expected, actual);


    }
}
