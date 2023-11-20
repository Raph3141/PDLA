package controllers;

import model.Volunteers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class NewVolunteerTest {
    private static Connection connection;

    @BeforeClass
    public static void getConnection() {
        connection = DatabaseConnection.getConnection();
    }

    @AfterClass
    public static void closeConnection() {
        DatabaseConnection.closeConnection();
    }

    @Test
    public void testAddNewVolunteer() {
        Volunteers testVolunteer = new Volunteers("TestVolunteerId","TestVolunteerFirstName","TestVolunteerSurname","TestVolunteerMail","TestVolunteerPassword");
        NewVolunteer newVolunteer = new NewVolunteer();

        newVolunteer.addNewVolunteer(testVolunteer);

        // Check that the Volunteer was added
        try {
            String selectQuery = "SELECT * FROM Volunteers WHERE idUsers = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, "TestVolunteerId");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    assertTrue("Volunteer should be added to the database", resultSet.next());
                }
            }
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }
}
