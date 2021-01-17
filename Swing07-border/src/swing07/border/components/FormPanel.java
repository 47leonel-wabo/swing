package swing07.border.components;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author ddok
 */
public class FormPanel extends JPanel {

    public FormPanel() {
        setPreferredSize(new Dimension(300, 300));
        
        Border innerBorder = BorderFactory.createTitledBorder("aiwa services");
        Border outerBorder = BorderFactory.createEmptyBorder(8, 8, 16, 8); // TOP, RIGHT, BOTTOM, LEFT
        
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }
    
}
