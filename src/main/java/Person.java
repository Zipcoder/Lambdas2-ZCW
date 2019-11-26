import java.time.LocalDate;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }


    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;
    private Integer age;


    public Person(String name, String emailAddress, Integer age, LocalDate birthday, Sex gender){
        this.age = age;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public Person(){
        this.age = null;
        this.name = null;
        this.birthday = null;
        this.gender = null;
        this.emailAddress = null;
    }

    public int getAge() {
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    private void printPerson(String message) {
        System.out.print(message);
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson(p.getName() + " is older than " + age);
            }
        }
    }



}
