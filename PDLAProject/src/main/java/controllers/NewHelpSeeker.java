package controllers;

import model.HelpSeekers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewHelpSeeker {
    public void addNewHelpSeeker(HelpSeekers helpSeeker) {
        Connection connection = DatabaseConnection.getConnection();

        try {

            String insertQuery = "INSERT INTO HelpSeekers (idUsers) VALUES (?)";

            // Using PreparedStatement to prevent SQL injection
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters using the HelpSeekers class methods
                preparedStatement.setString(1, helpSeeker.getId());

                preparedStatement.executeUpdate();
                System.out.println("HelpSeeker added successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }


}