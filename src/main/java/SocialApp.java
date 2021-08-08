import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SocialApp{

    List<Person> roster = new ArrayList<>();


    public List<Person> getList() {
        return roster;
    }


    interface Checker extends CheckPerson {

        boolean test(Person p);


        static boolean testMale(Person p){
            return p.getGender() == Person.Sex.MALE;
            }

        static boolean testFemale(Person p){
            return p.getGender()== Person.Sex.FEMALE;
        }
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

    public static void printPersonsFemale( List<Person> roster
//            List<Person> roster, Checker tester
    ) {
        Predicate<Person> checkFem = Checker::testFemale;
        roster.stream().filter(checkFem).forEach(Person::printPerson);
    }

    public static void printMales21AndUp(List<Person> roster){
        Predicate<Person> checkMale = Checker::testMale;
        Predicate<Person> checkAge = p-> p.getAge() > 21;

        roster.stream().filter(checkMale).filter(checkAge).forEach(Person::printPerson);
    }

    public static void printFemales21AndUp(List<Person> roster){
        Predicate<Person> checkMale = Checker::testFemale;
        Predicate<Person> checkAge = p-> p.getAge() > 21;

        roster.stream().filter(checkMale).filter(checkAge).forEach(Person::printPerson);
    }

    public static void printFemalesBetweenAges(List<Person> roster, int low, int high){
        Predicate<Person> checkFem = Checker::testFemale;
        Predicate<Person> range = p -> low <= p.getAge() && p.getAge() < high;
        roster.stream().filter(checkFem).filter(range).forEach(Person::printPerson);

    }

    public static void printMalesBetweenAges(List<Person> roster, int low, int high){
        Predicate<Person> checkMale = Checker::testMale;
        Predicate<Person> range = p -> low <= p.getAge() && p.getAge() < high;
        roster.stream().filter(checkMale).filter(range).forEach(Person::printPerson);

    }

}
