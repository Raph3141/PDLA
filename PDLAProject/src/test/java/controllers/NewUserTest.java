package controllers;

import model.Users;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Test
    public void testAddNewUser() {
        Users testUser = new Users("testId", "Test", "User", "test@example.com", "testPassword");
        NewUser newUser = new NewUser();

        newUser.addNewUser(testUser);

        // Check that the user was added
        try {
            String selectQuery = "SELECT * FROM Users WHERE idUsers = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, "testId");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    assertTrue("User should be added to the database", resultSet.next());

                    //check user details
                    assertEquals("Test", resultSet.getString("firstName"));
                    assertEquals("User", resultSet.getString("lastName"));
                    assertEquals("test@example.com", resultSet.getString("email"));
                    assertEquals("testPassword", resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void testGetIdWithEmail() throws SQLException {
        NewUser newUser = new NewUser();

        String userId = NewUser.getIdWithEmail("test@example.com", "testPassword");

        assertNotNull("User ID should not be null", userId);
        assertEquals("testId", userId);
    }
}
