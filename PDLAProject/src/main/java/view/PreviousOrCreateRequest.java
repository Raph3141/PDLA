package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frame to see the previous requests that were made or to make a request
public class PreviousOrCreateRequest {

    PreviousOrCreateRequest(String idHelpSeeker){

        NewFrame RequestFrame = new NewFrame();

        // Panel to add logout and previous buttons
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
        });
        logoutPanel.add(LogoutButton); // Add logout button

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame.dispose();
                Connect connectPage = new Connect();
            }
        });
        logoutPanel.add(PreviousButton); // Add previous button

        JLabel MessageLabel = new JLabel("What do you want to do? ");

        // Button to create a request
        JButton CreateButton = new JButton("Create a new request.");
        CreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RequestFrame.dispose();
                CreateRequest createRequest = new CreateRequest(idHelpSeeker);
            }
        });

        // Button to see the requests previously made
        JButton SeeButton = new JButton("See previous requests.");
        SeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame.dispose();
                PreviousRequests previousRequests = new PreviousRequests(idHelpSeeker);
            }
        });
        JPanel ButtonsPanel = new JPanel(new FlowLayout());
        ButtonsPanel.add(CreateButton);
        ButtonsPanel.add(SeeButton);

        // Add everything to the frame
        RequestFrame.setLayout(new BoxLayout(RequestFrame.getContentPane(), BoxLayout.Y_AXIS));
        RequestFrame.add(logoutPanel);
        RequestFrame.add(Box.createVerticalStrut(10));
        RequestFrame.add(MessageLabel);
        RequestFrame.add(Box.createVerticalStrut(10));
        RequestFrame.add(ButtonsPanel);
    }
}
