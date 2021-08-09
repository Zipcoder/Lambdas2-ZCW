import com.sun.jndi.toolkit.dir.SearchFilter;
import com.sun.tools.javac.comp.Check;
import sun.nio.ch.Net;

import javax.naming.directory.SearchControls;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printPersons(List<Person> roster, CheckPerson filter) {
        for (Person p : roster) {
            if (filter.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {

        Person p1 = new Person("Bobby", 21, Person.Sex.MALE,"hotmail");
        Person p2 = new Person("Ana",25, Person.Sex.FEMALE,"Yahoo");
        Person p3 = new Person("Jack",30, Person.Sex.MALE,"Google");
        Person[] people = {p1,p2,p3};

        Network network = new Network();
        network.addArray(people);

        //--------------------------LOCAL CLASS-------------------------------
        //Creating local class
        class Under30 implements CheckPerson{
            @Override
            public boolean test(Person p) {
                return p.getAge() < 30;
            }
        }
        //Testing using local class
        System.out.println("===========================LOCAL=========================");
        printPersons(network.getList(),new Under30());

        //--------------------------ANONYMOUS CLASS---------------------------
        //Creating anonymous class
        CheckPerson maleUnder30 = new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE && p.getAge() < 30;
            }
        };
        //Testing using anonymous class
        System.out.println("=========================ANONYMOUS========================");
        printPersons(network.getList(), maleUnder30);

        //--------------------------LAMBDA EXPRESSION------------------------
        //Testing using lambda expression for female under 30
        System.out.println("===========================LAMBDA=========================");
        printPersons(network.getList(), person ->
                person.getGender()== Person.Sex.FEMALE && person.getAge() < 30);
    }
}
