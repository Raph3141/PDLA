package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.UUID;

import controllers.NewUser;
import model.Users;
import model.Volunteers;
import view.NewFrame;
public class Connect {

    Connect() {

        NewFrame ConnectFrame = new NewFrame();

        //components of the connect page
        JLabel EmailLabel = new JLabel("Email: ");
        JLabel PasswordLabel = new JLabel("Enter password: ");

        //fields to enter your info
        JTextField EmailField = new JTextField(30);
        JPasswordField PasswordField = new JPasswordField(20);

        //add info to the frame
        ConnectFrame.setLayout(new GridLayout(3, 2));
        ConnectFrame.add(EmailLabel);
        ConnectFrame.add(EmailField);
        ConnectFrame.add(PasswordLabel);
        ConnectFrame.add(PasswordField);

        //implement the connect button
        JButton ConnectButton = new JButton("Connect");
        ConnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Email = EmailField.getText();
                char[] PasswordChars = PasswordField.getPassword();
                String Password = new String(PasswordChars);

                //get the user id
                String Id = null;
                try {
                    Id = NewUser.getIdWithEmail(Email, Password);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(Id);

                //case where the person is a help seeker
                if (Id!=null) {
                    if (Id.charAt(0) == 'H') {
                        HelpSeekerPage HelpSeekerPage = new HelpSeekerPage(Id);
                        ConnectFrame.dispose();
                    } else if (Id.charAt(0) == 'V') {
                        VolunteerPage VolunteerPage = new VolunteerPage(Id);
                        ConnectFrame.dispose();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong password or email.");
                }
            }
        });

        //add the connect button
        ConnectFrame.add(ConnectButton);
    }

    public static void main(String[] args) {
        Connect connect = new Connect();
    }
}
