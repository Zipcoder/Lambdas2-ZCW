import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    //using lambdas
//    public List<Person> getMyPeepsOver18(List<Person> myPeeps) {
//        List<Person> myPeepsOver18 = myPeeps.stream().filter(p -> p.getAge() >= 18).collect(Collectors.toList());
//        return myPeepsOver18;
//    }

    public static void main(String[] args) {
        Person tp, tp1, tp2, tp3, tp4, tp5;
        ArrayList<Person> myPeeps = new ArrayList<>();

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


        class checkForOver18 implements CheckPerson {
            @Override
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        }
        printPersons(myPeeps, new checkForOver18());

        //example using anonymous class
        printPersons(myPeeps, new CheckPerson() {
            @Override
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        });

        //example using lambda
        printPersons(myPeeps, person -> person.getAge() >= 18);
    }
}
