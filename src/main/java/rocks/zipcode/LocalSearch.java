package rocks.zipcode;

import java.util.List;

public class LocalSearch implements CheckPerson{
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    @Override
    public boolean test(Person person) {
        return person.gender == Person.Sex.FEMALE &&
                person.getAge() >= 0 &&
                person.getAge() <= 80;

    }
}
