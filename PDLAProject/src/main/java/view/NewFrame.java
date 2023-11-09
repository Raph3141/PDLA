package view;
import javax.swing.*;


public class NewFrame extends JFrame{ //test
    NewFrame() {
        //create and set up the window
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to exit the window
        this.setSize(300,150);
        this.setTitle("Volunteering App");
    }

        public static class InsideFrame {
            NewFrame newFrame = new NewFrame();
        }

    public static void main(String[] args) {

        NewFrame newFr = new NewFrame();

        InsideFrame insideFrame = new InsideFrame();
    }

}

