package view;
import javax.swing.*;
import java.awt.*;


public class NewFrame extends JFrame{ //test
    NewFrame() {
        //create and set up the window
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to exit the window
        //make the frame of the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(screenWidth, screenHeight);
        

        // Center the frame on the screen
        setLocationRelativeTo(null);

        this.setTitle("Volunteering App");
    }

    /*public static void main(String[] args) {

        NewFrame newFr = new NewFrame();

    }*/

}

