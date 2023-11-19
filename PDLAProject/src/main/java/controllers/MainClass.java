package controllers;
import model.*;
import view.Login;

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
            //Request newRequest = new Request("exampleRequestID", "exampleHelpSeekerID", null, "2023-11-17", "Example Location", null, "Example Description");
            //NewRequest newRequestHandler = new NewRequest();
            //newRequestHandler.addNewRequest(newRequest);
            //Volunteers newVolunteer = new Volunteers("v2", "t", "t", "t", "t");
            //NewVolunteer newVolunteerHandler = new NewVolunteer();
            //newVolunteerHandler.addNewVolunteer(newVolunteer);

            Login log = new Login();

        } finally {
            // closes the connection when done
            DatabaseConnection.closeConnection();
        }
    }
}
