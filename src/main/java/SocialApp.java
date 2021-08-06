import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SocialApp{

    List<Person> roster = new ArrayList<>();


    public List<Person> getList() {
        return roster;
    }


    interface CheckPerson {
        boolean test (Person p);
    }


    public void addUser(Person user){
        roster.add(user);
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        Predicate<Person> checkAge = p -> p.getAge() > age;
        roster.stream().filter(checkAge).forEach(Person::printPerson);
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        Predicate<Person> range = p -> low <= p.getAge() && p.getAge() < high;
        roster.stream().filter(range).forEach(Person::printPerson);
    }
}
