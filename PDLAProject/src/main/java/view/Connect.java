package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        //add the connect button
        JButton ConnectButton = new JButton("Connect");
        // LoginButton.addActionListener( );
        ConnectFrame.add(ConnectButton);

    }
    public static void main(String[] args) {
            Connect connect = new Connect();
    }

}
