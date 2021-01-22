package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ddok
 */
public class DBConnection {

    private static Connection con;

    public static Connection getConnection() throws Exception {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                throw new Exception("Driver not found");
            }
            String url = "jdbc:mysql://localhost:3306/swing_db";
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Database connection established!");
            return con;
        } else {
            System.out.println("Database connection remains established!");
            return con;
        }
    }

    public static void disconnect(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed!");
            } catch (SQLException ex) {
                System.out.println("Can't close connection");
            }
        }
    }

}
