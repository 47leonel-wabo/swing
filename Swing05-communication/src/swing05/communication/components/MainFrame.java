package swing05.communication.components;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author ddok
 * This MainFrame plays a role as a controller
 * for all other components
 */
public class MainFrame extends JFrame {
    
    private final String title;
    private final int xSize, ySize;
    
    // Custom components
    private TextPanel textPanel; 
    private ToolbarPanel toolbarPanel;

    public MainFrame(String title, int xSize, int ySize) {
        super(title);
        this.title = title;
        this.xSize = xSize;
        this.ySize = ySize;
        
        setLayout(new BorderLayout());
        
        textPanel = new TextPanel();
        toolbarPanel = new ToolbarPanel();
        
        toolbarPanel.setTextListener(((str) -> {
            textPanel.pasteTextToTextArea(str);
        }));
        
        add(toolbarPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        
        setSize(xSize, ySize);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
