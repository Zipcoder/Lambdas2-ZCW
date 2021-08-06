import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.function.Predicate;

public class Person {

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, Sex sex, LocalDate birthday, String emailAddress) {
        this.name = name;
        this.gender= sex;
        this.birthday = birthday;
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

    public int getAge() {
        LocalDate today = LocalDate.now();
        Period diff = Period.between(birthday, today);
        return diff.getYears();
    }

    public void printPerson() {
        String person = this.toString();
        System.out.println(person);
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
