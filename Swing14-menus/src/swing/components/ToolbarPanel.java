package swing.components;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import swing14.menus.HandleString;
/**
 *
 * @author ddok
 */
public class ToolbarPanel extends JPanel implements ActionListener{
    
    private JButton fileBtn, aboutBtn;
    private HandleString textListener;

    public ToolbarPanel() {
        fileBtn = new JButton("File");
        aboutBtn = new JButton("About");
        
        fileBtn.addActionListener(this);
        aboutBtn.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        add(fileBtn);
        add(aboutBtn);
    }
    
    public void setTextListener(HandleString txtListener){
        textListener = txtListener;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton btn = (JButton) ae.getSource();
        if (btn == fileBtn) {
            if (textListener != null) {
                textListener.handleText("File\n");
            }
        }
        if (btn == aboutBtn) {
            if (textListener != null) {
                textListener.handleText("About\n");
            }
        }
    }
    
}
