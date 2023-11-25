package view;

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

        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TakenRequestFrame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
        });
        logoutPanel.add(LogoutButton);

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TakenRequestFrame.dispose();
                ChooseOrSeeRequest Choose = new ChooseOrSeeRequest(idVolunteer);
            }
        });
        logoutPanel.add(PreviousButton);

        // List of all the request
        List<Requests> Requests = new Requests().getRequests();

        // Create a panel to hold the list of requests
        JPanel RequestPanel = new JPanel();
        RequestPanel.setLayout(new BoxLayout(RequestPanel, BoxLayout.Y_AXIS));

        // Get the requests that have the matching idVolunteer and add them to the panel
        for (Requests request : Requests) {
            if (Objects.equals(request.getIdVolunteer(), idVolunteer)){
                JLabel RequestLabel = new JLabel("Date of the request: " + request.getDate() + ", Location: " + request.getLocation() + ", Description of the request :" + request.getDescription());
                RequestPanel.add(RequestLabel);
                }
            }

        // Show the requests
        TakenRequestFrame.setLayout(new GridLayout(2,1));
        TakenRequestFrame.add(logoutPanel);
        TakenRequestFrame.add(RequestPanel);
    }
}

