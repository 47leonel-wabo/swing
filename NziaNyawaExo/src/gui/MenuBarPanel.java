package gui;

import gui.listener.AboutListener;
import gui.listener.CloseAppListener;
import gui.listener.HideShowFormPanelListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author ddok
 */
public class MenuBarPanel extends JMenuBar {

    //private final JMenuBar menuBar;
    private final JMenu fileMenu, helpMenu, viewMenu;
    private final JMenuItem exitMenuItem, aboutMenuItem, newMenuItem;
    private final JCheckBoxMenuItem showHideFromMenuItem;

    private HideShowFormPanelListener hideShowFormPanelListener;
    private AboutListener aboutListener;
    private CloseAppListener closeAppListener;

    public MenuBarPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        //menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        exitMenuItem = new JMenuItem("Quit");
        newMenuItem = new JMenuItem("New");
        showHideFromMenuItem = new JCheckBoxMenuItem("Show Form");

        showHideFromMenuItem.setSelected(true);
        showHideFromMenuItem.setActionCommand("Show-hide-form");

        fileMenu.add(newMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        add(fileMenu);

        viewMenu = new JMenu("View");
        viewMenu.add(showHideFromMenuItem);
        add(viewMenu);

        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About");
        helpMenu.add(aboutMenuItem);
        add(helpMenu);

        // Adding Mnemonic
        fileMenu.setMnemonic(KeyEvent.VK_F);
        viewMenu.setMnemonic(KeyEvent.VK_V);
        helpMenu.setMnemonic(KeyEvent.VK_H);

        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        exitMenuItem.setMnemonic(KeyEvent.VK_Q);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        aboutMenuItem.setMnemonic(KeyEvent.VK_A);

        newMenuItem.setPreferredSize(new Dimension(120, 20));
        aboutMenuItem.setPreferredSize(new Dimension(120, 20));

        showHideFromMenuItem.addActionListener((ae) -> {
            hideShowFormPanelListener.hideOrShowFormPanel(showHideFromMenuItem.isSelected());
        });
        
        aboutMenuItem.addActionListener((ae) -> {
            aboutListener.showAboutDialog();
        });
        
        exitMenuItem.addActionListener((ae) -> {
            closeAppListener.leaveApplication();
        });
    }

    public void addHideShowFormPanelListener(HideShowFormPanelListener listener) {
        this.hideShowFormPanelListener = listener;
    }
    
    public void setAboutListener(AboutListener listener){
        this.aboutListener = listener;
    }

    public void setCloseAppListener(CloseAppListener closeListener){
        this.closeAppListener = closeListener;
    }
}
