import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printPeople(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        Person aswomeSister, secondBestSister, thirdBestSister, olderSister;
        ArrayList<Person> myFamily = new ArrayList<>();

        aswomeSister = new Person("Charlotte Beale", LocalDate.of(1982, java.time.Month.AUGUST, 20), Person.Sex.FEMALE, "cbeale2000@gmail.com");
        secondBestSister = new Person("Ruth Beale", LocalDate.of(1980, java.time.Month.MARCH, 07), Person.Sex.FEMALE, "rbeale@gmail.com");
        thirdBestSister = new Person("Kesha Beale", LocalDate.of(1978, java.time.Month.AUGUST, 17), Person.Sex.FEMALE, "kbeale@gmail.com");
        olderSister = new Person("Kathleen Beale", LocalDate.of(1976, java.time.Month.FEBRUARY, 23), Person.Sex.FEMALE, "kbeale@hotmail.com");
        myFamily.add(aswomeSister);
        myFamily.add(secondBestSister);
        myFamily.add(thirdBestSister);
        myFamily.add(olderSister);


        class checkForOver18 implements CheckPerson {

            @Override
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        }
        printPeople(myFamily, new checkForOver18());

        printPeople(myFamily, new CheckPerson() {
            @Override
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        });
        printPeople(myFamily, person -> person.getAge() >= 45);
    }
}
