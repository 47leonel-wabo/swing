package swing01.layout;

import javax.swing.SwingUtilities;
import swing01.layout.frames.MainFrame;

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
            new MainFrame("Swing - Layout", 800, 600);
        });
    }
    
}
