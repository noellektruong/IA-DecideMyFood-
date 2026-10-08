import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener {

    private BufferedImage back;
    private int key;

    private ImageIcon backImg;

    private Rectangle button1;
    private Rectangle button2;
    private Rectangle button3;

    private boolean startScreen;
    private boolean sweetScreen;
    private boolean savoryScreen;

    public Game() {

        setupImages();

        new Thread(this).start();

        button1 = new Rectangle(400, 550, 200, 70);
        button2 = new Rectangle(650, 550, 200, 70);
        button3 = new Rectangle(900, 550, 200, 70);

        this.addMouseListener(this);

        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();

        startScreen = true;
        sweetScreen = false;
        savoryScreen = false;

        key = -1;
    }

    public void setupImages() {
        backImg = new ImageIcon("stardewbackground.png");
    }

    public void run() {
        try {
            while(true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        }
        catch(Exception e) {
        }
    }

    public void paint(Graphics g) {

        Graphics2D twoDgraph = (Graphics2D) g;

        if(back == null) {
            back = (BufferedImage)(createImage(getWidth(), getHeight()));
        }

        Graphics g2d = back.createGraphics();

        g2d.clearRect(0, 0, getSize().width, getSize().height);

        g2d.drawImage(
            backImg.getImage(),
            0,
            0,
            getWidth(),
            getHeight(),
            null
        );

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Consolas", Font.BOLD, 40));

        if(startScreen == true) {

            g2d.drawString(
                "What are you craving?",
                330,
                150
            );

            g2d.setColor(Color.WHITE);

            g2d.fillRoundRect(
                button1.x,
                button1.y,
                button1.width,
                button1.height,
                20,
                20
            );

            g2d.setColor(Color.BLACK);

            g2d.drawRoundRect(
                button1.x,
                button1.y,
                button1.width,
                button1.height,
                20,
                20
            );

            g2d.setFont(new Font("Consolas", Font.BOLD, 25));

            g2d.drawString(
                "sweet",
                455,
                595
            );

            g2d.setColor(Color.WHITE);

            g2d.fillRoundRect(
                button2.x,
                button2.y,
                button2.width,
                button2.height,
                20,
                20
            );

            g2d.setColor(Color.BLACK);

            g2d.drawRoundRect(
                button2.x,
                button2.y,
                button2.width,
                button2.height,
                20,
                20
            );

            g2d.drawString(
                "savory",
                710,
                595
            );

            g2d.setColor(Color.WHITE);

            g2d.fillRoundRect(
                button3.x,
                button3.y,
                button3.width,
                button3.height,
                20,
                20
            );

            g2d.setColor(Color.BLACK);

            g2d.drawRoundRect(
                button3.x,
                button3.y,
                button3.width,
                button3.height,
                20,
                20
            );

            g2d.drawString(
                "salty",
                970,
                595
            );
        }

        if(sweetScreen == true) {

            g2d.setColor(Color.WHITE);

            g2d.setFont(new Font("Consolas", Font.BOLD, 40));

            g2d.drawString(
                "What kind of sweet food?",
                330,
                150
            );
        }

        if(savoryScreen == true) {

            g2d.setColor(Color.WHITE);

            g2d.setFont(new Font("Consolas", Font.BOLD, 40));

            g2d.drawString(
                "What kind of savory food?",
                330,
                150
            );
        }

        twoDgraph.drawImage(back, null, 0, 0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        key = e.getKeyCode();

        System.out.println(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if(startScreen == true && button1.contains(mouseX, mouseY)) {

            System.out.println("sweet button clicked!");

            startScreen = false;
            sweetScreen = true;

            repaint();
        }

        if(startScreen == true && button2.contains(mouseX, mouseY)) {

            System.out.println("savory button clicked!");

            startScreen = false;
            savoryScreen = true;

            repaint();
        }

        if(startScreen == true && button3.contains(mouseX, mouseY)) {

            System.out.println("salty button clicked!");

            startScreen = false;

            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}