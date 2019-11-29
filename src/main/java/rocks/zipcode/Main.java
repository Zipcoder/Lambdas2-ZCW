package rocks.zipcode;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        SocialNetworks networks = new SocialNetworks();

        Person person1 = new Person("Brian", LocalDate.of(1986, 8, 30), Person.Sex.MALE, "email1@address.com");
        Person person2 = new Person("Rando", LocalDate.of(1999, 11, 10), Person.Sex.FEMALE, "random@email.com");
        Person person3 = new Person("Peoples", LocalDate.of(1983, 6, 20), Person.Sex.MALE, "email30@address.com");
        Person person4 = new Person("Jojo", LocalDate.of(1972, 5, 5), Person.Sex.FEMALE, "random2@email.com");
        Person person5 = new Person("Faye", LocalDate.of(1994, 2, 14), Person.Sex.MALE, "email25@address.com");
        Person person6 = new Person("Boberto", LocalDate.of(2003, 4, 21), Person.Sex.FEMALE, "random45@email.com");
        Person person7 = new Person("Guy", LocalDate.of(1969, 1, 3), Person.Sex.MALE, "email50@address.com");
        Person person8 = new Person("Smiley", LocalDate.of(2008, 12, 8), Person.Sex.FEMALE, "random77@email.com");
        Person[] peeps = {person1, person2, person3, person4, person5, person6, person7, person8};

        for (int i = 0; i < peeps.length; i++) {
            networks.add(peeps[i]);
        }

        class Under30 implements CheckPerson {
            @Override
            public boolean test(Person person) {
                return person.getAge() <= 30;
            }
        }



        CheckPerson maleOver30 = new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.getAge() >= 15 && person.getAge() <= 50;
            }

        };

        printPersons(networks.get(), new Under30());

        printPersons(networks.get(),maleOver30);

        printPersons(networks.get(), person -> person.getAge() >= 15 && person.getAge() <= 50 && person.getGender() == Person.Sex.FEMALE);
    }
}

