import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PersonTest {

    @Test
    public void getAgeTest(){
        //given
        String name = "Roy";
        Person.Sex sex = Person.Sex.MALE;
        LocalDate birthday = LocalDate.of(1994,03, 04);
        String emailaddress = "me@whatever.com";
        Person person = new PersonBuilder().setName(name).setSex(sex).setBirthday(birthday).setEmailAddress(emailaddress).createPerson();
        int expected = 27;

        //when
        int actual = person.getAge();

        //then
        Assert.assertEquals(expected, actual);


    }
}
