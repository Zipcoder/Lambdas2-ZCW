import java.time.LocalDate;
import java.time.Period;
import  java.util.ArrayList;

public class Person {
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    ArrayList<Person> personList = new java.util.ArrayList<>();


    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public enum Sex {
        MALE, FEMALE
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Person.Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public void printPerson() {
        System.out.println(String.format("{ Name: %s, Birthday: %s, Gender: %s, EmailAddress: %s}\n", name, birthday, gender, emailAddress));
    }
}
