package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Person;

/**
 *
 * @author ddok
 */
public class PersonTableModel extends AbstractTableModel {

    private List<Person> people;
    private String[] colNames = {"ID", "FIRST NAME", "LAST NAME", "OCCUPATION", "ADDRESS", "GENDER", "ROLE"};

    public PersonTableModel() {
        this.people = new ArrayList<>();
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public int getRowCount() {
        return people.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Person person = people.get(row);
        switch (col) {
            case 0:
                return person.getId();
            case 1:
                return person.getFirstname();
            case 2:
                return person.getLastname();
            case 3:
                return person.getOccupation();
            case 4:
                return person.getAddress();
            case 5:
                return person.getGender();
            case 6:
                return person.getRole();
        }

        return null;
    }

}
