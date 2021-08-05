import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SocialApp implements CheckPerson{

    List<Person> roster = new ArrayList<>();


    @Override
    public List<Person> getList() {
        return roster;
    }

    @Override
    public boolean test(Person p) {
        return false;
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        Predicate<Person> checkAge = p -> p.getAge() > age;
        roster.stream().filter(checkAge).forEach(Person::printPerson);
    }
}
