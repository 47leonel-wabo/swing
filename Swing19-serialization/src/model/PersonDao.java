package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void saveToFile(File file) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // convert prople to array 
            Person[] ps = people.toArray(new Person[people.size()]);
            oos.writeObject(ps);

            oos.close();
        } catch (Exception ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadFromFile(File file) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person[] ps = (Person[]) ois.readObject();
            
            people.clear();
            people.addAll(Arrays.asList(ps));
            
            ois.close();
        } catch (Exception ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
