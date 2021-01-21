package controller;

import gui.ActivityForm;
import java.io.File;
import java.util.List;
import model.AgeCategory;
import model.EmployementCategory;
import model.GenderCategory;
import model.Person;
import model.PersonDao;

/**
 *
 * @author ddok
 */
public class AppController {

    private final PersonDao personDao = new PersonDao();

    public void addPerson(ActivityForm af) {
        String name = af.getName();
        String occupation = af.getOccupation();
        String gender = af.getGender();
        int age = (int) af.getAge().getId();
        String employment = af.getEmployment().getName();
        boolean citizen = af.isCitizen();
        String taxID = af.getTaxId();

        AgeCategory ageCat;
        switch (age) {
            case 0:
                ageCat = AgeCategory.child;
                break;
            case 1:
                ageCat = AgeCategory.adult;
                break;
            default:
                ageCat = AgeCategory.senior;
                break;
        }

        EmployementCategory empCat;
        switch (af.getEmployment().getId()) {
            case 0:
                empCat = EmployementCategory.employed;
                break;
            case 1:
                empCat = EmployementCategory.self_employed;
                break;
            case 2:
                empCat = EmployementCategory.unemployed;
                break;
            default:
                empCat = EmployementCategory.other;
                break;
        }

        GenderCategory genderCategory;
        if (gender.equals("Male")) {
            genderCategory = GenderCategory.male;
        } else {
            genderCategory = GenderCategory.female;
        }
        Person person = new Person();

        person.setName(name);
        person.setOccupation(occupation);
        person.setTaxId(taxID);
        person.setUsCitizen(citizen);
        person.setAgeCategory(ageCat);
        person.setEmpCategory(empCat);
        person.setGender(genderCategory);

        personDao.addPerson(person);
    }

    public List<Person> getPeople() {
        return personDao.getPeople();
    }

    public void saveToFile(File file) {
        personDao.saveToFile(file);
    }

    public void loadFromFile(File file) {
        personDao.loadFromFile(file);
    }
}
