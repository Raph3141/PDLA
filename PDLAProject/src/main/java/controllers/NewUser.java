package controllers;

import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class NewUser {

    public void addNewUser(Users user) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String insertQuery = "INSERT INTO Users (idUsers, firstName, lastName, email, password) VALUES (?, ?, ?, ?, ?)";

            // Using PreparedStatement to prevent SQL injection
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the Users class methods
                // the preparedStatement.setString() method is used to set the values for the placeholders (?) in the SQL query
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPassword());

                preparedStatement.executeUpdate();
                System.out.println("User added successfully");

                String Id= user.getId();
                String FirstName= user.getFirstName();
                String LastName = user.getLastName();
                String Email = user.getEmail();
                String Password = user.getPassword();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    // Get the user id with the email and the password for the connect frame
    public static String getIdWithEmail(String email, String password) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        String sql = "SELECT * FROM Users WHERE email = '" + email + "' AND password = '" + password+"'";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {

                // Get the id
                if (resultSet.next()) {
                    // If there are results, get the id
                    return resultSet.getString("idUsers");
                } else {
                    // No matching user found
                    System.out.println("No matching user found.");
                    return null;

                }
            } catch (SQLException e) {
                System.out.println("SQLException :" + e.getMessage());
                return null;
            }

        }
    }

}
