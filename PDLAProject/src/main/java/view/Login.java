package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.NewFrame;

public class Login extends Component {

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

                //call of methods to add user to the database
                //confirmation message once it is done
                JOptionPane.showMessageDialog(Login.this, "You have been successfully logged in as: " + FirstName + LastName);
                // Create an instance of NewFrame after successful login
                //NewFrame newFrame = new NewFrame();
            }
        });

        LoginFrame.add(LoginButton);
    }

    public static void main(String[] args) {
        Login log = new Login();
    }
}
