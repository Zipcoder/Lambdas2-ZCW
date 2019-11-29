import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.rmi.server.RemoteServer;
import org.junit.Rule;

public class PersonTest {
    Person aswomeSister, secondBestSister, thirdBestSister, olderSister;
    java.util.ArrayList<Person> myFamily = new java.util.ArrayList<>();

    @Before
    public void setUp() throws Exception {
        aswomeSister = new Person("Charlotte Beale", java.time.LocalDate.of(1982, java.time.Month.AUGUST, 20), Person.Sex.FEMALE, "cbeale2000@gmail.com");
        secondBestSister = new Person("Ruth Beale", java.time.LocalDate.of(1980, java.time.Month.MARCH, 07), Person.Sex.FEMALE, "rbeale@gmail.com");
        thirdBestSister = new Person("Kesha Beale", java.time.LocalDate.of(1978, java.time.Month.AUGUST, 17), Person.Sex.FEMALE, "kbeale@gmail.com");
        olderSister = new Person("Kathleen Beale", java.time.LocalDate.of(1976, java.time.Month.FEBRUARY, 23), Person.Sex.FEMALE, "kbeale@hotmail.com");
        myFamily.add(aswomeSister);
        myFamily.add(secondBestSister);
        myFamily.add(thirdBestSister);
        myFamily.add(olderSister);


    }

    @Rule
    public final SystemOutRule systemOutRule= new SystemOutRule().enableLog();

    @Test
            public void printPersons() {
    String expected = "{ Name: Ruth Beale, Birthday: 1980-03-07, Gender: FEMALE, EmailAddress: rbeale@gmail.com}\n\n";
    Main.printPeople(myFamily, new CheckPerson() {
        @Override
        public Boolean test (Person person){
            return person.getAge() <= 18;
        }
    });
    Assert.assertEquals(expected, systemOutRule.getLog());
    }
    @Test
    public void printPersonLambda() {
        String expected = "{ Name: Charlotte Beale, Birthday: 1982-08-20, Gender: FEMALE, EmailAddress: cbeale2000@gmail.com}\n\n";
        Main.printPeople(myFamily, person -> person.getAge() >= 45 && person.getGender() == Person.Sex.FEMALE);
        Assert.assertEquals(expected, systemOutRule.getLog());
    }
}