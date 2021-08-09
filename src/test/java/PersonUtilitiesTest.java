import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PersonUtilitiesTest {
    Network network = new Network();
    Person p1 = new Person("Bobby", 21, Person.Sex.MALE,"Hotmail");
    Person p2 = new Person("Ana",25, Person.Sex.FEMALE,"Yahoo");
    Person p3 = new Person("Jack",30, Person.Sex.MALE,"Google");
    Person p4 = new Person("Jill",41, Person.Sex.FEMALE,"AOL");
    Person p5 = new Person("Pete",55, Person.Sex.MALE,"YMail");
    Person p6 = new Person("Beth",34, Person.Sex.FEMALE,"Google");

    @Before
    public void populateNetwork(){
        Person[] people = {p1,p2,p3,p4,p5,p6};
        network.addArray(people);
    }

    @Test
    public void testPersonOlderThan(){
        //when
        List<Person> filtered = PersonUtilities.personsOlderThan(network.getList(),35);
        boolean result = filtered.contains(p4) && filtered.contains(p5);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testPersonYoungerThan(){
        //when
        List<Person> filtered = PersonUtilities.personsYoungerThan(network.getList(),30);
        boolean result = filtered.contains(p1) && filtered.contains(p2);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFindByName(){
        //when
        Person retrieved = PersonUtilities.findByName(network.getList(),"Bobby");
        //then
        Assert.assertEquals(p1,retrieved);
    }

    @Test
    public void testPersonsOfGender(){
        //when
        List<Person> filtered = PersonUtilities.personsOfGender(network.getList(), Person.Sex.FEMALE);
        boolean result = filtered.contains(p2) && filtered.contains(p4) && filtered.contains(p6);
        //then
        Assert.assertTrue(result);
    }

    //----------------------------Local Class------------------------
    @Test
    public void testLocalClassUnder30(){
        //when
        List<Person> filtered = PersonUtilities.getPersons(network.getList(), new PersonUtilities.Under30());
        boolean result = filtered.contains(p1) && filtered.contains(p2);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFemaleWithGoogle(){
        //when
        List<Person> filtered = PersonUtilities.getPersons(network.getList(), new PersonUtilities.FemaleWithGoogle());
        boolean result = filtered.contains(p6);
        //then
        Assert.assertTrue(result);
    }

    //---------------------------Anonymous Class---------------------
    @Test
    public void testMaleUnder30(){
       List<Person> filtered = PersonUtilities.getPersons(network.getList(), PersonUtilities.getMaleUnder30());
       boolean result = filtered.contains(p1);
       //then
        Assert.assertTrue(result);
    }

    @Test
    public void testFemaleAbove30(){
        List<Person> filtered = PersonUtilities.getPersons(network.getList(), PersonUtilities.femaleAbove30());
        boolean result = filtered.contains(p4) && filtered.contains(p6);
        //then
        Assert.assertTrue(result);
    }


    //------------------------------Lambda--------------------------
    @Test
    public void testMaleOver30(){
        List<Person> filtered = PersonUtilities.getPersons(network.getList(),
                person -> person.getAge() > 30 && person.getGender() == Person.Sex.MALE);
        boolean result = filtered.contains(p5);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testMaleWithYahoo(){
        List<Person> filtered = PersonUtilities.getPersons(network.getList(),
                person -> person.getGender().equals(Person.Sex.MALE) && person.getEmailAddress().equals("Yahoo"));
        boolean result = filtered.isEmpty();
        //then
        Assert.assertTrue(result);

    }

}
