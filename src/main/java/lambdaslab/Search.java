package lambdaslab;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static String printPersonsOlderThan(List<Person> roster, Integer age) {
        StringBuilder out = new StringBuilder();
        roster.stream().filter(p -> p.getAge() >= age).forEach(person -> {
            out.append(person.toString()+"\n");
            person.printPerson();
        });
        return out.toString();
    }

    public static String printPersonsWithinAgeRange(List<Person> roster, Integer low, Integer high) {
        StringBuilder out = new StringBuilder();
        roster.stream()
                .filter(p -> p.getAge() >= low && p.getAge() <= high)
                .forEach(person -> {
                    out.append(person.toString()+"\n");
                    person.printPerson();
                });
        return out.toString();
    }

    public static String printPersons(List<Person> roster, CheckPerson tester) {
        StringBuilder out = new StringBuilder();
        roster.stream()
                .filter(p -> tester.test(p))
                .forEach(p -> {
                    p.printPerson();
                    out.append(p.toString());
                });
        return out.toString();
    }
}
