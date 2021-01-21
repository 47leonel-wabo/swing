package gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
    private final JPopupMenu popupMenu;
    private final JMenuItem deleteItem;

    public TablePanel() {
        setLayout(new BorderLayout()); // Setting a layout into our panel
        table = new JTable(); // Initializing our table
        tableModel = new PersonTableModel();
        popupMenu = new JPopupMenu();
        deleteItem = new JMenuItem("Delete row");
        
        // Adding delete item to popup
        popupMenu.add(deleteItem);
        
        // Adding mouse listener to the table
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(table, me.getX(), me.getY());
                }
            }
        });

        // Setting table
        table.setModel(tableModel);
        // Adding borders
        Border outerBorder = BorderFactory.createEmptyBorder(8, 2, 8, 8); // Padding TOP LEFT BOTTOM RIGHT
        setBorder(BorderFactory.createCompoundBorder(outerBorder, outerBorder)); // Border

        add(new JScrollPane(table), BorderLayout.CENTER); // Positionning our table component on our layout
    }

    public void setTableModelData(List<Person> people) {
        tableModel.setPeople(people); // Passing data to the table model
    }

    public void refreshTable() {
        tableModel.fireTableDataChanged();
    }
}
