package view;

import model.Requests;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class PreviousRequests {

    PreviousRequests(String idHelpSeeker){

        NewFrame PreviousRequestsFrame = new NewFrame();

        JLabel Message = new JLabel("My requests :");

        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout actions, e.g., close the current frame and open the login frame
                PreviousRequestsFrame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
        });
        logoutPanel.add(LogoutButton);

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreviousRequestsFrame.dispose();
                PreviousOrCreateRequest Request = new PreviousOrCreateRequest(idHelpSeeker);
            }
        });
        logoutPanel.add(PreviousButton);

        ArrayList<model.Requests> MyRequests = (ArrayList<Requests>) new Requests().getRequests();

        JPanel MyRequestsPanel = new JPanel( );
        MyRequestsPanel.setLayout(new BoxLayout(MyRequestsPanel, BoxLayout.Y_AXIS));

        for (Requests request : MyRequests) {
            if (Objects.equals(request.getIdHelpSeeker(), idHelpSeeker)) {
                MyRequestsPanel.add(new JLabel("Date : "+request.getDate()));
                MyRequestsPanel.add(new JLabel("Location : "+request.getLocation()));
                MyRequestsPanel.add(new JLabel("Status : "+request.getStatus()));
                MyRequestsPanel.add(new JLabel("Description : "+request.getDescription()));
                MyRequestsPanel.add(new JSeparator()); //to space the requests
            }
        }

        // Show the requests
        PreviousRequestsFrame.setLayout(new GridLayout(2,1));
        PreviousRequestsFrame.add(logoutPanel);
        PreviousRequestsFrame.add(MyRequestsPanel);
    }
}
