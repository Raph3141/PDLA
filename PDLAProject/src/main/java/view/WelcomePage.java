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


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBounds(70,100,200,100);
        //buttonPanel.setLayout(new GridLayout(3, 2));
       /* buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());*/
        buttonPanel.add(LoginButton);
        buttonPanel.add(ConnectButton);
       /* buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());*/

        // Add the panel to the frame
        WelcomeFrame.setLayout(new BorderLayout());
        WelcomeFrame.add(buttonPanel);
        //WelcomeFrame.pack();

    }

    /*public static void main(String[] args) {
        WelcomePage welcomePage = new WelcomePage();
    }*/
}
