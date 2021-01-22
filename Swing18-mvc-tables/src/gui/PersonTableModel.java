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

    /*
        Represents our person table based on what we want to show
        in our table as data.
     */
    private List<Person> people;
    private final String[] colNames = {"Id", "Name", "Occupation", "Gender", "Age Category", "Employment Caegory", "US Citizen", "Tax ID"};

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
        return 8;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Person p = people.get(row);
        switch (column) {
            case 0:
                return p.getId();
            case 1:
                return p.getName();
            case 2:
                return p.getOccupation();
            case 3:
                return p.getGender();
            case 4:
                return p.getAgeCategory();
            case 5:
                return p.getEmpCategory();
            case 6:
                return p.isUsCitizen();
            case 7:
                return p.getTaxId();
        }
        return null;
    }

}
