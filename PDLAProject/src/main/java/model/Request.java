package model;

import controllers.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Request {
    Connection connection = DatabaseConnection.getConnection();

    private String requestID;
    private final String idHelpSeeker;
    private String idVolunteer = null; //change value when request is accepted to know who took it
    private final String Date;
    private final String Location;
    private String Status = null; //change value when request is accepted to know it is taken
    private final String Description;

    public Request(String requestID, String idHelpSeeker, String idVolunteer, String Date, String Location, String Status, String Description) {
        this.requestID=requestID;
        this.idHelpSeeker = idHelpSeeker;
        this.idVolunteer = idVolunteer;
        this.Date = Date;
        this.Location = Location;
        this.Status=Status;
        this.Description = Description;
    }

    public String getRequestID(){
        return requestID;
    }
    public String getIdHelpSeeker(){return idHelpSeeker;}

    public String getIdVolunteer(){return idVolunteer;}

    public String getDate(){return Date;}

    public String getLocation(){return Location;}

    public String getDescription(){return Description;}

    public String getStatus(){return Status;}

    public String getRequests() {
        String selectQuery = "SELECT * FROM requests"; // Assuming your table name is 'requests'
        StringBuilder result = new StringBuilder();

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.append("Request ID: ").append(resultSet.getString("requestID")).append(", ")
                        .append("Help Seeker ID: ").append(resultSet.getString("idHelpSeeker")).append(", ")
                        .append("Volunteer ID: ").append(resultSet.getString("idVolunteer")).append(", ")
                        .append("Date: ").append(resultSet.getString("Date")).append(", ")
                        .append("Location: ").append(resultSet.getString("Location")).append(", ")
                        .append("Status: ").append(resultSet.getString("Status")).append(", ")
                        .append("Description: ").append(resultSet.getString("Description"))
                        .append(System.lineSeparator());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
