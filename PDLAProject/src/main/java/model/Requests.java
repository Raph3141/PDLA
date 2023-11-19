package model;

import controllers.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Requests {
    Connection connection = DatabaseConnection.getConnection();

    private String idRequest;
    private String idHelpSeeker;
    private String idVolunteer;
    private String date;
    private String Location;
    private String Status;
    private String Description;

    public Requests(String idRequest, String idHelpSeeker, String idVolunteer, String date, String Location, String Status, String Description) {
        this.idRequest = idRequest;
        this.idHelpSeeker = idHelpSeeker;
        this.idVolunteer = idVolunteer;
        this.date = date;
        this.Location = Location;
        this.Status = Status;
        this.Description = Description;
    }

    public Requests() {
        // You can initialize default values or leave them null/empty
    }

    public String getRequestID() {
        return idRequest;
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

    public List<Requests> getRequests() {
        String selectQuery = "SELECT * FROM Requests"; // Assuming your table name is 'requests'
        List<Requests> requestList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Requests request = new Requests(
                        resultSet.getString("idRequest"),
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
