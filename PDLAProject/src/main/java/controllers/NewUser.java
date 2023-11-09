package controllers;

import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewUser {
    public void addNewUser(Users user) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            // Using PreparedStatement to prevent SQL injection
            String insertQuery = "INSERT INTO Users (idUsers, firstName, lastName, email, password) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the Users class methods
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPassword());

                // Execute the insert query
                preparedStatement.executeUpdate();
                System.out.println("User added successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        } finally {
            // Don't forget to close the connection when done
            DatabaseConnection.closeConnection();
        }
    }
}
