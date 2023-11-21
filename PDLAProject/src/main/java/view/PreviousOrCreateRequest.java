package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousOrCreateRequest {

    PreviousOrCreateRequest(String idHelpSeeker){

        NewFrame RequestFrame = new NewFrame();

        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout actions, e.g., close the current frame and open the login frame
                RequestFrame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
        });
        logoutPanel.add(LogoutButton);

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RequestFrame.dispose();
                Connect connectPage = new Connect();
            }
        });
        logoutPanel.add(PreviousButton);

        JLabel MessageLabel = new JLabel("What do you want to do? ");

        JButton CreateButton = new JButton("Create a new request.");
        CreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RequestFrame.dispose();
                CreateRequest createRequest = new CreateRequest(idHelpSeeker);
            }
        });

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

        //add everything to the frame
        RequestFrame.setLayout(new BoxLayout(RequestFrame.getContentPane(), BoxLayout.Y_AXIS));
        RequestFrame.add(logoutPanel);
        RequestFrame.add(Box.createVerticalStrut(10));
        RequestFrame.add(MessageLabel);
        RequestFrame.add(Box.createVerticalStrut(10));
        RequestFrame.add(ButtonsPanel);


    }
}
