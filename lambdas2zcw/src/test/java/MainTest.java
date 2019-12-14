import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.hamcrest.CoreMatchers;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
//import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MainTest {
    Person tp, tp1, tp2, tp3, tp4, tp5;
    ArrayList<Person> myPeeps = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        tp = new Person("rashmi bapat", LocalDate.of(1994, Month.APRIL, 19), Person.Sex.FEMALE, "rbrashmi1@rediffmail.com");
        //TODO create tp1,tp2,tp3,tp4;
        tp1 = new Person("manasi bhide", LocalDate.of(1985, Month.AUGUST, 12), Person.Sex.FEMALE, "manasib123@yahoo.com");
        tp2 = new Person("kedar limaye", LocalDate.of(1983, Month.DECEMBER, 2), Person.Sex.MALE, "klimaye@gmail.com");
        tp3 = new Person("keya param", LocalDate.of(2010, Month.JUNE, 23), Person.Sex.FEMALE, "k23parm@gmx.com");
        tp4 = new Person("raja kotak", LocalDate.of(2015, Month.FEBRUARY, 28), Person.Sex.MALE, "rajaKotak11@yahoo.com");
        tp5 = new Person("risha kapoor", LocalDate.of(2011, Month.JULY, 25), Person.Sex.FEMALE, "risha23@gmail.com");
        myPeeps.add(tp);
        //add rest tp1,...
        myPeeps.add(tp1);
        myPeeps.add(tp2);
        myPeeps.add(tp3);
        myPeeps.add(tp4);
        myPeeps.add(tp5);
    }

    @Test
    public void printPersonsLocalClass() {
        String expected = "Person Object{ Name: manasi bhide, Birthday: 1994, Month.APRIL, 19, Gender: FEMALE, EmailAddress: manasib123@yahoo.com}";
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sink, true));
        class checkForOver18 implements CheckPerson {
            @Override  //Function we're implementing from the Interface below
            public Boolean test(Person person) {
                return person.getGender() == Person.Sex.FEMALE &&
                        person.getAge() > 35;
            }
        }
        MainClass.printPersons(myPeeps, new checkForOver18());
        // assertThat(new String(sink.toByteArray()), containsString(expected));
    }                                                                       //matches if the output contains this information.
    //Works in this case, because it's just the one person, so it does contain this substring.
    //Better way below.


    @Test
    public void printPersonsLocalClass2() {
        String expected = "Person Object{ Name: manasi bhide, Birthday: 1994, Month.APRIL, 19, Gender: FEMALE, EmailAddress: rbrashmi1@rediffmail.com}";
        class checkForOver18 implements CheckPerson {
            @Override  //Function we're implementing from the Interface below
            public Boolean test(Person person) {
                return person.getGender() == Person.Sex.FEMALE &&
                        person.getAge() > 35;
            }
        }
        MainClass.printPersons(myPeeps, new checkForOver18());
    }


    @Test
    public void printPersonsAnonymousClass() {
        String expected = "Person Object{ Name: risha kapoor, Birthday: 2011, Month.JULY, 25, Gender: FEMALE, EmailAddress: risha23@gmail.com}";
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sink, true));
        MainClass.printPersons(myPeeps, new CheckPerson() {
            @Override // Function we're implementing from the interface below
            public Boolean test(Person person) {
                return person.getAge() <= 18;
            }
        });
        //Assert.assertEquals(new String(sink.toByteArray()), containsString(expected));

    }


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();



    @Test
    public void printPersonsLambda() {
        String expected = "Person Object{Name: rashmi bapat, Birthday: 1994-04-19, Gender: FEMALE, EmailAddress: rbrashmi1@rediffmail.com}" + "\n" + "\n" + "Person Object{Name: manasi bhide, Birthday: 1985-08-12, Gender: FEMALE, EmailAddress: manasib123@yahoo.com}\n\n";
        MainClass.printPersons(myPeeps, person -> person.getAge() >= 18 && person.getGender() == Person.Sex.FEMALE);
        Assert.assertEquals(expected, systemOutRule.getLog());
    }


}
