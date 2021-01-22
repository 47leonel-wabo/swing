package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import model.DbConnectionProfile;

/**
 *
 * @author ddok
 */
public class PreferencesDialog extends JDialog {

    private final JButton okBtn, cancelBtn;
    private final JSpinner portSpinner;
    private final SpinnerNumberModel numberModel;
    private final JPasswordField userPassword;
    private final JTextField userName;

    private static final String PREF_TITLE = "Preferences";
    private static final Boolean IS_MODAL = false;

    // Listener
    private DialogButtonClickListener buttonClickListener;

    public PreferencesDialog(JFrame parentFrame) {
        super(parentFrame, PREF_TITLE, IS_MODAL);

        // Initialization
        okBtn = new JButton("Ok");
        cancelBtn = new JButton("Cancel");
        portSpinner = new JSpinner();
        numberModel = new SpinnerNumberModel(3306, 0, 9999, 1); // Params are : Default, Min, Max, Step
        userName = new JTextField(13);
        userPassword = new JPasswordField(13);

        // Setting spinner model
        portSpinner.setModel(numberModel);

        layoutComponents();

        // Handle button click
        okBtn.addActionListener((ae) -> {
            if (buttonClickListener != null) {
                int portNumber = (Integer) portSpinner.getValue();
                String username = userName.getText();
                char[] userPass = this.userPassword.getPassword();

                buttonClickListener.buttonClick(new DbConnectionProfile(username, new String(userPass), portNumber));
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

    public void setDefaultProfile(DbConnectionProfile profile) {
        userName.setText(profile.getUsername());
        userPassword.setText(profile.getPassword());
        portSpinner.setValue(profile.getPort());
    }

    private void layoutComponents() {
        /*
            * GridBagConstraints
            * For structuring components on the GridLayout
            ********************************************************************
         */
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel buttonPanel = new JPanel();
        JPanel fieldsPanel = new JPanel();

        fieldsPanel.setBorder(BorderFactory.createTitledBorder("DB Connection Credentials"));

        // Setting ok button the same size as cancel button
        okBtn.setPreferredSize(cancelBtn.getPreferredSize());
        okBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                okBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Changing default cursor icon type
            }

        });
        // Setting Dialog layout
        fieldsPanel.setLayout(new GridBagLayout());

        // First row
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0; // First Cell
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.insets = new Insets(0, 0, 0, 15);
        fieldsPanel.add(new JLabel("Port: "), gbc);
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        gbc.gridx = 1; // Second Cell
        fieldsPanel.add(portSpinner, gbc);

        // next row - Username
        gbc.weighty = .1;
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        fieldsPanel.add(new JLabel("Username: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        fieldsPanel.add(userName, gbc);

        // next row - Password
        gbc.weighty = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        fieldsPanel.add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        fieldsPanel.add(userPassword, gbc);

        // Button Panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(okBtn);
        buttonPanel.add(cancelBtn);

        /*
         * *********************************************************************
         */
        // Adding sub components to the dialog
        setLayout(new BorderLayout());
        add(fieldsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

}
