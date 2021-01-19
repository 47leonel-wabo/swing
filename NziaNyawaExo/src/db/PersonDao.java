package db;

import java.util.List;
import model.Person;

/**
 *
 * @author ddok
 */
public class PersonDao {

    public PersonDao() {
    }
    
    public List<Person> getPeople(){
        System.out.println("**** DAO passing data...");
        return FakePersonData.getPeople();
    }
    
    public void addPerson(Person per){
        FakePersonData.addPerson(per);
    }
}
