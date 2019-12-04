package lambdaslab;

public class Check implements CheckPerson {
    Integer method;

    public Check(Integer method) {
        this.method = method;
    }

    public Boolean test(Person person) {
        switch (method) {
            case 0:
                return checkIfMale(person);
            case 1:
                return checkIfOlderThan(person, 42);
            default:
                return false;
        }
    }

    public Boolean checkIfMale(Person p) {
        return (p.getGender().equals(Person.Sex.MALE));
    }

    public Boolean checkIfOlderThan(Person p, Integer age) {
        return (p.getAge() >= age);
    }

}
