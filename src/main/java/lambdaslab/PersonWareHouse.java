package lambdaslab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static lambdaslab.Person.Sex.*;

public class PersonWareHouse {
    List<Person> roster;

    public PersonWareHouse () {
        roster = new ArrayList<>();
        roster.add(new Person("Wes", MALE,1980,5,22, true));
        roster.add(new Person("Kai", FEMALE, 1970, 4, 2, true));
        roster.add(new Person("Ryan", MALE, 1960, 2,29, true));
        roster.add(new Person("Val", FEMALE, 1990, 6,10, true));
        roster.add(new Person("Kendra", FEMALE, 2000, 3,30, true));
    }

    public List<Person> getRoster() {
        return this.roster;
    }
}
