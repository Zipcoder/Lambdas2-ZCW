public class CheckMaleOlderThan21 implements CheckPerson{
    @Override
    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE && p.getAge()>21;
    }
}
