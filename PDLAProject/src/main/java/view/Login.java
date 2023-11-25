package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.HelpSeekers;
import model.Volunteers;

import java.util.UUID;

public class Login {

    public Login() {

        NewFrame LoginFrame = new NewFrame();

        // Create the previous button
        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame.dispose();
                WelcomePage welcome = new WelcomePage();
            }
        });

        // Components of the login page
        JLabel FirstNameLabel = new JLabel("First Name: ");
        JLabel LastNameLabel = new JLabel("Last Name: ");
        JLabel EmailLabel = new JLabel("Email: ");
        JLabel PasswordLabel = new JLabel("Enter password: ");

        // Fields to enter your info
        JTextField FirstNameField = new JTextField(20);
        JTextField LastNameField = new JTextField(20);
        JTextField EmailField = new JTextField(30);
        JPasswordField PasswordField = new JPasswordField(20);

        // Choose if I want to be a volunteer or a help seeker
        String[] users = {"Volunteer", "HelpSeeker"};
        JComboBox<String> usersComboBox = new JComboBox<>(users);

        // Implementation of login button
        JButton LoginButton = new JButton("Login");
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the typed information to put it in the database
                String FirstName = FirstNameField.getText();
                String LastName = LastNameField.getText();
                String Email = EmailField.getText();
                char[] PasswordChars = PasswordField.getPassword();
                String Password = new String(PasswordChars);
                String selectedUser = (String) usersComboBox.getSelectedItem();

                // Create an id for the volunteers
                assert selectedUser != null;
                if (selectedUser.equals("Volunteer")) {
                    String VolunteerPrefix = "V";
                    String Volunteerid = VolunteerPrefix + UUID.randomUUID().toString().substring(1);

                    // We add the volunteer to the table Users and the table Volunteers
                    model.Volunteers newVolunteer = new Volunteers(Volunteerid, FirstName, LastName, Email, Password);
                    controllers.NewVolunteer newVolunteerhandler = new controllers.NewVolunteer();
                    newVolunteerhandler.addNewVolunteer(newVolunteer);

                    model.Users newUser = new model.Users(Volunteerid, FirstName, LastName, Email, Password);
                    controllers.NewUser newUserHandler = new controllers.NewUser();
                    newUserHandler.addNewUser(newUser);

                    // Open frame to choose or see the requests after login
                    LoginFrame.dispose();
                    ChooseOrSeeRequest Choosepage = new ChooseOrSeeRequest(Volunteerid);
                }
                // Create an id for the HelpSeekers
                else if (selectedUser.equals("HelpSeeker")) {
                    String HelpSeekerPrefix = "H";
                    String HelpSeekerid = HelpSeekerPrefix + UUID.randomUUID().toString().substring(1);

                    // We add the HelpSeeker to the table user and the table volunteers
                    model.HelpSeekers newHelpSeeker = new HelpSeekers(HelpSeekerid, FirstName, LastName, Email, Password);
                    controllers.NewHelpSeeker newHelpSeekerhandler = new controllers.NewHelpSeeker();
                    newHelpSeekerhandler.addNewHelpSeeker(newHelpSeeker);

                    model.Users newUser = new model.Users(HelpSeekerid, FirstName, LastName, Email, Password);
                    controllers.NewUser newUserHandler = new controllers.NewUser();
                    newUserHandler.addNewUser(newUser);

                    // Open frame to create or see the previous requests after login
                    LoginFrame.dispose();
                    PreviousOrCreateRequest Request = new PreviousOrCreateRequest(HelpSeekerid);
                }

                // Confirmation message once it is done
                JOptionPane.showMessageDialog(null, "You have been successfully logged in as: " + FirstName +" " + LastName);
            }
        });

        // Add info to the frame
        LoginFrame.setLayout(new BoxLayout(LoginFrame.getContentPane(), BoxLayout.Y_AXIS));
        LoginFrame.add(PreviousButton);
        LoginFrame.add(Box.createVerticalStrut(10));

        LoginFrame.add(usersComboBox);

        JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        firstNamePanel.add(FirstNameLabel);
        firstNamePanel.add(FirstNameField);
        LoginFrame.add(firstNamePanel);
        LoginFrame.add(Box.createVerticalStrut(10));

        JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lastNamePanel.add(LastNameLabel);
        lastNamePanel.add(LastNameField);
        LoginFrame.add(lastNamePanel);
        LoginFrame.add(Box.createVerticalStrut(10));

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        emailPanel.add(EmailLabel);
        emailPanel.add(EmailField);
        LoginFrame.add(emailPanel);
        LoginFrame.add(Box.createVerticalStrut(10));

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.add(PasswordLabel);
        passwordPanel.add(PasswordField);

        LoginFrame.add(passwordPanel);
        LoginFrame.add(Box.createVerticalStrut(10));

        LoginFrame.add(LoginButton);
        LoginFrame.add(Box.createVerticalGlue());
    }
}
