import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Person {
    String name;
    LocalDate birthday;  //format of
    Sex gender;
    String emailAddress;
    ArrayList<Person>peopleList = new ArrayList<Person>();

    public enum Sex{
        MALE ,FEMALE;
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }
    public Person(){

    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void printPerson(){
        System.out.println(String.format("Person Object{Name: %s, Birthday: %s, Gender: %s, EmailAddress: %s}\n",
                name, birthday, gender, emailAddress));
    }
    public Integer getAge(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }


    public static void printPersonsOlderThan(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
public int getAge(LocalDate birthday){
        LocalDate today=LocalDate.now();
        Integer p = Period.between(birthday,today).getYears();
        return p;

}
}
