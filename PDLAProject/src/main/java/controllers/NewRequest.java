package controllers;

import model.Requests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewRequest {
    public void addNewRequest(Requests request) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            // Using PreparedStatement to prevent SQL injection
            String insertQuery = "INSERT INTO Requests (idRequest, idHelpSeeker, idVolunteer, Date, Location, Status, Description) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the Users class methods
                // the preparedStatement.setString() method is used to set the values for the placeholders (?) in the SQL query
                preparedStatement.setString(1, request.getRequestID());
                preparedStatement.setString(2, request.getIdHelpSeeker());
                preparedStatement.setString(3, request.getIdVolunteer());
                preparedStatement.setString(4, request.getDate());
                preparedStatement.setString(5, request.getLocation());
                preparedStatement.setString(6, request.getStatus());
                preparedStatement.setString(7, request.getDescription());

                // Execute the insert query
                preparedStatement.executeUpdate();
                System.out.println("Request added successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}
