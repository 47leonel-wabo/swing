package controller;

import db.PersonDao;
import java.util.List;
import model.Person;

/**
 *
 * @author ddok
 */
public class AppController {
    
    private final PersonDao personDao = new PersonDao();
    
    public void addUser(Person person){
        personDao.addPerson(person);
    }
    
    public List<Person> getPeople(){
        return personDao.getPeople();
    }
}
