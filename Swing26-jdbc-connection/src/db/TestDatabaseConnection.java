package db;

import model.AgeCategory;
import model.EmployementCategory;
import model.GenderCategory;
import model.Person;
import model.PersonDao;

/**
 *
 * @author ddok
 */
public class TestDatabaseConnection {

    private static final PersonDao dao = new PersonDao();

    public static void main(String[] args) {
        //dao.tryGettingPeople();
        //dao.trySavingPerson();
        //dao.tryGettingPersonById(3);
        dao.addPerson(new Person("Joe Dalton", "Prisonier", 
                AgeCategory.adult, 
                EmployementCategory.unemployed, 
                "J-89", true, GenderCategory.male));
        dao.addPerson(new Person("Lucky Luc", "Mercenary", 
                AgeCategory.adult, 
                EmployementCategory.employed, 
                "J-89", true, GenderCategory.male));
        
        dao.save();
        
    }
}
