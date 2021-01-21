package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author ddok
 */
public class PreferencesDialog extends JDialog {

    private final JButton okBtn, cancelBtn;
    private final JSpinner portSpinner;
    private final SpinnerNumberModel numberModel;

    private static final String PREF_TITLE = "Preferences";
    private static final Boolean IS_MODAL = false;

    // Listener
    private DialogButtonClickListener buttonClickListener;

    public PreferencesDialog(JFrame parentFrame) {
        super(parentFrame, PREF_TITLE, IS_MODAL);

        // Setting Dialog layout
        setLayout(new GridBagLayout());

        // Initialization
        okBtn = new JButton("Ok");
        cancelBtn = new JButton("Cancel");
        portSpinner = new JSpinner();
        numberModel = new SpinnerNumberModel(3306, 0, 9999, 1); // Params are : Default, Min, Max, Step

        // Setting spinner model
        portSpinner.setModel(numberModel);

        /*
            * GridBagConstraints
            * For structuring components on the GridLayout
            ********************************************************************
         */
        GridBagConstraints gbc = new GridBagConstraints();

        // First row
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0; // First Cell
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Port: "), gbc);
        gbc.gridx = 1; // Second Cell
        add(portSpinner, gbc);

        // Second row
        gbc.gridy++;
        gbc.gridx = 0;
        add(okBtn, gbc);

        gbc.gridx = 1;
        add(cancelBtn, gbc);

        /*
         * *********************************************************************
         */
        // Handle button click
        okBtn.addActionListener((ae) -> {
            if (buttonClickListener != null) {
                buttonClickListener.buttonClick();
                int value = (Integer) portSpinner.getValue();
                System.out.println(value);
                setVisible(false);
            }
        });
        
        cancelBtn.addActionListener((ae) -> {
            setVisible(false);
        });

        setSize(400, 300);

        // Dialog position at the center of parent frame
        setLocationRelativeTo(parentFrame);
    }

    public void setButtonClickListener(DialogButtonClickListener listener) {
        this.buttonClickListener = listener;
    }

}
