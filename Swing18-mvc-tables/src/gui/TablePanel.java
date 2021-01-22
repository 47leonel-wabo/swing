package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import model.Person;

/**
 *
 * @author ddok
 */
public class TablePanel extends JPanel {

    private final JTable table;
    private final PersonTableModel tableModel;

    public TablePanel() {
        setLayout(new BorderLayout()); // Setting a layout into our panel
        table = new JTable(); // Initializing our table
        tableModel = new PersonTableModel();

        // Setting table
        table.setModel(tableModel);
        // Adding borders
        Border outerBorder = BorderFactory.createEmptyBorder(8, 8, 8, 2); // Padding TOP RIGHT BOTTOM LEFT
        setBorder(BorderFactory.createCompoundBorder(outerBorder, outerBorder)); // Border

        add(new JScrollPane(table), BorderLayout.CENTER); // Positionning our table component on our layout
    }

    public void setTableModelData(List<Person> people) {
        people.forEach(p -> {
            System.out.println(p);
        });
        tableModel.setPeople(people); // Passing data to the table model
    }

    public void refreshTable() {
        tableModel.fireTableDataChanged();
    }
}
