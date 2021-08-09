public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private Integer age;
    private Sex gender;
    private String emailAddress;

    public Person() {
    }

    public Person(String name, Integer age, Sex gender, String emailAddress) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public String toString(){
        return "Person = " + name +
                ", age = " + age +
                ", gender = " + gender +
                ", emailAddress = " + emailAddress + "\n";
    }

    public void printPerson() {
        System.out.println(this.toString());
    }
}
