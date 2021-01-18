package swing11.comboBoxes.components;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author ddok This MainFrame plays a role as a controller for all other
 * components
 */
public class MainFrame extends JFrame {

    private final String title;
    private final int xSize, ySize;

    // Custom components
    private TextPanel textPanel;
    private ToolbarPanel toolbarPanel;
    private FormPanel formPanel;

    public MainFrame(String title, int xSize, int ySize) {
        super(title);
        this.title = title;
        this.xSize = xSize;
        this.ySize = ySize;

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbarPanel = new ToolbarPanel();
        formPanel = new FormPanel();

        toolbarPanel.setTextListener(((str) -> {
            textPanel.pasteTextToTextArea(str);
        }));

        formPanel.setHandleForm((af) -> {
            String formattedInfo = String.format("----------\n Username: %s \n Occupation: %s \n Age: %s \n ---------", 
                    af.getName(), 
                    af.getOccupation(), 
                    af.getAge());
            textPanel.pasteTextToTextArea(formattedInfo);
        });

        add(toolbarPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);

        setSize(xSize, ySize);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
