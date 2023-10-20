package controllers;
import model.*;
import controllers.DatabaseConnection;
import model.*;
import view.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static view.class1.CreateAndShowWindow;

public class MainClass {
        public static void main(String[] args) {
            Users foo = new Users("001","fn","ln","foo@email.com","pw");
            System.out.println("MY NAME IS "+foo.getFirstName());
            Connection connection = DatabaseConnection.getConnection();
            // Use the connection for database operations

            //run view
            /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                   class1.CreateAndShowWindow();
                }
            });*/

            try {
                // Load the JDBC driver (You should load it only once in your application)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create the connection
                connection = DriverManager.getConnection("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/", "projet_gei_003", "roh7iuSo");
                //System.out.println("Connected to the database");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                // Handle the exception as needed
            }

            // Don't forget to close the connection when done
            DatabaseConnection.closeConnection();
    }
}
