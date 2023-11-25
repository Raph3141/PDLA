package view;
import javax.swing.*;
import java.awt.*;

// Class to create all the frames of the application
public class NewFrame extends JFrame{
    NewFrame() {
        // Create and set up the window
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // To exit the window
        // Size of the frame
        setSize(500, 400);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        this.setTitle("Volunteering App");
    }
}

