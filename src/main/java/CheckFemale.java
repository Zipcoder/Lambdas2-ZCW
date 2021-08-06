public interface CheckFemale extends CheckPerson{
    @Override
    default boolean test(Person p) {
        return p.getGender()== Person.Sex.FEMALE;
    }
}
