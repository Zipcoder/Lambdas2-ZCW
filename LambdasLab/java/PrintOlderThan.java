import java.util.ArrayList;
import java.util.List;

public class PrintOlderThan implements CheckPerson{
    //ArrayList

//    public static void printPersonsOlderThan(List<Person> roster, int age) {
//        for (Person person : roster) {
//            if (person.getAge() >= age) {
//                person.printPerson();
//            }
//        }
//    }
//

    @Override
    public Boolean test(Person person) {
            if (person.getAge() >= 18) {
                person.printPerson();
                return true;
            }
        return false;
    }



}
