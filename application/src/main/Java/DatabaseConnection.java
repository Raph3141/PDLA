import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";
    private static Connection connection;

    // Private constructor to prevent instantiation from outside the class
    private DatabaseConnection() {
    }

    // Static method to get a database connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the JDBC driver (You should load it only once in your application)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create the connection
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        }
        return connection;
    }

    // Static method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        }
    }
}
