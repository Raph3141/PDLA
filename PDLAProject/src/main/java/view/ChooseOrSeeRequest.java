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

        JLabel MessageLabel = new JLabel("What do you want to do? ");

        JButton ChooseButton = new JButton("Choose an available mission.");
        ChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                       AvailableRequests chooseRequest = new AvailableRequests(idVolunteer);
                        ChooseFrame.dispose();
                    }
        });

        JButton SeeButton = new JButton("See taken requests.");
        ChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TakenRequests chooseRequest = new TakenRequests(idVolunteer);
                ChooseFrame.dispose();
            }
        });

        //add everything to the frame
        ChooseFrame.setLayout(new GridLayout(3, 1));
        ChooseFrame.add(MessageLabel);
        ChooseFrame.add(ChooseButton);
        ChooseFrame.add(SeeButton);

    }
}

