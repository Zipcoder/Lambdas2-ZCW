package rocks.zipcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.time.LocalDate;

public class SearchesTest {
    SocialNetworks networks = new SocialNetworks();


    @Before
    public void setUp() {
        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 11, 10), Person.Sex.FEMALE, "random@email.com");
        Person person3 = new Person("Peoples", LocalDate.of(1983, 6, 20), Person.Sex.MALE, "email30@address.com");
        Person person4 = new Person("Jojo", LocalDate.of(1972, 5, 5), Person.Sex.FEMALE, "random2@email.com");
        Person person5 = new Person("Faye", LocalDate.of(1994, 2, 14), Person.Sex.MALE, "email25@address.com");
        Person person6 = new Person("Boberto", LocalDate.of(2003, 4, 21), Person.Sex.FEMALE, "random45@email.com");
        Person person7 = new Person("Guy", LocalDate.of(1969, 1, 3), Person.Sex.MALE, "email50@address.com");
        Person person8 = new Person("Smiley", LocalDate.of(2008, 12, 8), Person.Sex.FEMALE, "random77@email.com");
        Person[] peeps = {person1, person2, person3, person4, person5, person6, person7, person8};

        for (int i = 0; i < peeps.length; i++) {
            networks.add(peeps[i]);
        }
    }


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void writesTextToSystemOut() {
        class Under30 implements CheckPerson {
            @Override
            public boolean test(Person person) {
                return person.getAge() <= 30;
            }
        }
        Main.printPersons(networks.get(), new Under30());
        String actual = "Person = Rando, birthday = 1999-11-10, gender = FEMALE, Age = 20, emailAddress = random@email.com\n\n" +
                "Person = Faye, birthday = 1994-02-14, gender = MALE, Age = 25, emailAddress = email25@address.com\n\n" +
                "Person = Boberto, birthday = 2003-04-21, gender = FEMALE, Age = 16, emailAddress = random45@email.com\n\n" +
                "Person = Smiley, birthday = 2008-12-08, gender = FEMALE, Age = 10, emailAddress = random77@email.com\n\n";

        Assert.assertEquals(systemOutRule.getLog(),actual);


    }


}

