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

        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AvailableRequestsFrame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
        });
        logoutPanel.add(LogoutButton);

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AvailableRequestsFrame.dispose();
                ChooseOrSeeRequest Choose = new ChooseOrSeeRequest(Volunteerid);
            }
        });
        logoutPanel.add(PreviousButton);

        // get requests from database
        List<Requests> Requests = new Requests().getRequests();

        JPanel RequestPanel = new JPanel();
        RequestPanel.setLayout(new BoxLayout(RequestPanel, BoxLayout.Y_AXIS));

        // Add requests to panel
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
        AvailableRequestsFrame.setLayout(new BoxLayout(AvailableRequestsFrame.getContentPane(), BoxLayout.Y_AXIS));
        AvailableRequestsFrame.add(logoutPanel);
        AvailableRequestsFrame.add(Box.createVerticalStrut(10));
        AvailableRequestsFrame.add(RequestPanel);

    }
    /*public static void main(String[] args) {
       VolunteerPage volunteerPage = new VolunteerPage("V"+UUID.randomUUID().toString().substring(1));
    }*/

}

