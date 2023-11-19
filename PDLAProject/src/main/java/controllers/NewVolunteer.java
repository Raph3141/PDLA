package controllers;

import model.Volunteers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewVolunteer {
    public void addNewVolunteer(Volunteers volunteer) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            // Using PreparedStatement to prevent SQL injection
            String insertQuery = "INSERT INTO Volunteers (idUsers, firstName, lastName, email, password) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the Volunteers class methods
                preparedStatement.setString(1, volunteer.getId());
                preparedStatement.setString(2, volunteer.getFirstName());
                preparedStatement.setString(3, volunteer.getLastName());
                preparedStatement.setString(4, volunteer.getEmail());
                preparedStatement.setString(5, volunteer.getPassword());

                // Execute the insert query
                preparedStatement.executeUpdate();
                System.out.println("Volunteer added successfully");
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // Handle SQL exceptions
    private void handleSQLException(SQLException e) {
        e.printStackTrace();
    }
}
