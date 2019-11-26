import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {


    @Test
    public void getAge() {

        Person testPerson = new Person("Joe",null,42,null, Person.Sex.MALE);

        Integer expected = 42;
        Integer actual = testPerson.getAge();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getName() {
        Person testPerson = new Person("Joe",null,42,null, Person.Sex.MALE);

        String expected = "Joe";
        String actual = testPerson.getName();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void printPersonsOlderThan() {
        Person person1 = new Person("Joe",null,42,null, Person.Sex.MALE);
        Person person2 = new Person("John",null,24,null, Person.Sex.MALE);
        Person testPerson = new Person();

        List<Person> testList = new ArrayList<>();
        testList.add(person1);
        testList.add(person2);

        testPerson.printPersonsOlderThan(testList,28);


    }
}