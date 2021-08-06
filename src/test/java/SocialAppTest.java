import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class SocialAppTest {

    @Test
    public void addUserTest() {
        //given
        SocialApp app = new SocialApp();
        String name = "Roy";
        Person.Sex sex = Person.Sex.MALE;
        LocalDate birthday = LocalDate.of(1994, 03, 04);
        String emailaddress = "me@whatever.com";
        Person user = new PersonBuilder().setName(name).setSex(sex).setBirthday(birthday).setEmailAddress(emailaddress).createPerson();

        //when
        app.addUser(user);
        int actual = app.roster.size();

        //then
        Assert.assertEquals(1, actual);

    }

    @Test
    public void filterByAgeOlderThanTest (){
        //given
        SocialApp app = new SocialApp();
        String name = "Roy";
        Person.Sex sex = Person.Sex.MALE;
        LocalDate birthday = LocalDate.of(1994, 03, 04);
        String emailaddress = "me@whatever.com";
        Person user1 = new PersonBuilder().setName(name).setSex(sex).setBirthday(birthday).setEmailAddress(emailaddress).createPerson();
        Person user2 = new PersonBuilder().setName("Jim").setSex(Person.Sex.MALE).setBirthday(LocalDate.of(1987, 10, 13)).setEmailAddress(emailaddress).createPerson();


        //when
        app.addUser(user1);
        app.addUser(user2);
        int actual = app.roster.size();


        //then
        Assert.assertEquals(2, actual);
        app.printPersonsOlderThan(app.getList(), 21);
    }
    @Test
    public void filterByRange(){
        //given
        SocialApp app = new SocialApp();
        String name = "Roy";
        Person.Sex sex = Person.Sex.MALE;
        LocalDate birthday = LocalDate.of(1994, 03, 04);
        String emailaddress = "me@whatever.com";
        Person user1 = new PersonBuilder().setName(name).setSex(sex).setBirthday(birthday).setEmailAddress(emailaddress).createPerson();
        Person user2 = new PersonBuilder().setName("Jim").setSex(Person.Sex.MALE).setBirthday(LocalDate.of(1987, 10, 13)).setEmailAddress(emailaddress).createPerson();
        Person user3 = new PersonBuilder().setName("Pam").setSex(Person.Sex.FEMALE).createPerson();

        //when
        app.addUser(user1);
        app.addUser(user2);
        app.addUser(user3);
        int actual = app.roster.size();

        //then
        Assert.assertEquals(3, actual);
        app.printPersonsWithinAgeRange(app.getList(), 30, 40);

    }
}
