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
        JLabel UsernameLabel = new JLabel("Enter username: ");
        JLabel PasswordLabel = new JLabel("Enter password: ");

        //fields to enter your info
        JTextField UsernameField = new JTextField(20);
        JPasswordField PasswordField = new JPasswordField(20);

        //add info in the frame
    }
    public static void main(String[] args) {
        Login log = new Login();
    }
}
