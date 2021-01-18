package swing.app.utils;

/**
 *
 * @author ddok
 */
public class Utils {

    public static String getAiwaFileExtension(String text) {
        int index = text.lastIndexOf(".");
        if (index == -1) {
            // Here it doesn't find a dot
            return null;
        }
        if (index == text.length() - 1) {
            // Here the dot is right at the end of the file name
            return null;
        }

        return text.substring(index + 1, text.length());
    }

}
