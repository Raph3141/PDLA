package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.NewFrame;

public class Login {

    Login() {
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

        //add info to the frame
        LoginFrame.setLayout(new GridLayout(5, 2));
        LoginFrame.add(FirstNameLabel);
        LoginFrame.add(FirstNameField);
        LoginFrame.add(LastNameLabel);
        LoginFrame.add(LastNameField);
        LoginFrame.add(EmailLabel);
        LoginFrame.add(EmailField);
        LoginFrame.add(PasswordLabel);
        LoginFrame.add(PasswordField);

        //add the login button
        JButton LoginButton = new JButton("Login");
       // LoginButton.addActionListener( );

        LoginFrame.add(LoginButton);


}

    public static void main(String[] args) {
        Login log = new Login();
    }
}
