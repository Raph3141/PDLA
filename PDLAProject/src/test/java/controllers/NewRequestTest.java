package controllers;

import model.Requests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.*;

public class NewRequestTest {
    private static Connection connection;

    @BeforeClass
    public static void getConnection() {
        connection = DatabaseConnection.getConnection();
    }

    @AfterClass
    public static void closeConnection() {
        DatabaseConnection.closeConnection();
    }

    private String generateUniqueRequestId() {
        return "TestRequestId_" + UUID.randomUUID().toString();
    }

    private String generateUniqueUpdateRequestId() {
        return "TestUpdateRequestId_" + UUID.randomUUID().toString();
    }

    @Test
    public void testAddNewRequest() {
        String uniqueRequestId = generateUniqueRequestId();
        Requests testRequest = new Requests(uniqueRequestId, "helpSeekerId", null, "2023-01-01", "TestLocation", "available", "TestDescription");
        NewRequest newRequest = new NewRequest();

        newRequest.addNewRequest(testRequest);

        // Check that the request was added
        try {
            String selectQuery = "SELECT * FROM Requests WHERE idRequest = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, uniqueRequestId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    assertTrue("Request should be added to the database", resultSet.next());

                    // Check request details
                    assertEquals("helpSeekerId", resultSet.getString("idHelpSeeker"));
                    assertEquals("2023-01-01", resultSet.getString("Date"));
                    assertEquals("TestLocation", resultSet.getString("Location"));
                    assertEquals("available", resultSet.getString("Status"));
                    assertEquals("TestDescription", resultSet.getString("Description"));
                }
            }
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateRequest() {
        // Add a test request to update
        String uniqueUpdateRequestId = generateUniqueUpdateRequestId();
        Requests testRequest = new Requests(uniqueUpdateRequestId, "helpSeekerId", null, "2023-01-01", "TestLocation", "available", "TestDescription");
        NewRequest newRequest = new NewRequest();
        newRequest.addNewRequest(testRequest);

        // Update the test request
        newRequest.UpdateRequest(uniqueUpdateRequestId, "testVolunteerId");

        // Verify that the request was updated
        try {
            String selectQuery = "SELECT * FROM Requests WHERE idRequest = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, uniqueUpdateRequestId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    assertTrue("Request should be found in the database", resultSet.next());

                    // Check the updated details
                    assertEquals("testVolunteerId", resultSet.getString("idVolunteer"));
                    assertEquals("taken", resultSet.getString("Status"));
                }
            }
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }
}
