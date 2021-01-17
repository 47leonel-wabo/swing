package swing04.layout.components;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author ddok
 */
public class ToolbarPanel extends JPanel {
    
    private JButton fileBtn, aboutBtn;

    public ToolbarPanel() {
        fileBtn = new JButton("File");
        aboutBtn = new JButton("About");
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        add(fileBtn);
        add(aboutBtn);
    }
    
}
