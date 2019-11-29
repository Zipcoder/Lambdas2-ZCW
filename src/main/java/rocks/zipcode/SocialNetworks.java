package rocks.zipcode;

import java.util.ArrayList;
import java.util.List;

public class SocialNetworks {
    List<Person>network;

    public SocialNetworks(){
        this.network = new ArrayList<>();
    }

    public List<Person> getNetwork() {
        return network;
    }

    public SocialNetworks(Person person){
        this.network = new ArrayList<>();
        network.add(person);
    }
    public void add(Person person){
        network.add(person);
    }
    public List<Person> get(){
        return network;
    }


}
