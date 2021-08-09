import com.sun.tools.javac.comp.Check;

import java.util.ArrayList;
import java.util.List;

public class PersonUtilities {


    public static List<Person> personsOlderThan(List<Person> list, int age) {
        List<Person> newList = new ArrayList<>();
        for (Person p : list) {
            if (p.getAge() >= age) {
                newList.add(p);
            }
        }
        return newList;
    }

    public static List<Person> personsYoungerThan(List<Person> list, int age) {
        List<Person> newList = new ArrayList<>();
        for (Person p : list) {
            if (p.getAge() <= age) {
                newList.add(p);
            }
        }
        return newList;
    }

    public static Person findByName(List<Person> list, String name){
        for(Person p: list){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public static List<Person> personsOfGender(List<Person> list, Person.Sex gender) {
        List<Person> newList = new ArrayList<>();
        for (Person p : list) {
            if (p.getGender().equals(gender)) {
                newList.add(p);
            }
        }
        return newList;
    }

    public static void printPersons(List<Person> roster, CheckPerson filter) {
        for (Person p : roster) {
            if (filter.test(p)) {
                p.printPerson();
            }
        }
    }

    public static List<Person> getPersons(List<Person> list, CheckPerson filter){
        List<Person> filtered = new ArrayList<>();
        for(Person p : list){
            if(filter.test(p)){
                filtered.add(p);
            }
        }
        return filtered;
    }

    //-------------Local Class--------------
    static class Under30 implements CheckPerson{
        public Under30() {
        }
        @Override
        public boolean test(Person p) {
            return p.getAge() < 30;
        }
    }

    static class FemaleWithGoogle implements CheckPerson{
        public FemaleWithGoogle() {
        }
        @Override
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.FEMALE && p.getEmailAddress().equals("Google");
        }
    }


    //--------------------------ANONYMOUS CLASS---------------------------
    //Creating anonymous class
    private static CheckPerson maleUnder30 = new CheckPerson() {
        @Override
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE && p.getAge() < 30;
        }
    };

    public static CheckPerson getMaleUnder30() {
        return maleUnder30;
    }

    private static CheckPerson femaleAbove30 = new CheckPerson(){
        @Override
        public boolean test(Person p) {
            return p.getGender().equals(Person.Sex.FEMALE) && p.getAge() > 30;
        }
    };
    public static CheckPerson femaleAbove30(){
        return femaleAbove30;
    }

}
