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

    // Example using Local Class
    static class CheckAge implements CheckPerson {
        @Override
        public Boolean test(Person person) {
            return (person.getAge() >= 42);
        }
    }

    public static String exWithLocalClass(List<Person> roster) {
        return printPersons(roster, new CheckAge());
    }

    public static String exWithLambdas(List<Person> roster) {
        return printPersons(roster, person -> person.getAge() >= 42);
    }

    public static String exWithAnonClass(List<Person> roster) {
        return printPersons(roster, new CheckPerson() {
            @Override
            public Boolean test(Person p) {
                return p.getGender().equals(Person.Sex.MALE);
            }
        });
    }




}
