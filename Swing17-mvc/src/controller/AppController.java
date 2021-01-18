package controller;

import gui.ActivityForm;
import model.Person;
import model.PersonDao;

/**
 *
 * @author ddok
 */
public class AppController {
    
    private PersonDao personDao = new PersonDao();

    public void addPerson(ActivityForm af) {
        String name = af.getName();
        String occupation = af.getOccupation();
        String gender = af.getGender();
        int age = Integer.valueOf(af.getAge());
        String employment = af.getEmployment();
        boolean citizen = af.isCitizen();
        String taxID = af.getTaxId();
        
        Person person = new Person();
        person.setName(name);
        person.setOccupation(occupation);
        person.setTaxId(taxID);
        person.setUsCitizen(citizen);
        
        
        personDao.addPerson(person);
    }
    
}
