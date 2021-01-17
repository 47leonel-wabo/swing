package swing.app;

import javax.swing.SwingUtilities;
import swing10.listBoxes.components.MainFrame;

/**
 *
 * @author ddok
 */
public class SwingApp {

    
    public static void main(String[] args) {
        
        /*
            Launch our code in a separated thread (Runnable)
        */
        SwingUtilities.invokeLater(() -> {
            new MainFrame("Swing - Communication", 800, 600);
        });
    }
    
}
