package controllers;
import model.*;

import java.sql.Connection;
import java.sql.SQLException;
public class MainClass {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            // Use the connection for database operations

            //Users newUser = new Users("test4", "John", "Doe", "john.doe@example.com", "password123");
            //NewUser newUserHandler = new NewUser();
            //newUserHandler.addNewUser(newUser);

            Request newRequest = new Request("r1","null","date", "location", "description");
            NewRequest newRequestHandler = new NewRequest();
            newRequestHandler.addNewRequest(newRequest);


        } finally {
            // closes the connection when done
            DatabaseConnection.closeConnection();
        }
    }
}
