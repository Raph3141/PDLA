package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage {
    public WelcomePage() {

        NewFrame WelcomeFrame = new NewFrame();

        // Create buttons
        JButton LoginButton = new JButton("Login");
        JButton ConnectButton = new JButton("Connect");

        // Add action listeners to the buttons
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the Login frame when the Login button is clicked
                WelcomeFrame.dispose(); // Close the current frame
                Login login = new Login();
            }
        });

        ConnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the Connect frame when the Connect button is clicked
                WelcomeFrame.dispose(); // Close the current frame
                Connect connect = new Connect();
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(LoginButton);
        buttonPanel.add(ConnectButton);

        // Add the panel to the frame
        WelcomeFrame.add(buttonPanel);
    }

    public static void main(String[] args) {
        WelcomePage welcomePage = new WelcomePage();
    }
}
