package swing01.layout.frames;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author ddok
 */
public class MainFrame extends JFrame {
    
    private final String title;
    private final int xSize, ySize;
    
    private JTextArea textArea;
    private JButton btn;

    public MainFrame(String title, int xSize, int ySize) {
        super(title);
        this.title = title;
        this.xSize = xSize;
        this.ySize = ySize;
        
        setLayout(new BorderLayout());
        
        textArea = new JTextArea();
        btn =  new JButton("Learn Swing");
        
        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        
        setSize(xSize, ySize);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
