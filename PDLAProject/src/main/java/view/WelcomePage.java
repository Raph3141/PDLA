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

        // Add the components to the frame
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBounds(70,100,200,100);

        buttonPanel.add(LoginButton);
        buttonPanel.add(ConnectButton);

        WelcomeFrame.setLayout(new BorderLayout());
        WelcomeFrame.setSize(350, 200);
        WelcomeFrame.add(buttonPanel);
    }
}
