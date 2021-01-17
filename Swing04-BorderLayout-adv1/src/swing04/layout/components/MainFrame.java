package swing04.layout.components;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author ddok
 */
public class MainFrame extends JFrame {
    
    private final String title;
    private final int xSize, ySize;
    
    private JButton btn;
    
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
        btn =  new JButton("Learn Swing");
        toolbarPanel = new ToolbarPanel();
        
        // Adding click listener
        btn.addActionListener(((arg) -> {
            textPanel.pasteTextToTextArea("\t Hi Swing \n");
        }));
        
        add(toolbarPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        
        setSize(xSize, ySize);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
