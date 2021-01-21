package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author ddok
 */
public class PreferencesDialog extends JDialog{
    
    private static final String PREF_TITLE = "Preferences";
    private static final Boolean IS_MODAL = false;

    public PreferencesDialog(JFrame parentFrame) {
        super(parentFrame, PREF_TITLE, IS_MODAL);
        
        
        setSize(400, 300);
    }
    
}
