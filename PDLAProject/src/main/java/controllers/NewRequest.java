package controllers;

import model.Request;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewRequest {
    public void addNewRequest(Request request) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            // Using PreparedStatement to prevent SQL injection
            String insertQuery = "INSERT INTO Request (idHelpSeeker, idVolunteer, Date, Location, Description) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the Users class methods
                // the preparedStatement.setString() method is used to set the values for the placeholders (?) in the SQL query
                preparedStatement.setString(1, request.getIdHelpSeeker());
                preparedStatement.setString(2, request.getIdVolunteer());
                preparedStatement.setString(3, request.getDate());
                preparedStatement.setString(4, request.getLocation());
                preparedStatement.setString(5, request.getDescription());

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
