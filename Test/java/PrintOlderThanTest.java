import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class PrintOlderThanTest {
    Person tp, tp1, tp2, tp3, tp4;
    ArrayList <Person> myPeeps = new ArrayList<>(0);
    PrintOlderThan myRoster;


    @Before
    public void setUp() throws Exception {
        myRoster = new PrintOlderThan();
        tp = new Person("Ricardo Jiminez", LocalDate.of(1990, Month.APRIL, 22), Person.Sex.MALE, "RickyBaby@gmail.com");
        tp1 = new Person("Sarah Jiminez", LocalDate.of(1970, Month.AUGUST, 12), Person.Sex.FEMALE, "SarahBaby@gmail.com");
        tp2 = new Person("Martha Stewart", LocalDate.of(1980, Month.JULY, 18), Person.Sex.MALE, "CookBaby@gmail.com");
        tp3 = new Person("JimBob Johnson", LocalDate.of(2001, Month.MARCH, 7), Person.Sex.MALE, "JimBob@gmail.com");
        tp4 = new Person("Ol Man Tucker", LocalDate.of(2003, Month.MAY, 22), Person.Sex.MALE, "Tuck@gmail.com");
        myPeeps.add(tp1);
        myPeeps.add(tp2);
        myPeeps.add(tp3);
        myPeeps.add(tp4);
        myPeeps.add(tp);
    }

    @Test
    public void printPersonsOlderThan() {
        PrintOlderThan testPrintOlderThan = new PrintOlderThan();
//        ArrayList <Person> expected = new ArrayList<>(0);
//        expected.add(tp3);
//        expected.add(tp4);
            //myRoster.test(myPeeps, PrintOlderThan);



    }

    @Test
    public void printPersons() {
    }


}
