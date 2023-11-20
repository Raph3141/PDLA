package view;

import controllers.NewRequest;
import model.Requests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class AvailableRequests {

    AvailableRequests(String Volunteerid) {

        NewFrame AvailableRequestsFrame = new NewFrame();

        // Retrieve requests from the database
        List<Requests> Requests = new Requests().getRequests();

        // Create a panel to hold the list of requests
        JPanel RequestPanel = new JPanel();
        RequestPanel.setLayout(new BoxLayout(RequestPanel, BoxLayout.Y_AXIS));

        // Add each request to the panel
        for (Requests request : Requests) {
            if (Objects.equals(request.getStatus(), "available")){
            JLabel RequestLabel = new JLabel("Date of the request: " + request.getDate() + ", Location: " + request.getLocation() + ", Description of the request :" + request.getDescription());
            RequestPanel.add(RequestLabel);

            //choose a request
            JButton ChooseButton = new JButton("Select this request.");
            ChooseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add volunteer's ID to the selected request

                    String requestId = request.getRequestID();
                    new NewRequest().UpdateRequest(requestId, Volunteerid);
                    // Provide feedback to the user
                    JOptionPane.showMessageDialog(null, "You are now assigned to this request.");
                }
            });

            // Add the button to the panel
            RequestPanel.add(ChooseButton);
        }}

        // Show the requests
        AvailableRequestsFrame.setLayout(new BorderLayout());
        AvailableRequestsFrame.add(RequestPanel, BorderLayout.CENTER);

    }
    /*public static void main(String[] args) {
       VolunteerPage volunteerPage = new VolunteerPage("V"+UUID.randomUUID().toString().substring(1));
    }*/

}

