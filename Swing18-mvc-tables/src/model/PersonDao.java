package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ddok
 */
public class PersonDao {

    private final ArrayList<Person> people;

    public PersonDao() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}
