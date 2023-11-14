package view;

import javax.swing.*;

public class HelpSeekerPage {

    HelpSeekerPage(String HelpSeekerid){

        //components of the help seeker page
        JLabel DateLabel = new JLabel("Date: ");
       

        //fields to enter your info
        JTextField FirstNameField = new JTextField(20);
        JTextField LastNameField = new JTextField(20);
        JTextField EmailField = new JTextField(30);
        JPasswordField PasswordField = new JPasswordField(20);

    }
}
