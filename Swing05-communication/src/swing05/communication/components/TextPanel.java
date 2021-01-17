package swing05.communication.components;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ddok
 */
public class TextPanel extends JPanel {
    
    private JTextArea textArea;
    
    public TextPanel(){
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
    
    public void pasteTextToTextArea(String text){
        textArea.append(text);
    }
}
