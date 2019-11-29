package rocks.zipcode;

public class CheckOlderThan40 implements CheckPerson {

    @Override
    public boolean test(Person person) {
        if (person.getAge() >= 40) {
            return true;
        }
        return false;
    }

}
