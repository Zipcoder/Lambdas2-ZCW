
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MainTest {

    Person p, p1, p2, p3, p4, p5;
    ArrayList<Person> myPeeps = new ArrayList<>(0);

    @Before
    public void setUp() throws Exception {
        p = new Person("Augustus", LocalDate.of(1990, Month.APRIL, 22), Person.Sex.MALE, "CaeAugus@gmail.com");
        p1 = new Person("Appolonia", LocalDate.of(1970, Month.AUGUST, 12), Person.Sex.FEMALE, "Appy@gmail.com");
        p2 = new Person("Hadrian", LocalDate.of(1980, Month.JULY, 18), Person.Sex.MALE, "Haddy@gmail.com");
        p3 = new Person("Caesar", LocalDate.of(2001, Month.MARCH, 7), Person.Sex.MALE, "Cdogg@gmail.com");
        p4 = new Person("Cleopatra", LocalDate.of(2003, Month.MAY, 22), Person.Sex.FEMALE, "Cleo@gmail.com");
        p5 = new Person("Mark Anthony", LocalDate.of(1993, Month.DECEMBER, 4), Person.Sex.MALE, "markant@yahoo.com");
        myPeeps.add(p);
        myPeeps.add(p1);
        myPeeps.add(p2);
        myPeeps.add(p3);
        myPeeps.add(p4);
        myPeeps.add(p5);
    }

    @Test
    public void printPersonsLocalClass() {
        String expected = "Person Object{ Name: Appolonia, Birthday: 1970-08-12, Gender: FEMALE, EmailAddress: Appy@gmail.com}";
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sink, true));
        class checkForOver18 implements CheckPerson {
            @Override  //Function we're implementing from the Interface below
            public Boolean test(Person person) {
                return person.getGender() == Person.Sex.FEMALE &&
                        person.getAge() > 35;
            }
        }
        Main.printPersons(myPeeps, new checkForOver18());
        assertThat(new String(sink.toByteArray()), containsString(expected));
    }                                                                       //matches if the output contains this information.
                                                                            //Works in this case, because it's just the one person, so it does contain this substring.
                                                                            //Better way below.


    @Test
    public void printPersonsLocalClass2() {
        String expected = "Person Object{ Name: Appolonia, Birthday: 1970-08-12, Gender: FEMALE, EmailAddress: Appy@gmail.com}";
        class checkForOver18 implements CheckPerson {
            @Override  //Function we're implementing from the Interface below
            public Boolean test(Person person) {
                return person.getGender() == Person.Sex.FEMALE &&
                        person.getAge() > 35;
            }
        }
        Main.printPersons(myPeeps, new checkForOver18());
    }



    @Test
    public void printPersonsAnonymousClass() {
        String expected = "Person Object{ Name: Caesar, Birthday: 2001-03-07, Gender: MALE, EmailAddress: Cdogg@gmail.com}";
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sink, true));
        Main.printPersons(myPeeps, new CheckPerson() {
            @Override // Function we're implementing from the interface below
            public Boolean test(Person person) {
                return person.getAge() <= 18;
            }
        });
            assertThat(new String(sink.toByteArray()), containsString(expected));

    }
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void printPersonsAnonymousClass2() {
        String expected = "Person Object{ Name: Caesar, Birthday: 2001-03-07, Gender: MALE, EmailAddress: Cdogg@gmail.com}\n\nPerson Object{ Name: Cleopatra, Birthday: 2003-05-22, Gender: FEMALE, EmailAddress: Cleo@gmail.com}\n\n";
        Main.printPersons(myPeeps, new CheckPerson() {
            @Override // Function we're implementing from the interface below
            public Boolean test(Person person) {
                return person.getAge() <= 18;
            }
        });
        Assert.assertEquals(expected, systemOutRule.getLog());
    }


    @Test
    public void printPersonsLambda () {
        String expected = "Person Object{ Name: Appolonia, Birthday: 1970-08-12, Gender: FEMALE, EmailAddress: Appy@gmail.com}\n\n";
        Main.printPersons(myPeeps, person -> person.getAge() >= 45 && person.getGender() == Person.Sex.FEMALE);
        Assert.assertEquals(expected, systemOutRule.getLog());
    }


    }

