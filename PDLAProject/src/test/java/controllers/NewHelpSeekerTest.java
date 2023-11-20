package controllers;

import model.HelpSeekers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class NewHelpSeekerTest {
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
    public void testAddNewHelpSeeker() {
        HelpSeekers testHelpSeeker = new HelpSeekers("TestHelpSeekerId","TestHelpSeekerFirstName","TestHelpSeekerSurname","TestHelpSeekerMail","TestHelpSeekerPassword");
        NewHelpSeeker newHelpSeeker = new NewHelpSeeker();

        newHelpSeeker.addNewHelpSeeker(testHelpSeeker);

        // Check that the HelpSeeker was added
        try {
            String selectQuery = "SELECT * FROM HelpSeekers WHERE idUsers = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, "TestHelpSeekerId");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    assertTrue("HelpSeeker should be added to the database", resultSet.next());
                }
            }
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }
}
