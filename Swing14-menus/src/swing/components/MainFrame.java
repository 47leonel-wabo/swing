package swing.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

        setSize(xSize, ySize);
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

        JMenu aboutMenu = new JMenu("About");

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
        menuBar.add(aboutMenu);

        // File Action Listener - Export
        exportItem.addActionListener(((ae) -> {
            System.out.println("Export");
        }));

        // Show Form Action Listener
        showCheckBoxMenuItem.addActionListener((a) -> {
            formPanel.setVisible(showCheckBoxMenuItem.isSelected());
        });

        // Quit item listener
        quitItem.addActionListener((ae) -> {
            System.exit(0);
        });

        // Adding Mnemonics
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + F
        aboutMenu.setMnemonic(KeyEvent.VK_A); // Alt + A
        exportItem.setMnemonic(KeyEvent.VK_E); // Alt + E
        windowMenu.setMnemonic(KeyEvent.VK_W);
        quitItem.setMnemonic(KeyEvent.VK_Q);
        importItem.setMnemonic(KeyEvent.VK_I);

        // Adding Accelerator
        // Ctrl + X, to close the program
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        return menuBar;
    }
}
