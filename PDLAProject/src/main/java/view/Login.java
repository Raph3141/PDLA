package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.DatabaseConnection;
import model.HelpSeekers;
import model.Volunteers;
import view.NewFrame;

import java.sql.Connection;
import java.util.UUID;

public class Login {

    public Login() {
        NewFrame LoginFrame = new NewFrame();

        //components of the login page
        JLabel FirstNameLabel = new JLabel("First Name: ");
        JLabel LastNameLabel = new JLabel("Last Name: ");
        JLabel EmailLabel = new JLabel("Email: ");
        JLabel PasswordLabel = new JLabel("Enter password: ");

        //fields to enter your info
        JTextField FirstNameField = new JTextField(20);
        JTextField LastNameField = new JTextField(20);
        JTextField EmailField = new JTextField(30);
        JPasswordField PasswordField = new JPasswordField(20);

        //choose if I want to be a volunteer or a help seeker
        String[] users = {"Volunteer", "HelpSeeker"};
        JComboBox<String> usersComboBox = new JComboBox<>(users);

        //add info to the frame
        LoginFrame.setLayout(new GridLayout(6, 2));
        LoginFrame.add(usersComboBox);
        LoginFrame.add(new JLabel()); //to have everything aligned
        LoginFrame.add(FirstNameLabel);
        LoginFrame.add(FirstNameField);
        LoginFrame.add(LastNameLabel);
        LoginFrame.add(LastNameField);
        LoginFrame.add(EmailLabel);
        LoginFrame.add(EmailField);
        LoginFrame.add(PasswordLabel);
        LoginFrame.add(PasswordField);


        //Implementation of login button
        JButton LoginButton = new JButton("Login");
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String FirstName = FirstNameField.getText();
                String LastName = LastNameField.getText();
                String Email = EmailField.getText();
                char[] PasswordChars = PasswordField.getPassword();
                String Password = new String(PasswordChars);
                String selectedUser = (String) usersComboBox.getSelectedItem();

                //create an id for the volunteers
                assert selectedUser != null;
                if (selectedUser.equals("Volunteer")) {
                    String VolunteerPrefix = "V";
                    String Volunteerid = VolunteerPrefix + UUID.randomUUID().toString().substring(1, 19);

                    //we add the volunteer to the table user and the table volunteers
                    model.Volunteers newVolunteer = new Volunteers(Volunteerid, FirstName, LastName, Email, Password);
                    controllers.NewVolunteer newVolunteerhandler = new controllers.NewVolunteer();
                    newVolunteerhandler.addNewVolunteer(newVolunteer);

                    model.Users newUser = new model.Users(Volunteerid, FirstName, LastName, Email, Password);
                    controllers.NewUser newUserHandler = new controllers.NewUser();
                    newUserHandler.addNewUser(newUser);

                    // open volunteer frame after login
                    VolunteerPage VolunteerPage = new VolunteerPage(Volunteerid);

                } else if (selectedUser.equals("HelpSeeker")) {
                    String HelpSeekerPrefix = "H";
                    String HelpSeekerid = HelpSeekerPrefix + UUID.randomUUID().toString().substring(1,19);

                    //we add the HelpSeeker to the table user and the table volunteers
                    model.HelpSeekers newHelpSeeker = new HelpSeekers(HelpSeekerid, FirstName, LastName, Email, Password);
                    controllers.NewHelpSeeker newHelpSeekerhandler = new controllers.NewHelpSeeker();
                    newHelpSeekerhandler.addNewHelpSeeker(newHelpSeeker);

                    model.Users newUser = new model.Users(HelpSeekerid, FirstName, LastName, Email, Password);
                    controllers.NewUser newUserHandler = new controllers.NewUser();
                    newUserHandler.addNewUser(newUser);

                    // open help seeker frame after login
                    HelpSeekerPage HelpSeekerPage = new HelpSeekerPage(HelpSeekerid);
                }


                //confirmation message once it is done
                JOptionPane.showMessageDialog(null, "You have been successfully logged in as: " + FirstName +" " + LastName);
            }
        });

        LoginFrame.add(LoginButton);
    }

    /*public static void main(String[] args) {
        Login log = new Login();
    }*/
}
