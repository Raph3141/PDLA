package controllers;
import model.*;
import controllers.DatabaseConnection;
import model.*;
import view.*;
import java.sql.Connection;

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

            // Don't forget to close the connection when done
            DatabaseConnection.closeConnection();
    }
}
