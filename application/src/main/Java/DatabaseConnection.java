import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/";
    private static final String USERNAME = "projet_gei_003";
    private static final String PASSWORD = "roh7iuSo";
    private static Connection connection;

    public String createTableUsers() {
        String createUser = "CREATE TABLE IF NOT EXISTS Users ("
                + "idUsers VARCHAR(20) PRIMARY KEY,"
                + "firstName VARCHAR(20) NOT NULL,"
                + "lastName VARCHAR(20) NOT NULL,"
                + "email VARCHAR(40) NOT NULL,"
                + "password VARCHAR(20) NOT NULL"
                +")";
        return createUser;

        public String createTableHelp_Seeker() {
            String createHelp_Seeker = "CREATE TABLE IF NOT EXISTS Help_Seekers ("
                    + "idUsers VARCHAR(20) REFERENCES Users(idUsers) ON DELETE CACASDE"
                    +")";
            return createHelp_Seeker;
    }

        public String createTableVolunteer() {
            String createVolunteer = "CREATE TABLE IF NOT EXISTS Volunteers ("
                    + "idUsers VARCHAR(20) REFERENCES Users(idUsers) ON DELETE CACASDE"
                    +")";
            return createHelp_Seeker;
        }
    }

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
