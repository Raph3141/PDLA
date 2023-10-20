package view;
import javax.swing.*;


public class Newframe extends JFrame{ //test
    Newframe(){
        //create and set up the window

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to exit the window

        public static class InsideFrame {
            Newframe Newframe = new Newframe();

        }

    }
}
