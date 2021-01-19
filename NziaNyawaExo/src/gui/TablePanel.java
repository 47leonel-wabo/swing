package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.Border;
import model.Person;

/**
 *
 * @author ddok
 */
public class TablePanel extends JTable{
    
    private final PersonTableModel tableModel;
    private final JTable table;

    public TablePanel() {
        // Component layout
        setLayout(new BorderLayout());
        
        // Initialization
        table = new JTable();
        tableModel = new PersonTableModel();
        
        // Adding borders
        Border outerBorder = BorderFactory.createEmptyBorder(8, 8, 8, 2); // Padding TOP RIGHT BOTTOM LEFT
        setBorder(BorderFactory.createCompoundBorder(outerBorder, outerBorder)); // Border
        
        // Adding components to their container
        add(table, BorderLayout.CENTER);
    }
    
    public void addDataToTableModel(List<Person> people){
        tableModel.setPersonData(people);
    }
    
    public void refreshTable(){
        tableModel.fireTableDataChanged();
    }
    
}
