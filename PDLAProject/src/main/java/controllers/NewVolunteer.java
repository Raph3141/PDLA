package controllers;

import model.Volunteers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewVolunteer {
    public void addNewVolunteer(Volunteers volunteer) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String insertQuery = "INSERT INTO Volunteers (idUsers) VALUES (?)";

            // Using PreparedStatement to prevent SQL injection
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the Volunteers class methods
                preparedStatement.setString(1, volunteer.getId());

                preparedStatement.executeUpdate();
                System.out.println("Volunteer added successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
}