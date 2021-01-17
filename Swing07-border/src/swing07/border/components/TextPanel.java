package swing07.border.components;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author ddok
 */
public class TextPanel extends JPanel {
    
    private JTextArea textArea;
    
    public TextPanel(){
        setLayout(new BorderLayout());

        
        Border outerBorder = BorderFactory.createEmptyBorder(8, 8, 8, 8);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, outerBorder));
        
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
    
    public void pasteTextToTextArea(String text){
        textArea.append(text);
    }
}
