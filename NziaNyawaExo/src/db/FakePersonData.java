package db;

import java.util.ArrayList;
import java.util.List;
import model.Person;


/**
 *
 * @author ddok
 */
public class FakePersonData {
    
    private static final List<Person> PEOPLE = new ArrayList<Person>();
    
    static {
        PEOPLE.add(new Person("Neo", "Ka", "Software Engineer", "Teacher", "Male", "Ngousso - Yde"));
        PEOPLE.add(new Person("Neo 1", "Ka 1", "Software Engineer 1", "Teacher 1", "Male 1", "Ngousso - Yde 1"));
        PEOPLE.add(new Person("Neo 2", "Ka 2", "Software Engineer 2", "Teacher 2", "Male 2", "Ngousso - Yde 2"));
        PEOPLE.add(new Person("Neo 3", "Ka 3", "Software Engineer 3", "Teacher 3", "Male 3", "Ngousso - Yde 3"));
        PEOPLE.add(new Person("Nzia", "Nya", "Economist", "Student", "Female", "XX - Bgte"));
    }
    
    public static List<Person> getPeople(){
        return PEOPLE;
    }
    
    public static void addPerson(Person person){
        PEOPLE.add(person);
    }
}
