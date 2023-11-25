package org.classes;

import controllers.*;
import model.HelpSeekers;
import model.Requests;
import model.Users;
import model.Volunteers;
import view.WelcomePage;

import java.sql.Connection;
import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        try {

            WelcomePage welcomePage = new WelcomePage();

            // Wait until the WelcomePage is closed
            synchronized (welcomePage) {
                try {
                    welcomePage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            DatabaseConnection.closeConnection(); // Close the connection when done
        }
    }

    // Example method for testing user registration
    private static void testUserRegistration() throws SQLException {
        Users newUser = new Users("idUser UReg", "Name UReg", "Surname UReg", "mail UReg", "password UReg");
        NewUser newUserHandler = new NewUser();
        newUserHandler.addNewUser(newUser);
    }

    // Example method for testing request creation
    private static void testRequestCreation() throws SQLException {
        Requests newRequest = new Requests("idRequest testing method request", "idHelpSeeker testing method request", null, "2002-08-17", "Location testing method request", "available", "description testing method request");
        NewRequest newRequestHandler = new NewRequest();
        newRequestHandler.addNewRequest(newRequest);
    }

    // Example method for testing volunteer registration
    private static void testVolunteerRegistration() throws SQLException {
        Volunteers newVolunteer = new Volunteers("idV VReg", "Name VReg", "Surame VReg", "mail VReg", "password VReg");
        NewVolunteer newVolunteerHandler = new NewVolunteer();
        newVolunteerHandler.addNewVolunteer(newVolunteer);
    }

    // Example method for testing help seeker registration
    private static void testHelpSeekerRegistration() throws SQLException {
        HelpSeekers newHelpSeeker = new HelpSeekers("idH HReg", "Name HReg", "Surname HReg", "mail HReg", "password HReg");
        NewHelpSeeker newHelpSeekerHandler = new NewHelpSeeker();
        newHelpSeekerHandler.addNewHelpSeeker(newHelpSeeker);
    }
}

