package swing.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author ddok This MainFrame plays a role as a controller for all other
 * components
 */
public class MainFrame extends JFrame {

    private final String title;
    private final int xSize, ySize;

    // Custom components
    private final TextPanel textPanel;
    private final ToolbarPanel toolbarPanel;
    private final FormPanel formPanel;
    private final JFileChooser fileChooser;

    public MainFrame(String title, int xSize, int ySize) {
        super(title);
        this.title = title;
        this.xSize = xSize;
        this.ySize = ySize;

        setLayout(new BorderLayout());

        // App Menu Bar
        setJMenuBar(createMenuBar());

        textPanel = new TextPanel();
        toolbarPanel = new ToolbarPanel();
        formPanel = new FormPanel();
        fileChooser = new JFileChooser();
        
        // File Chooser
        fileChooser.setMultiSelectionEnabled(true);

        toolbarPanel.setTextListener(((str) -> {
            textPanel.pasteTextToTextArea(str);
        }));

        formPanel.setHandleForm((af) -> {
            String formattedInfo = String.format("----------\n Username: %s \n Occupation: %s \n Age: %s \n ---------",
                    af.getName(),
                    af.getOccupation(),
                    af.getAge());
            textPanel.pasteTextToTextArea(formattedInfo);
        });

        add(toolbarPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);

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
            if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(fileChooser.getSelectedFile());
            }
        }));
        
        // File Action Listener - Import
        importItem.addActionListener(((ae) -> {
            int file = fileChooser.showOpenDialog(MainFrame.this);
            if (file == JFileChooser.APPROVE_OPTION) {
                for(File f : fileChooser.getSelectedFiles()){
                    System.out.println(f.getAbsolutePath());
                }
            }
        }));

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
                    "Do you really want to Quit the application",
                    "Confirm Exist",
                    JOptionPane.CANCEL_OPTION);
            if (action == JOptionPane.OK_OPTION) {
                // Close only if user clicked OK
               System.exit(0); 
            }
            
        });

        
        // About menu item Listener
        aboutMenuItem.addActionListener((ae) -> {
            /*String inputValue = JOptionPane.showInputDialog(MainFrame.this,
                    "Enter your user name",
                    "aiwa | Login",
                    JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
            System.out.println(inputValue);*/
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
