import java.time.LocalDate;

public class PersonBuilder {
    private String name;
    private Person.Sex sex;
    private LocalDate birthday = LocalDate.of(1990, 1, 1);
    private String emailAddress;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSex(Person.Sex sex) {
        this.sex = sex;
        return this;
    }

    public PersonBuilder setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public PersonBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Person createPerson() {
        return new Person(name, sex, birthday, emailAddress);
    }
}