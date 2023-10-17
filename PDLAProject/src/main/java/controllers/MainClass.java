package controllers;
import model.*;
import controllers.DatabaseConnection;
import model.Users;
import java.sql.Connection;
public class MainClass {
        public static void main(String[] args) {
            Users foo = new Users("001","fn","ln","foo@email.com","pw");
            System.out.println("MY NAME IS "+foo.getFirstName());
            Connection connection = DatabaseConnection.getConnection();
            // Use the connection for database operations


            // Don't forget to close the connection when done
            DatabaseConnection.closeConnection();
    }
}
