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

        // Panel to put the logout and previous buttons
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Creation of the logout button
        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AvailableRequestsFrame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
        });
        logoutPanel.add(LogoutButton); // Add the button to the panel

        // Create the previous button
        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AvailableRequestsFrame.dispose();
                ChooseOrSeeRequest Choose = new ChooseOrSeeRequest(Volunteerid);
            }
        });
        logoutPanel.add(PreviousButton); // Add the button to the panel

        // Get requests from database
        List<Requests> Requests = new Requests().getRequests();

        // Panel to put all the requests
        JPanel RequestPanel = new JPanel();
        RequestPanel.setLayout(new BoxLayout(RequestPanel, BoxLayout.Y_AXIS));

        // Add requests to panel
        for (Requests request : Requests) {
            if (Objects.equals(request.getStatus(), "available")){
            JLabel RequestLabel = new JLabel("Date of the request: " + request.getDate() + ", Location: " + request.getLocation() + ", Description of the request :" + request.getDescription());
            RequestPanel.add(RequestLabel);

            // Button to choose a request
            JButton ChooseButton = new JButton("Select this request.");
            ChooseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String requestId = request.getRequestID();
                    new NewRequest().UpdateRequest(requestId, Volunteerid);

                    // Confirm that the request was taken
                    JOptionPane.showMessageDialog(null, "You are now assigned to this request.");
                }
            });
            RequestPanel.add(ChooseButton);  // Add the button to the panel
        }}

        // Add all the components to the frame
        AvailableRequestsFrame.setLayout(new BoxLayout(AvailableRequestsFrame.getContentPane(), BoxLayout.Y_AXIS));
        AvailableRequestsFrame.add(logoutPanel);
        AvailableRequestsFrame.add(Box.createVerticalStrut(10));
        AvailableRequestsFrame.add(RequestPanel);

    }
}

