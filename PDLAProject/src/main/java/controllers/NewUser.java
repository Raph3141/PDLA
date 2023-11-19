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
            // Using PreparedStatement to prevent SQL injection
            String insertQuery = "INSERT INTO Users (idUsers, firstName, lastName, email, password) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the Users class methods
                // the preparedStatement.setString() method is used to set the values for the placeholders (?) in the SQL query
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPassword());

                // Execute the insert query
                preparedStatement.executeUpdate();
                System.out.println("User added successfully");

                String Id= user.getId();
                String FirstName= user.getFirstName();
                String LastName = user.getLastName();
                String Email = user.getEmail();
                String Password = user.getPassword();

                model.Users newUser = new model.Users(Id, FirstName, LastName, Email, Password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    //for the connect frame
    public static String getIdWithEmail(String email, String password) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        String sql = "SELECT * FROM Users WHERE email = '" + email + "'";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // statement.setString(1, email);
            //statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {

                // get the id
                if (resultSet.next()) {
                    // If there are results, get the id
                    return resultSet.getString("idUsers");
                } else {
                    // No matching user found
                    System.out.println("No matching user found.");
                    return null;

                }
            } catch (SQLException e) {
                // Return null or some indicator if no matching user is found
                System.out.println("SQLException :" + e.getMessage());
                return null;
            }

        }
    }

}
