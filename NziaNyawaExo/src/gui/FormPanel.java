package gui;

import gui.listener.FormHandleListener;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.Person;

/**
 *
 * @author ddok
 */
public class FormPanel extends JPanel implements ActionListener {

    private final JLabel firstNameLabel, lastNameLabel, occupationLabel, roleLabel, addressLabel;
    private final JTextField firstNameTextField, lastNameTextField, occupationTextField, roleTextField, addressTextField;
    private final JButton recordBtn;
    private final ButtonGroup genderGroup;
    private final JRadioButton maleRadioButton, femaleRadioButton;

    // Listener for handeling forms' data
    private FormHandleListener formHandleListener;

    private static final int FIELD_LENTH = 13;

    public FormPanel() {
        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbl = new GridBagConstraints();

        // Defining form size
        setPreferredSize(new Dimension(300, 300));

        // Initialization
        firstNameLabel = new JLabel("First Name: ");
        lastNameLabel = new JLabel("Last Name: ");
        occupationLabel = new JLabel("Occupation: ");
        roleLabel = new JLabel("Role: ");
        addressLabel = new JLabel("Address: ");
        firstNameTextField = new JTextField(FIELD_LENTH);
        lastNameTextField = new JTextField(FIELD_LENTH);
        occupationTextField = new JTextField(FIELD_LENTH);
        roleTextField = new JTextField(FIELD_LENTH);
        addressTextField = new JTextField(FIELD_LENTH);
        genderGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        recordBtn = new JButton("Record");

        // Form border
        Border innerBorder = BorderFactory.createTitledBorder("Person Records");
        Border outerBorder = BorderFactory.createEmptyBorder(8, 8, 16, 8); // TOP, RIGHT, BOTTOM, LEFT
        // Form panel border
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        // Setting Gender button group
        maleRadioButton.setSelected(true);
        maleRadioButton.setActionCommand("Male");
        femaleRadioButton.setActionCommand("Female");
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Hooking listener to record button
        recordBtn.addActionListener(this);

        // Displaying different pieces as a form
        gbl.weightx = 1;
        gbl.weighty = .1;

        //**** First row
        // First cell
        gbl.gridx = 0;
        gbl.gridy = 0;
        gbl.fill = GridBagConstraints.NONE;
        gbl.anchor = GridBagConstraints.LINE_END;
        add(firstNameLabel, gbl);
        // Second Cell
        gbl.gridx = 1;
        gbl.gridy = 0;
        gbl.anchor = GridBagConstraints.LINE_START;
        add(firstNameTextField, gbl);

        //**** Second row
        // First cell
        gbl.weightx = 1;
        gbl.weighty = .1;
        gbl.gridx = 0;
        gbl.gridy++;
        gbl.fill = GridBagConstraints.NONE;
        gbl.anchor = GridBagConstraints.LINE_END;
        add(lastNameLabel, gbl);
        // Second Cell
        gbl.gridx = 1;
        gbl.gridy = 1;
        gbl.anchor = GridBagConstraints.LINE_START;
        add(lastNameTextField, gbl);

        //**** Third row
        // First cell
        gbl.weightx = 1;
        gbl.weighty = .1;
        gbl.gridx = 0;
        gbl.gridy++;
        gbl.fill = GridBagConstraints.NONE;
        gbl.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gbl);
        // Second Cell
        gbl.gridx = 1;
        gbl.gridy = 2;
        gbl.anchor = GridBagConstraints.LINE_START;
        add(occupationTextField, gbl);

        //**** Fourth row
        // First cell
        gbl.weightx = 1;
        gbl.weighty = .1;
        gbl.gridx = 0;
        gbl.gridy++;
        gbl.fill = GridBagConstraints.NONE;
        gbl.anchor = GridBagConstraints.LINE_END;
        add(roleLabel, gbl);
        // Second Cell
        gbl.gridx = 1;
        gbl.gridy = 3;
        gbl.anchor = GridBagConstraints.LINE_START;
        add(roleTextField, gbl);

        //**** Fith row
        // First cell
        gbl.weightx = 1;
        gbl.weighty = .1;
        gbl.gridx = 0;
        gbl.gridy++;
        gbl.fill = GridBagConstraints.NONE;
        gbl.anchor = GridBagConstraints.LINE_END;
        add(addressLabel, gbl);
        // Second Cell
        gbl.gridx = 1;
        gbl.gridy = 4;
        gbl.anchor = GridBagConstraints.LINE_START;
        add(addressTextField, gbl);

        // Sixth row
        gbl.gridy++;
        gbl.weightx = 1;
        gbl.weighty = .01;
        gbl.gridx = 0; // first cell
        gbl.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Gender: "), gbl);
        // Second cell
        gbl.gridx = 1; // Third cell
        gbl.anchor = GridBagConstraints.FIRST_LINE_START;
        add(maleRadioButton, gbl);

        gbl.gridy++;
        gbl.weightx = 1;
        gbl.weighty = .01;
        // Second cell
        gbl.gridx = 1; // Third cell
        gbl.anchor = GridBagConstraints.FIRST_LINE_START;
        add(femaleRadioButton, gbl);

        //**** Seventh row
        // First cell
        gbl.weightx = 1;
        gbl.weighty = 2;
        // Second Cell
        gbl.gridx = 1;
        gbl.gridy = 8;
        gbl.anchor = GridBagConstraints.FIRST_LINE_START;
        add(recordBtn, gbl);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // This method handle form interaction
        if (ae.getSource() == recordBtn) {
            //System.out.println("Button clicked!");
            Person p = new Person(firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    occupationTextField.getText(),
                    roleTextField.getText(),
                    genderGroup.getSelection().getActionCommand(),
                    addressTextField.getText());

            formHandleListener.personFormListener(p);
            freeFormFields();
        }
    }

    public void addFormListener(FormHandleListener listener) {
        this.formHandleListener = listener;
    }

    private void freeFormFields() {
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        occupationTextField.setText("");
        roleTextField.setText("");
        addressTextField.setText("");
        maleRadioButton.setSelected(true);
    }
}
