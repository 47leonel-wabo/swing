package model;

/**
 *
 * @author ddok
 */
public class DatabaseConnection {

    public void connect() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception("Driver not found");
        }
    }

    public void disconnect() {

    }
}
