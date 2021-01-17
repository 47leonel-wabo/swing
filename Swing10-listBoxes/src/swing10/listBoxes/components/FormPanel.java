package swing10.listBoxes.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import swing.app.model.ActivityForm;
import swing10.listBoxes.HandleForm;

/**
 *
 * @author ddok
 */
public class FormPanel extends JPanel implements ActionListener {

    private JLabel nameLabel, occupationLabel, formTitleLabel;
    private JTextField nameTextField, occupationTextField;
    private JButton okBtn;
    private JList ageList;

    private HandleForm handleForm;

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
        nameTextField = new JTextField(12);
        occupationTextField = new JTextField(12);
        okBtn = new JButton("Save");
        ageList = new JList();
        
        // List model
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement("under 18");
        ageModel.addElement("18 to 65");
        ageModel.addElement("65 or over");
        // Hook model to list component
        ageList.setModel(ageModel);
        ageList.setBorder(BorderFactory.createTitledBorder("Age"));
        ageList.setPreferredSize(new Dimension(145, 80));
        ageList.setSelectedIndex(0);

        // Form panel border
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // ********** First Row ******************
        // Cells sizes
        gc.weightx = 1;
        gc.weighty = 0.1;
        // First Cell
        gc.gridx = 0;
        gc.gridy = 0;
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
        gc.gridx = 0;
        gc.gridy = 1;
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
        // Second Cell
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(ageList, gc);
        
        // ********** Fourth Row ******************
        // Cells sizes
        gc.weightx = 1;
        gc.weighty = 2;
        // Second Cell
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

        okBtn.addActionListener(this);
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
                    ageList.getSelectedValue().toString());
            
            //System.out.println(ageList.getSelectedValue().toString());
            handleForm.formDataTransfer(af);
        }
    }

}
