package swing.app.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author ddok
 *
 */
public class FileFilterUtil extends FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String ext = Utils.getAiwaFileExtension(file.getName());
        if (ext == null) {
            return false;
        }
        if (ext.equals("aiwa")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Aiwa data file extension (*.aiwa)";
    }

}
