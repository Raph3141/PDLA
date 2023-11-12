package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_003";
    private static final String USERNAME = "projet_gei_003";
    private static final String PASSWORD = "roh7iuSo";
    private static Connection connection;

    // Static method to get a database connection
    public static Connection getConnection() { //test
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create the connection
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                System.out.println("Connected to the database");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Static method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from the database");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}