package controllers;

import model.HelpSeekers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewHelpSeeker {
    public void addNewHelpSeeker(HelpSeekers helpSeeker) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            // Using PreparedStatement to prevent SQL injection
            String insertQuery = "INSERT INTO HelpSeekers (idUsers, firstName, lastName, email, password) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the HelpSeekers class methods
                preparedStatement.setString(1, helpSeeker.getId());
                preparedStatement.setString(2, helpSeeker.getFirstName());
                preparedStatement.setString(3, helpSeeker.getLastName());
                preparedStatement.setString(4, helpSeeker.getEmail());
                preparedStatement.setString(5, helpSeeker.getPassword());

                // Execute the insert query
                preparedStatement.executeUpdate();
                System.out.println("HelpSeeker added successfully");
            }
        } catch (SQLException e) {
            handleSQLException(e);
            // Handle the exception as needed
        }
    }

    // Handle SQL exceptions
    private void handleSQLException(SQLException e) {
        e.printStackTrace();
    }
}
