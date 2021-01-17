package swing01.basics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ddok
 */
public class Swing01Basics {

    
    public static void main(String[] args) {
        
        /*
            Launch our code in a separated thread (Runnable)
        */
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing - Basics (Frame)");
            frame.setResizable(false);
            frame.setSize(800, 600);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
        
    }
    
}
