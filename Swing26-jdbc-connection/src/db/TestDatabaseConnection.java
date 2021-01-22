package db;

import model.DatabaseConnection;

/**
 *
 * @author ddok
 */
public class TestDatabaseConnection {

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        try {
            db.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        db.disconnect();
    }
}
