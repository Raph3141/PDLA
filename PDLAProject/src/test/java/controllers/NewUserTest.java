package controllers;

import model.Users;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.*;

public class NewUserTest {
    private static Connection connection;

    @BeforeClass
    public static void getConnection() {
        connection = DatabaseConnection.getConnection();
    }

    @AfterClass
    public static void closeConnection() {
        DatabaseConnection.closeConnection();
    }

    private String generateUniqueUserId() {
        return "TestUserId_" + UUID.randomUUID().toString();
    }

    private String generateUniqueUserPassword() {
        return "TestUserPassword_" + UUID.randomUUID().toString();
    }

    private String generateUniqueUserEmail() {
        return "TestUserEmail_" + UUID.randomUUID().toString();
    }

    @Test
    public void testAddNewUser() {
        String uniqueUserId = generateUniqueUserId();
        Users testUser = new Users(uniqueUserId, "TestFirstName", "TestLastName", "Test@example.com", "TestPassword");
        NewUser newUser = new NewUser();

        newUser.addNewUser(testUser);

        // Check that the user was added
        try {
            String selectQuery = "SELECT * FROM Users WHERE idUsers = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, uniqueUserId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    assertTrue("User should be added to the database", resultSet.next());

                    // Check user details
                    assertEquals("TestFirstName", resultSet.getString("firstName"));
                    assertEquals("TestLastName", resultSet.getString("lastName"));
                    assertEquals("Test@example.com", resultSet.getString("email"));
                    // Avoid checking passwords in tests
                }
            }
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void testRetrieveUserIdByEmailAndPassword() {
        String uniqueUserId2 = generateUniqueUserId();
        String uniqueUserEmail2 = generateUniqueUserEmail().substring(0,20);
        String uniqueUserPassword2 = generateUniqueUserPassword().substring(0,20);

        NewUser newUser = new NewUser();

        // Add a test user to the database
        Users testUser = new Users(uniqueUserId2, "TestFirstName2", "TestLastName2", uniqueUserEmail2, uniqueUserPassword2);
        newUser.addNewUser(testUser);

        // Retrieve the user ID based on email and password
        try {
            String userId = NewUser.getIdWithEmail(uniqueUserEmail2, uniqueUserPassword2);

            assertNotNull("User ID should not be null", userId);
            assertEquals(uniqueUserId2, userId);
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }
}
