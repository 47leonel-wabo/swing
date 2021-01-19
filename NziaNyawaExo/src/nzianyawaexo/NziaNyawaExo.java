package nzianyawaexo;

import gui.MainWindow;
import javax.swing.SwingUtilities;

/**
 *
 * @author ddok
 */
public class NziaNyawaExo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow("Staff Management | DB Exo");
        });
    }

}
