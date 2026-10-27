import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{
    private static final int WIDTH =1400;
    private static final int HEIGHT=900;

public Main () {

super("Visual Art");

//setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
setSize(WIDTH, HEIGHT);

Game play = new Game();

((Component) play).setFocusable(true);

//Color RoyalBlue = new Color(22,13,193);

setBackground(Color.PINK);

getContentPane().add(play);

setVisible(true);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}

public static void main(String[] args) {

Main run = new Main();

 


}

}