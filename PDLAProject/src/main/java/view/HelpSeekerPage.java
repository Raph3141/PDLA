package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpSeekerPage {

    HelpSeekerPage(String HelpSeekerid){

        NewFrame HelpSeekerFrame = new NewFrame();

        //components of the help seeker page
        JLabel DateLabel = new JLabel("When do I need help (enter a date of the form YYYY-MM-DD): ");
        JLabel LocationLabel = new JLabel("Where do I need help: ");
        JLabel DescriptionLabel = new JLabel("Description of my request: ");
       

        //fields to enter the info about the request
        JTextField DateField = new JTextField(20);
        JTextField LocationField = new JTextField(20);
        JTextField DescriptionField = new JTextField(300);

        //add info to the frame
        HelpSeekerFrame.setLayout(new GridLayout(4, 2));
        HelpSeekerFrame.add(DateLabel);
        HelpSeekerFrame.add(DateField);
        HelpSeekerFrame.add(LocationLabel);
        HelpSeekerFrame.add(LocationField);
        HelpSeekerFrame.add(DescriptionLabel);
        HelpSeekerFrame.add(DescriptionField);

        //button to submit the info
        JButton SubmitButton = new JButton("Submit my request");
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = DateField.getText();
                String Location = LocationField.getText();
                String Description = DescriptionField.getText();

                //insert the request into the database
                model.Request newRequest = new model.Request(null, HelpSeekerid, null, date, Location, null, Description); // we set the idvolunteer and description with null until a volunteer accepts the request
                controllers.NewRequest newRequestHandler = new controllers.NewRequest();
                newRequestHandler.addNewRequest(newRequest);

                //confirmation message once it is done
                JOptionPane.showMessageDialog(null, "Your request has been registered.");
            }
        });

        HelpSeekerFrame.add(new JLabel()); //to have everything aligned
        HelpSeekerFrame.add(SubmitButton);
    }
}