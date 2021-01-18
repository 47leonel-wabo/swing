package gui;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;

/**
 *
 * @author ddok
 */
public class TablePanel extends JPanel {

    private final JTable table;

    public TablePanel() {
        setLayout(new BorderLayout()); // Setting a layout into our panel
        table = new JTable(); // Initializing our table

        // Adding borders
        Border outerBorder = BorderFactory.createEmptyBorder(8, 8, 8, 2); // Padding TOP RIGHT BOTTOM LEFT
        setBorder(BorderFactory.createCompoundBorder(outerBorder, outerBorder)); // Border

        add(table, BorderLayout.CENTER); // Positionning our table component on our layout
    }

}
