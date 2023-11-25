package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Frame for the volunteers to be able to either choose a request or the see the ones they have already chosen
public class ChooseOrSeeRequest {

    ChooseOrSeeRequest(String idVolunteer){

        NewFrame ChooseFrame = new NewFrame();

        // Panel to add logout and previous buttons
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseFrame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
        });
        logoutPanel.add(LogoutButton); // Add logout button to the panel

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseFrame.dispose();
                Connect connectPage = new Connect();
            }
        });
        logoutPanel.add(PreviousButton); // Add previous button to the panel

        JLabel MessageLabel = new JLabel("What do you want to do? ");

        // Button to see the available requests and choose one
        JButton ChooseButton = new JButton("Choose an available mission.");
        ChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ChooseFrame.dispose();
                    AvailableRequests chooseRequest = new AvailableRequests(idVolunteer);
                    }
        });

        // Button to see the requests that have already been taken by this volunteer
        JButton SeeButton = new JButton("See taken requests.");
        SeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseFrame.dispose();
                TakenRequests takenRequest = new TakenRequests(idVolunteer);
            }
        });

        // Add all the components to the frame
        ChooseFrame.setLayout(new BoxLayout(ChooseFrame.getContentPane(), BoxLayout.Y_AXIS));

        ChooseFrame.add(logoutPanel);
        ChooseFrame.add(Box.createVerticalStrut(10));

        ChooseFrame.add(MessageLabel);
        ChooseFrame.add(Box.createVerticalStrut(10));

        JPanel ButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonsPanel.add(ChooseButton);
        ButtonsPanel.add(SeeButton);
        ChooseFrame.add(ButtonsPanel);
    }
}

