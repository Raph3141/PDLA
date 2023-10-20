package controllers;
import model.Users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

public class NewUser {
    public void AddNewUser(Users user){
        DatabaseConnection dbConnection = new DatabaseConnection();
        String selectQuery = "INSERT INTO Users (idUsers,firstName,lastName,email,password) Values (test2,test2,test2,test2,test2)";
        ResultSet resultSet = dbConnection.executeQuery(selectQuery);
    }

}
