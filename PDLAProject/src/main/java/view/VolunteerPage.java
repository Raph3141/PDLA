package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VolunteerPage {

    VolunteerPage(String Volunteerid) {

        NewFrame VolunteerFrame = new NewFrame();

        // Retrieve requests from the database
        List<model.Request> requests = GetRequests();

        // Create a panel to hold the list of requests
        JPanel RequestPanel = new JPanel();
        RequestPanel.setLayout(new BoxLayout(RequestPanel, BoxLayout.Y_AXIS));

        // Add each request to the panel
        for (model.Request request : requests) {
            JLabel RequestLabel = new JLabel("Date of the request: " + request.getDate() + ", Location: " + request.getLocation() + "Description of the request :" + request.getDescription());
            RequestPanel.add(RequestLabel);

            //choose a request
            JButton ChooseButton = new JButton("Select this request.");
            ChooseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add volunteer's ID to the selected request


                    // Provide feedback to the user
                    JOptionPane.showMessageDialog(null, "You are now assigned to this request.");
                }
            });

            // Add the button to the panel
            RequestPanel.add(ChooseButton);
        }

        // Show the requests
        VolunteerFrame.setLayout(new BorderLayout());
        VolunteerFrame.add(RequestPanel, BorderLayout.CENTER);

    }
}

