package model;

import controllers.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Request {
    Connection connection = DatabaseConnection.getConnection();

    private String requestID;
    private String idHelpSeeker;
    private String idVolunteer;
    private String date;
    private String Location;
    private String Status;
    private String Description;

    public Request(String requestID, String idHelpSeeker, String idVolunteer, String date, String Location, String Status, String Description) {
        this.requestID = requestID;
        this.idHelpSeeker = idHelpSeeker;
        this.idVolunteer = idVolunteer;
        this.date = date;
        this.Location = Location;
        this.Status = Status;
        this.Description = Description;
    }

    public Request() {
        // You can initialize default values or leave them null/empty
    }

    public String getRequestID() {
        return requestID;
    }

    public String getIdHelpSeeker() {
        return idHelpSeeker;
    }

    public String getIdVolunteer() {
        return idVolunteer;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return Location;
    }

    public String getDescription() {
        return Description;
    }

    public String getStatus() {
        return Status;
    }

    public List<Request> getRequests() {
        String selectQuery = "SELECT * FROM requests"; // Assuming your table name is 'requests'
        List<Request> requestList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Request request = new Request(
                        resultSet.getString("requestID"),
                        resultSet.getString("idHelpSeeker"),
                        resultSet.getString("idVolunteer"),
                        resultSet.getString("Date"),
                        resultSet.getString("Location"),
                        resultSet.getString("Status"),
                        resultSet.getString("Description")
                );
                requestList.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requestList;
    }
}
