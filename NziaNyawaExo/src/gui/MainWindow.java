package gui;

import controller.AppController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author ddok
 */
public class MainWindow extends JFrame {

    private final TablePanel dataTable;
    private final FormPanel registrationForm;
    private final MenuBarPanel menuBarPanel;
    private final AppController appController;

    public MainWindow(String title) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout());

        // Initializing components
        dataTable = new TablePanel();
        registrationForm = new FormPanel();
        menuBarPanel = new MenuBarPanel();
        appController = new AppController();

        // Setting our menu bar
        setJMenuBar(menuBarPanel);

        // Passing a list of data to our table
        passingDataToTableModel();

        // Retrieving form data through an interface
        registrationForm.addFormListener((personData) -> {
            // Data should be passed to DAO
            appController.addUser(personData);
            dataTable.refreshTable();
        });

        menuBarPanel.addHideShowFormPanelListener((status) -> {
            // Show or hide registration form
            registrationForm.setVisible(status);
        });

        menuBarPanel.setAboutListener(() -> {
            JOptionPane.showMessageDialog(
                    MainWindow.this,
                    "Nzia\nThis application is part of an interesting"
                    + "\ncourse on building User Interfaces with "
                    + "\nJava Swing.",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        menuBarPanel.setCloseAppListener(() -> {
            /*
                First show a confirm dialog 
                before closing the application
             */
            int action = JOptionPane.showConfirmDialog(
                    MainWindow.this,
                    "Do you really want to quit this application",
                    "Confirm Exist",
                    JOptionPane.CANCEL_OPTION);
            if (action == JOptionPane.OK_OPTION) {
                // Close only if user clicked OK
                System.exit(0);
            }
        });

        // Positioning element (component) on the layout
        add(menuBarPanel, BorderLayout.NORTH);
        add(dataTable, BorderLayout.CENTER);
        add(registrationForm, BorderLayout.WEST);

        setSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(600, 400)); // Constraint minimum windows size
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void passingDataToTableModel() {
        dataTable.addDataToTableModel(appController.getPeople());
    }

}
