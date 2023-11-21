package view;

import model.Requests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class CreateRequest {

    CreateRequest(String HelpSeekerid){

       NewFrame HelpSeekerFrame = new NewFrame();

        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton LogoutButton = new JButton("Log Out");
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout actions, e.g., close the current frame and open the login frame
                     WelcomePage welcome = new WelcomePage();
                    HelpSeekerFrame.dispose();
            }
        });

        logoutPanel.add(LogoutButton);

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HelpSeekerFrame.dispose();
                PreviousOrCreateRequest Request = new PreviousOrCreateRequest(HelpSeekerid);
            }
        });
        logoutPanel.add(PreviousButton);

        //components of the help seeker page
        JLabel DateLabel = new JLabel("Date (of the form YYYY-MM-DD): ");
        JLabel LocationLabel = new JLabel("Where do I need help: ");
        JLabel DescriptionLabel = new JLabel("Description of my request: ");
       

        //fields to enter the info about the request
        JTextField DateField = new JTextField(20);
        JTextField LocationField = new JTextField(20);
        JTextArea DescriptionField = new JTextArea(5, 50);
        JScrollPane ScrollPane = new JScrollPane(DescriptionField);

        //button to submit the info
        JButton SubmitButton = new JButton("Submit my request");
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = DateField.getText();
                String Location = LocationField.getText();
                String Description = DescriptionField.getText();

                String RequestId = UUID.randomUUID().toString().substring(1);

                //insert the request into the database
                Requests newRequest = new Requests(RequestId, HelpSeekerid, null, date, Location, "available", Description); // we set the idvolunteer and description with null until a volunteer accepts the request
                controllers.NewRequest newRequestHandler = new controllers.NewRequest();
                newRequestHandler.addNewRequest(newRequest);

                //confirmation message once it is done
                JOptionPane.showMessageDialog(null, "Your request has been registered.");
            }
        });

        //add info to the frame
        HelpSeekerFrame.setLayout(new BoxLayout(HelpSeekerFrame.getContentPane(), BoxLayout.Y_AXIS));
        HelpSeekerFrame.add(logoutPanel);
        HelpSeekerFrame.add(Box.createVerticalStrut(10));

        JPanel DatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        DatePanel.add(DateLabel);
        DatePanel.add(DateField);
        HelpSeekerFrame.add(DatePanel);
        HelpSeekerFrame.add(Box.createVerticalStrut(10));

        JPanel LocationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        LocationPanel.add(LocationLabel);
        LocationPanel.add(LocationField);
        HelpSeekerFrame.add(LocationPanel);
        HelpSeekerFrame.add(Box.createVerticalStrut(10));

        JPanel DescriptionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        DescriptionPanel.add(DescriptionLabel);
        DescriptionPanel.add(ScrollPane);
        HelpSeekerFrame.add(DescriptionPanel);

        HelpSeekerFrame.add(SubmitButton);
    }
    /*public static void main(String[] args) {
        HelpSeekerPage helpSeekerPage = new HelpSeekerPage("h"+ UUID.randomUUID().toString().substring(1));
    }*/
}