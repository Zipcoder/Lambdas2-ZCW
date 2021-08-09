import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Person> list;

    public Network() {
        this.list = new ArrayList<>();
    }

    public void add(Person person){
        this.list.add(person);
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public void addArray(Person[] people){
        for (int i = 0; i < people.length; i++) {
            this.list.add(people[i]);
        }
    }


}
