package gui;

import com.formdev.flatlaf.FlatLightLaf;
import controller.AppController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 *
 * @author ddok This MainFrame plays a role as a controller for all other
 * components
 */
public class MainFrame extends JFrame {

    private final String title;
    private final int xSize, ySize;

    // Custom components
    //private final TextPanel textPanel;
    private final ToolbarPanel toolbarPanel;
    private final FormPanel formPanel;
    private final JFileChooser fileChooser;
    private final TablePanel tablePanel;

    // App Controller
    private AppController appController;

    public MainFrame(String title, int xSize, int ySize) {
        super(title);

        /*
            Look and Feel
         */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
//        try {
//            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            // If Nimbus is not available, you can set the GUI to another look and feel.
//        }

        this.title = title;
        this.xSize = xSize;
        this.ySize = ySize;

        setLayout(new BorderLayout());

        // App Menu Bar
        setJMenuBar(createMenuBar());

        //textPanel = new TextPanel();
        toolbarPanel = new ToolbarPanel();
        formPanel = new FormPanel();
        fileChooser = new JFileChooser();
        appController = new AppController();
        tablePanel = new TablePanel();

        // Passing a list of data to table panel component
        tablePanel.setTableModelData(appController.getPeople());
        
        tablePanel.setDeleteRowListener((position) -> {
            if (appController.removePerson(position)) {
                tablePanel.refreshTable();
            }
        });

        // File Chooser
        //fileChooser.setMultiSelectionEnabled(true);

        // This will be triggered when "save" button on form panel will be push
        formPanel.setHandleForm((ActivityForm af) -> {
            // Passing data recieved to the app controller
            appController.addPerson(af);
            tablePanel.refreshTable(); // Once passing data, we refresh the table component
        });

        add(toolbarPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);

        // Windows size definition
        setSize(xSize, ySize);
        setMinimumSize(new Dimension(600, 400)); // Constraint minimum windows size
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JMenuBar createMenuBar() {
        /*
            Defining all the menu content
         */
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        final JMenuItem exportItem = new JMenuItem("Export Data...");
        fileMenu.add(exportItem);
        final JMenuItem importItem = new JMenuItem("Import Data...");
        fileMenu.add(importItem);
        fileMenu.addSeparator();
        final JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        helpMenu.add(aboutMenuItem);

        JMenu showFormMenu = new JMenu("Show");
        JMenuItem showFormItem = new JMenuItem("Person Form");
        JCheckBoxMenuItem showCheckBoxMenuItem = new JCheckBoxMenuItem("Get Form");
        showCheckBoxMenuItem.setActionCommand("Show-menu");
        showCheckBoxMenuItem.setSelected(true);
        showFormMenu.add(showFormItem);

        JMenu windowMenu = new JMenu("Window");
        windowMenu.add(showFormMenu);
        windowMenu.add(showCheckBoxMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        menuBar.add(helpMenu);

        // File Action Listener - Export
        exportItem.addActionListener(((ae) -> {
            fileChooser.addChoosableFileFilter(new FileFilterUtil()); // Set a custom file filter (not working for now)
            if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                try{
                appController.saveToFile(fileChooser.getSelectedFile());
                //System.out.println(fileChooser.getSelectedFile());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(
                            MainFrame.this, 
                            "File loaded successfuly!", 
                            "File Loading",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }));

        // File Action Listener - Import
        importItem.addActionListener(((ae) -> {
            int file = fileChooser.showOpenDialog(MainFrame.this);
            if (file == JFileChooser.APPROVE_OPTION) {
                /*for (File f : fileChooser.getSelectedFiles()) {
                    System.out.println(f.getAbsolutePath());
                }*/
                try {
                    appController.loadFromFile(fileChooser.getSelectedFile());
                    tablePanel.refreshTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(
                            MainFrame.this, 
                            "Unable to load data!", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }));
        
        importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

        // Show Form Action Listener
        showCheckBoxMenuItem.addActionListener((a) -> {
            formPanel.setVisible(showCheckBoxMenuItem.isSelected());
        });

        // Quit item listener
        quitItem.addActionListener((ae) -> {
            /*
                First show a confirm dialog 
                before closing our application
             */
            int action = JOptionPane.showConfirmDialog(
                    MainFrame.this,
                    "Do you really want to quit this application",
                    "Confirm Exist",
                    JOptionPane.CANCEL_OPTION);
            if (action == JOptionPane.OK_OPTION) {
                // Close only if user clicked OK
                System.exit(0);
            }

        });

        // About menu item Listener
        aboutMenuItem.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(MainFrame.this,
                    "This is a sample application builds\nin order to acquire Java Swing \nconcepts and principles!",
                    "About",
                    JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
        });
        // Adding Mnemonics
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + F
        helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + A
        exportItem.setMnemonic(KeyEvent.VK_E); // Alt + E
        windowMenu.setMnemonic(KeyEvent.VK_W);
        quitItem.setMnemonic(KeyEvent.VK_Q);
        importItem.setMnemonic(KeyEvent.VK_I);
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);

        // Adding Accelerator
        // Ctrl + X, to close the program
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        return menuBar;
    }
}
