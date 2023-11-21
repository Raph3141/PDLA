package view;

import controllers.NewUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ChooseOrSeeRequest {

    ChooseOrSeeRequest(String idVolunteer){

        NewFrame ChooseFrame = new NewFrame();

        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout actions, e.g., close the current frame and open the login frame
                ChooseFrame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
        });
        logoutPanel.add(LogoutButton);

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ChooseFrame.dispose();
                Connect connectPage = new Connect();
            }
        });
        logoutPanel.add(PreviousButton);

        JLabel MessageLabel = new JLabel("What do you want to do? ");

        JButton ChooseButton = new JButton("Choose an available mission.");
        ChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    ChooseFrame.dispose();
                    AvailableRequests chooseRequest = new AvailableRequests(idVolunteer);
                    }
        });

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

