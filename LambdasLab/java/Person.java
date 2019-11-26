import java.time.LocalDate;
import java.time.Period;

public class Person {

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
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

    public Sex getGender() {
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

    public int getAge(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        Integer p = Period.between(birthday, today).getYears();
        // OR
        return p;
    }

    public void printPerson() {
        // ...
    }
}
