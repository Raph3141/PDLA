package view;

import controllers.NewRequest;
import model.Requests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class TakenRequests {

    TakenRequests(String idVolunteer){
        NewFrame TakenRequestFrame = new NewFrame();

        List<Requests> Requests = new Requests().getRequests();

        // Create a panel to hold the list of requests
        JPanel RequestPanel = new JPanel();
        RequestPanel.setLayout(new BoxLayout(RequestPanel, BoxLayout.Y_AXIS));

        // Add each request to the panel
        for (Requests request : Requests) {
            if (Objects.equals(request.getIdVolunteer(), idVolunteer)){
                JLabel RequestLabel = new JLabel("Date of the request: " + request.getDate() + ", Location: " + request.getLocation() + ", Description of the request :" + request.getDescription());
                RequestPanel.add(RequestLabel);
                }
            }

        // Show the requests
        TakenRequestFrame.setLayout(new BorderLayout());
        TakenRequestFrame.add(RequestPanel, BorderLayout.CENTER);

    }
}

