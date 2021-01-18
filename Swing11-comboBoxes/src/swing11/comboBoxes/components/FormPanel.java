package swing11.comboBoxes.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import swing.app.model.ActivityForm;
import swing.app.model.AgeCategory;
import swing.app.model.EmployeeCategory;
import swing11.comboBoxes.HandleForm;

/**
 *
 * @author ddok
 */
public class FormPanel extends JPanel implements ActionListener {

    private final JLabel nameLabel, occupationLabel, formTitleLabel;
    private final JTextField nameTextField, occupationTextField;
    private final JButton okBtn;
    private final JList ageList;
    private final JComboBox empBox;

    // Listener interface
    private HandleForm handleForm;

    public FormPanel() {
        setPreferredSize(new Dimension(300, 300));

        Border innerBorder = BorderFactory.createTitledBorder("aiwa services");
        Border outerBorder = BorderFactory.createEmptyBorder(8, 8, 16, 8); // TOP, RIGHT, BOTTOM, LEFT

        /*
            Form components initialization
         */
        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        formTitleLabel = new JLabel("AIWA | Record Form");
        nameTextField = new JTextField(12);
        occupationTextField = new JTextField(12);
        okBtn = new JButton("Save");
        ageList = new JList();
        empBox = new JComboBox();

        // Setting up list boxes
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "65 or over"));
        // Hook model to list component
        ageList.setModel(ageModel);
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setPreferredSize(new Dimension(145, 80));
        ageList.setSelectedIndex(0);

        // Setting up combo-boxes
        DefaultComboBoxModel emBoxModel = new DefaultComboBoxModel();
        emBoxModel.addElement(new EmployeeCategory(0, "Software Ing.", BigDecimal.valueOf(1500.0)));
        emBoxModel.addElement(new EmployeeCategory(1, "Graphist", BigDecimal.valueOf(380.0)));
        emBoxModel.addElement(new EmployeeCategory(2, "Doctor", BigDecimal.valueOf(5500.0)));
        empBox.setModel(emBoxModel);
        empBox.setPreferredSize(new Dimension(145, 25));

        // Form panel border
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
        okBtn.addActionListener(this);
        
        /*
            Layout All Components
        */
        layoutComponents();
    }
    
    private void layoutComponents(){
        // Form panel layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // ********** First Row ******************
        // Cells sizes
        gc.weightx = 1;
        gc.weighty = 0.1;
        // First Cell
        gc.gridx = 0; // Represents the Column
        gc.gridy = 0; // Represents the row
        gc.fill = GridBagConstraints.NONE; // Fill the cell ?
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);
        // Second Cell
        gc.gridx = 1;
        gc.gridy = 0;
        //gc.insets = new Insets(0, 0, 0, 5); // This some king of padding (TOP, LEFT, BOTTOM, RIGHT)
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameTextField, gc);

        // ********** Second Row ******************
        // Cells sizes
        gc.weightx = 1;
        gc.weighty = 0.1;
        // First Cell
        gc.gridx = 0; // Col
        gc.gridy = 1; // Row
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);
        // Second Cell
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationTextField, gc);

        // ********** Third Row ******************
        // Cells sizes
        gc.weightx = 2;
        gc.weighty = .1;
        // First Cell
        gc.gridx = 0; // Col
        gc.gridy = 2; // Row
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Age "), gc);
        // Second Cell
        gc.gridx = 1; // Col
        gc.gridy = 2; // Row
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(ageList, gc);
        
        // ********** Fourth Row ******************
        // Cells sizes
        gc.weightx = 2;
        gc.weighty = .1;
        // First Cell
        gc.gridx = 0; // Col
        gc.gridy = 3; // Row
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Employee "), gc);
        // Second Cell
        gc.gridx = 1; // Col
        gc.gridy = 3; // Row
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(empBox, gc);

        // ********** Fith Row ******************
        // Cells sizes
        gc.weightx = 1;
        gc.weighty = 2;
        // Second Cell
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);
    }

    public void setHandleForm(HandleForm hf) {
        this.handleForm = hf;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == okBtn) {
            ActivityForm af = new ActivityForm(
                    nameTextField.getText(),
                    occupationTextField.getText(),
                    ((AgeCategory) ageList.getSelectedValue()).getValue());

            System.out.println(af);
            System.out.println(empBox.getSelectedItem());
            //handleForm.formDataTransfer(af);
        }
    }

}
