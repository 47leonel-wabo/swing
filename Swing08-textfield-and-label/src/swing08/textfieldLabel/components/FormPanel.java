package swing08.textfieldLabel.components;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author ddok
 */
public class FormPanel extends JPanel {
    
    private JLabel nameLabel, occupationLabel, formTitleLabel;
    private JTextField nameTextField, occupationTextField;
    private JButton okBtn;

    public FormPanel() {
        setPreferredSize(new Dimension(300, 300));
        
        Border innerBorder = BorderFactory.createTitledBorder("aiwa services");
        Border outerBorder = BorderFactory.createEmptyBorder(8, 8, 16, 8); // TOP, RIGHT, BOTTOM, LEFT
        
        /*
            Form components
        */
        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        formTitleLabel = new JLabel("AIWA | Record Form");
        nameTextField = new JTextField(20);
        occupationTextField = new JTextField(20);
        okBtn = new JButton("Save");
        
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }
    
}
