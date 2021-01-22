package model;

import db.DBConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddok
 */
public class PersonDao {

    private final List<Person> people;
    private Connection dbConnection;

    public PersonDao() {
        people = new LinkedList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
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

    public boolean removePerson(int index) {
        return people.remove((Person) people.get(index));
    }

    public void save() {
        try {
            dbConnection = DBConnection.getConnection();

            String checkSql = "select count(*) as count from citizens where id=?";

            PreparedStatement checkStatement = dbConnection.prepareStatement(checkSql);
            for (Person person : people) {
                checkStatement.setInt(1, Integer.parseInt(person.getId().toString()));
                ResultSet rs = checkStatement.executeQuery();
                rs.next(); // moving pointer to the first row of the table
                int count = rs.getInt(1); // Get the first return result
                System.out.println("Person with ID " + person.getId() + " has " + count + " occurance");
            }
        } catch (Exception ex) {
        } finally {
            DBConnection.disconnect(dbConnection);
        }

    }

    public void tryGettingPeople() {

        try {
            dbConnection = DBConnection.getConnection();
            System.out.println("Database connected!");

            String peopleSql = "select * from people";
            PreparedStatement checkStatement = dbConnection.prepareStatement(peopleSql);
            ResultSet rs = checkStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)); // First Column (id)
            }
            DBConnection.disconnect(dbConnection);
            System.out.println("Database Disconnected!");
        } catch (Exception ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void trySavingPerson() {
        try {
            dbConnection = DBConnection.getConnection();

            String saveSql = "insert into people(id, name, age, gender) values(?, ?, ?, ?)";
            PreparedStatement saveStatement = dbConnection.prepareStatement(saveSql);

            saveStatement.setInt(1, 0);
            saveStatement.setString(2, "Silver");
            saveStatement.setInt(3, 75);
            saveStatement.setString(4, "M");

            System.out.println(saveStatement.execute());

            DBConnection.disconnect(dbConnection);
        } catch (Exception ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tryGettingPersonById(Integer id) {
        try {
            dbConnection = DBConnection.getConnection();

            String reqSql = "select * from people where id=?";
            PreparedStatement reqStatement = dbConnection.prepareStatement(reqSql);
            reqStatement.setInt(1, id);
            ResultSet rs = reqStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)); // First Column (id)
                System.out.println(rs.getString(2)); // Second Column (name)
            }

            DBConnection.disconnect(dbConnection);
        } catch (Exception ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void trySavingCitizen() {
        try {
            dbConnection = DBConnection.getConnection();

            String saveSql = "insert into citizens(id, name, occupation, age_cat, emp_cat,  tax_id, us_citizen, gender) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement saveStatement = dbConnection.prepareStatement(saveSql);

            saveStatement.setInt(1, 0);
            saveStatement.setString(2, "Silver");
            saveStatement.setString(3, "Fight crims");
            saveStatement.setString(4, "Senior");
            saveStatement.setString(5, "Super hero");
            saveStatement.setString(6, "S-SIL-01");
            saveStatement.setBoolean(7, false);
            //saveStatement.setString(8, GenderCategory.male);

            if (!saveStatement.execute()) { // If not error
                System.out.println("Citizen saved!");
            }

            DBConnection.disconnect(dbConnection);
        } catch (Exception ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
