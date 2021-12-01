package com.zipcode.lamda;

import java.util.ArrayList;
import java.util.List;

public class AnonymousClass {
    public ArrayList<Person> printPersons(List<Person> roster) {
        ArrayList<Person> temp = new ArrayList<>();

        CheckPerson checkP = new CheckPerson() {
            @Override
            public boolean test(Person p) {
                if (p.getAge() > 10 && p.gender == Person.Sex.FEMALE) {
                    return true;
                }
                return false;
            }
        };

        for (Person p : roster) {
            if (checkP.test(p)) {
                temp.add(p);
                System.out.println(p.printPerson());
            }
        }
        return temp;
    }
}
