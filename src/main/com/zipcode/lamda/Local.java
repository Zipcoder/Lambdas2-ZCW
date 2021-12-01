package com.zipcode.lamda;

import java.util.List;

public class Local implements CheckPerson{
    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    @Override
    public boolean test(Person p) {
        if(p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 30) {
            return true;
        } else {
            return false;
        }
    }

}
