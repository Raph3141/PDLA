package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controllers.NewUser;

public class Connect {

    Connect() {

        NewFrame ConnectFrame = new NewFrame();

        JButton PreviousButton = new JButton("Previous");
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectFrame.dispose();
                WelcomePage welcome = new WelcomePage();
            }
        });

        //components of the connect page
        JLabel EmailLabel = new JLabel("Email: ");
        JLabel PasswordLabel = new JLabel("Enter password: ");

        //fields to enter your info
        JTextField EmailField = new JTextField(30);
        JPasswordField PasswordField = new JPasswordField(20);


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

                //case where the person is a help seeker
                if (Id!=null) {
                    if (Id.charAt(0) == 'H') {
                        HelpSeekerPage HelpSeekerPage = new HelpSeekerPage(Id);
                        ConnectFrame.dispose();
                    } else if (Id.charAt(0) == 'V') {
                        ChooseOrSeeRequest ChooseorSee = new ChooseOrSeeRequest(Id);
                        ConnectFrame.dispose();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong password or email.");
                }
            }
        });

        //add info to the frame
        ConnectFrame.setLayout(new BoxLayout(ConnectFrame.getContentPane(), BoxLayout.Y_AXIS));

        ConnectFrame.add(PreviousButton);
        
        JPanel emailPanel = new JPanel(new FlowLayout());
        emailPanel.add(EmailLabel);
        emailPanel.add(EmailField);
        ConnectFrame.add(emailPanel);
        ConnectFrame.add(Box.createVerticalStrut(10));

        JPanel passwordPanel = new JPanel(new FlowLayout());
        passwordPanel.add(PasswordLabel);
        passwordPanel.add(PasswordField);
        ConnectFrame.add(passwordPanel);
        ConnectFrame.add(Box.createVerticalStrut(10));

        ConnectFrame.add(ConnectButton);
        ConnectFrame.add(Box.createVerticalGlue());
    }

    /*public static void main(String[] args) {
        Connect connect = new Connect();
    }*/
}
