import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener {

    private BufferedImage back;
    private int key;

    private ImageIcon backImg;
    private ImageIcon cowImg;
    private ImageIcon eatathomeImg;
     private Rectangle button1;
     private Rectangle button2;
     private Rectangle button3;
   private boolean startScreen;
   private boolean dollarScreen;
   private boolean proteinScreen;
   private boolean chickenTypeScreen;
   private boolean friedScreen;
   private boolean wingsScreen;
   private boolean nuggetsScreen;
   private boolean tendersScreen;
   private boolean sandwichScreen;
   private boolean otherChickenScreen;
   private boolean beefScreen;
   private boolean burgerScreen;
   private boolean otherBeefScreen;
   private boolean burgerPreferenceScreen;
   private boolean healthierBurgerScreen;
   private boolean dontCareBurgerScreen;
   private boolean pizzaScreen;
   private boolean stuffedCrustScreen;
   private boolean costcoMembershipScreen;
   private boolean costcoPizzaScreen;

   private boolean vegetarianEndScreen;
   private boolean homeEndScreen;

private String selectedRestaurant;

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
        dollarScreen = false;
        proteinScreen = false;
        chickenTypeScreen = false;
        friedScreen = false;
        wingsScreen = false;
        nuggetsScreen = false;
        tendersScreen = false;
        sandwichScreen = false;
        otherChickenScreen = false;
        vegetarianEndScreen = false;
        homeEndScreen = false;
        beefScreen = false;
        burgerScreen = false;
        otherBeefScreen = false;
        burgerPreferenceScreen = false;
        healthierBurgerScreen = false;
        dontCareBurgerScreen = false;
        pizzaScreen = false;
        stuffedCrustScreen = false;
        costcoMembershipScreen = false;
        costcoPizzaScreen = false;
        selectedRestaurant = "";
        key = -1;
    }

    //wait joy of food or greed
    public void setupImages() {
    backImg = new ImageIcon("stardewbackground.png");
    cowImg = new ImageIcon("cow.jpg");
    eatathomeImg = new ImageIcon("eatathome.png");

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
            0, 0, getWidth(), getHeight(), null
        );

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Consolas", Font.BOLD, 35));

        if(startScreen == true) {
            g2d.drawString("Are you vegetarian?", 330, 150);
            drawButton(g2d, button1, "Yes");
            drawButton(g2d, button2, "No");
        }

        if(dollarScreen == true) {
            g2d.drawString(
                "Do you feel like you only got a dolla in your pocket?",
                100, 150
            );
            drawButton(g2d, button1, "Yes");
            drawButton(g2d, button2, "No");
        }

        if(proteinScreen == true) {
            g2d.drawString("Choose your protein (choose all that could apply)", 100, 150);
            drawButton(g2d, button1, "Chicken");
            drawButton(g2d, button2, "Beef");
            drawButton(g2d, button3, "Seafood");

            g2d.setColor(Color.WHITE);
            g2d.fillRoundRect(650, 650, 200, 70, 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(650, 650, 200, 70, 20, 20);
            g2d.drawString("Pizza", 710, 695);
        }

        if(chickenTypeScreen == true) {
            g2d.drawString("What kind of chicken?", 330, 150);

            drawButton(g2d, button1, "Fried");
            drawButton(g2d, button2, "Wings");
            drawButton(g2d, button3, "Nuggets");

            g2d.setColor(Color.WHITE);
            g2d.fillRoundRect(400, 650, 200, 70, 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(400, 650, 200, 70, 20, 20);
            g2d.drawString("Tenders", 440, 695);

            g2d.setColor(Color.WHITE);
            g2d.fillRoundRect(650, 650, 250, 70, 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(650, 650, 250, 70, 20, 20);
            g2d.drawString("Chicken sandwich", 660, 695);

            g2d.setColor(Color.WHITE);
            g2d.fillRoundRect(950, 650, 200, 70, 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(950, 650, 200, 70, 20, 20);
            g2d.drawString("Other", 1000, 695);
        }

if(beefScreen == true) {
    g2d.drawString("What kind of beef?", 400, 150);

    drawButton(g2d, button1, "Burger");
    drawButton(g2d, button2, "Other");
}


if(burgerScreen == true) {
    g2d.drawString("What kind of burger?", 400, 150);

    drawButton(g2d, button1, "Considered healthier");

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(650, 550, 250, 70, 20, 20);

    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(650, 550, 250, 70, 20, 20);
    g2d.drawString("I don't care (both)", 665, 593);
}


if(healthierBurgerScreen == true) {
    g2d.drawString("Choose a restaurant", 400, 150);

    drawButton(g2d, button1, "Five Guys");
    drawButton(g2d, button2, "Burger King");
}


if(dontCareBurgerScreen == true) {
    g2d.drawString("Choose a restaurant", 400, 150);

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(100, 550, 190, 70, 20, 20);
    g2d.fillRoundRect(330, 550, 190, 70, 20, 20);
    g2d.fillRoundRect(560, 550, 190, 70, 20, 20);
    g2d.fillRoundRect(790, 550, 190, 70, 20, 20);
    g2d.fillRoundRect(1020, 550, 190, 70, 20, 20);

    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(100, 550, 190, 70, 20, 20);
    g2d.drawRoundRect(330, 550, 190, 70, 20, 20);
    g2d.drawRoundRect(560, 550, 190, 70, 20, 20);
    g2d.drawRoundRect(790, 550, 190, 70, 20, 20);
    g2d.drawRoundRect(1020, 550, 190, 70, 20, 20);

    g2d.drawString("Five Guys", 120, 593);
    g2d.drawString("Burger King", 345, 593);
    g2d.drawString("McDonald's", 575, 593);
    g2d.drawString("Whataburger", 800, 593);
    g2d.drawString("Wendy's", 1040, 593);
}


if(otherBeefScreen == true) {
    g2d.drawString("Choose a restaurant", 400, 150);

    drawButton(g2d, button1, "Chipotle");
    drawButton(g2d, button2, "Panda Express");
    drawButton(g2d, button3, "Taco Bell");
}

        if(friedScreen == true) {
            g2d.drawString("Where do you want fried chicken?", 200, 150);
            drawButton(g2d, button1, "Popeyes");
            drawButton(g2d, button2, "KFC");
            drawButton(g2d, button3, "Bobo");
        }

        if(wingsScreen == true) {
            g2d.drawString("Where do you want wings?", 300, 150);
            drawButton(g2d, button1, "Wingstop");
            drawButton(g2d, button2, "Whataburger");
            drawButton(g2d, button3, "Popeyes");
        }

        if(vegetarianEndScreen == true) {
             g2d.drawImage( cowImg.getImage(),0,0,getWidth(),getHeight(),null);
            
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Consolas", Font.BOLD, 35));
            g2d.drawString("I dont account for vegetarians.", 200, 150);
            g2d.drawString("Eat grass.", 200, 210);

          

            drawButton(g2d, button1, "Restart");
        }
if(nuggetsScreen == true) {
    g2d.drawString("Where do you want nuggets?", 300, 150);

    drawButton(g2d, button1, "Chick-fil-A");
    drawButton(g2d, button2, "McDonald's");
    drawButton(g2d, button3, "Taco Bell");

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(400, 650, 200, 70, 20, 20);
    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(400, 650, 200, 70, 20, 20);
    g2d.drawString("Wendy's", 440, 695);

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(650, 650, 200, 70, 20, 20);
    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(650, 650, 200, 70, 20, 20);
    g2d.drawString("Popeyes", 690, 695);
}

if(tendersScreen == true) {
    g2d.drawString("Where do you want tenders?", 300, 150);

    drawButton(g2d, button1, "Chick-fil-A");
    drawButton(g2d, button2, "Wingstop");
    drawButton(g2d, button3, "Dave's Hot Chicken");

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(400, 650, 200, 70, 20, 20);
    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(400, 650, 200, 70, 20, 20);
    g2d.drawString("Cane's", 440, 695);

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(650, 650, 200, 70, 20, 20);
    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(650, 650, 200, 70, 20, 20);
    g2d.drawString("Popeyes", 690, 695);
}

if(sandwichScreen == true) {
    g2d.drawString("Where do you want a chicken sandwich?", 150, 150);

    drawButton(g2d, button1, "Whataburger");
    drawButton(g2d, button2, "Chick-fil-A");
    drawButton(g2d, button3, "Popeyes");

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(250, 650, 250, 70, 20, 20);
    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(250, 650, 250, 70, 20, 20);
    g2d.drawString("Wingstop", 280, 695);

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(525, 650, 250, 70, 20, 20);
    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(525, 650, 250, 70, 20, 20);
    g2d.drawString("Dave's Hot Chicken", 535, 695);

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(800, 650, 200, 70, 20, 20);
    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(800, 650, 200, 70, 20, 20);
    g2d.drawString("Burger King", 810, 695);

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(1025, 650, 200, 70, 20, 20);
    g2d.setColor(Color.BLACK);
    g2d.drawRoundRect(1025, 650, 200, 70, 20, 20);
    g2d.drawString("Cane's", 1060, 695);
}

if(otherChickenScreen == true) {
    g2d.drawString("Other chicken options", 300, 150);

    drawButton(g2d, button1, "Chipotle");
    drawButton(g2d, button2, "Panda Express");
    drawButton(g2d, button3, "Taco Bell");
}
        if(homeEndScreen == true) {
            g2d.drawImage(eatathomeImg.getImage(), 0, 0, getWidth(), getHeight(), null);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Consolas", Font.BOLD, 40));
            g2d.drawString("Eat at home.", 200, 250);
            drawButton(g2d, button1, "Restart");
        }
        if (pizzaScreen == true) {
    g2d.drawString("Stuffed crust or no stuffed crust?", 250, 150);
    drawButton(g2d, button1, "Stuffed crust");
    drawButton(g2d, button2, "No stuffed crust");
}

if (stuffedCrustScreen == true) {
    g2d.drawString("Choose a pizza place!", 400, 150);
    drawButton(g2d, button1, "Papa John's");
    drawButton(g2d, button2, "Domino's");
    drawButton(g2d, button3, "Pizza Hut");
}

if (costcoMembershipScreen == true) {
    g2d.drawString("Do you have a Costco membership?", 200, 150);
    drawButton(g2d, button1, "Yes");
    drawButton(g2d, button2, "No");
}

if (costcoPizzaScreen == true) {
    g2d.drawString("Your choice is Costco Pizza!", 300, 150);
    drawButton(g2d, button1, "Costco Pizza");
}

        if(!selectedRestaurant.equals("")) {
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Consolas", Font.BOLD, 35));
            g2d.drawString("You chose " + selectedRestaurant + "!", 350, 300);
            drawButton(g2d, button1, "Restart");
        }

        twoDgraph.drawImage(back, null, 0, 0);
    }

    public void drawButton(Graphics g, Rectangle button, String label) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(
            button.x, button.y, button.width, button.height, 20, 20
        );

        g.setColor(Color.BLACK);
        g.drawRoundRect(
            button.x, button.y, button.width, button.height, 20, 20
        );

        g.setFont(new Font("Consolas", Font.BOLD, 22));
        g.drawString(label, button.x + 15, button.y + 43);
    }

    public void handleOption(String option) {

        if(startScreen == true) {
            startScreen = false;

            if(option.equals("Yes")) {
                vegetarianEndScreen = true;
            }
            else {
                dollarScreen = true;
            }
        }
        else if(dollarScreen == true) {
            dollarScreen = false;

            if(option.equals("Yes")) {
                homeEndScreen = true;
            }
            else {
                proteinScreen = true;
            }
        }
       else if(proteinScreen == true) {
    if(option.equals("Chicken")) {
        proteinScreen = false;
        chickenTypeScreen = true;
    }
    else if(option.equals("Beef")) {
        proteinScreen = false;
        beefScreen = true;
    }
    else if(option.equals("Pizza")) {
    proteinScreen = false;
    pizzaScreen = true;
}
}

else if(chickenTypeScreen == true) {
    chickenTypeScreen = false;

    if(option.equals("Fried")) {
        friedScreen = true;
    }
    else if(option.equals("Wings")) {
        wingsScreen = true;
    }
    else if(option.equals("Nuggets")) {
        nuggetsScreen = true;
    }
    else if(option.equals("Tenders")) {
        tendersScreen = true;
    }
    else if(option.equals("Chicken sandwich")) {
        sandwichScreen = true;
    }
    else if(option.equals("Other")) {
        otherChickenScreen = true;
    }
}

else if(beefScreen == true) {
    beefScreen = false;

    if(option.equals("Burger")) {
        burgerScreen = true;
    }
    else if(option.equals("Other")) {
        otherBeefScreen = true;
    }
}

else if(burgerScreen == true) {
    burgerScreen = false;

    if(option.equals("Considered healthier")) {
        healthierBurgerScreen = true;
    }
    else if(option.equals("I don't care (both)")) {
        dontCareBurgerScreen = true;
    }
}

else if(healthierBurgerScreen == true ||
        dontCareBurgerScreen == true ||
        otherBeefScreen == true) {

    selectedRestaurant = option;

    healthierBurgerScreen = false;
    dontCareBurgerScreen = false;
    otherBeefScreen = false;
}
else if (pizzaScreen == true) {
    pizzaScreen = false;

    if (option.equals("Stuffed crust")) {
        stuffedCrustScreen = true;
    } else if (option.equals("No stuffed crust")) {
        costcoMembershipScreen = true;
    }
}

else if (costcoMembershipScreen == true) {
    costcoMembershipScreen = false;

    if (option.equals("Yes")) {
        costcoPizzaScreen = true;
    } else if (option.equals("No")) {
        stuffedCrustScreen = true;
    }
}

else if (stuffedCrustScreen == true) {
    selectedRestaurant = option;
    stuffedCrustScreen = false;
}

else if (costcoPizzaScreen == true) {
    selectedRestaurant = "Costco Pizza";
    costcoPizzaScreen = false;
}

else if(friedScreen == true ||
        wingsScreen == true ||
        nuggetsScreen == true ||
        tendersScreen == true ||
        sandwichScreen == true ||
        otherChickenScreen == true) {

    selectedRestaurant = option;

    friedScreen = false;
    wingsScreen = false;
    nuggetsScreen = false;
    tendersScreen = false;
    sandwichScreen = false;
    otherChickenScreen = false;
    
}

        repaint();
    }

    public void restartGame() {
        startScreen = true;
        dollarScreen = false;
        proteinScreen = false;
        chickenTypeScreen = false;
        friedScreen = false;
        wingsScreen = false;
        nuggetsScreen = false;
        tendersScreen = false;
        sandwichScreen = false;
        otherChickenScreen = false;
        vegetarianEndScreen = false;
        homeEndScreen = false;
        beefScreen = false;
        burgerScreen = false;
        otherBeefScreen = false;
        healthierBurgerScreen = false;
        dontCareBurgerScreen = false;
        pizzaScreen = false;
        stuffedCrustScreen = false;
        costcoMembershipScreen = false;
        costcoPizzaScreen = false;

        selectedRestaurant = "";

        repaint();
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

    if(vegetarianEndScreen == true ||
       homeEndScreen == true ||
       !selectedRestaurant.equals("")) {

        if(button1.contains(mouseX, mouseY)) {
            restartGame();
        }

        return;
    }

    if(startScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Yes");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("No");
        }
    }

    else if(dollarScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Yes");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("No");
        }
    }

    else if(proteinScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Chicken");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("Beef");
        }
        else if(button3.contains(mouseX, mouseY)) {
            handleOption("Seafood");
        }
        else if(new Rectangle(650, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Pizza");
        }
    }
    else if(beefScreen == true) {
    if(button1.contains(mouseX, mouseY)) {
        handleOption("Burger");
    }
    else if(button2.contains(mouseX, mouseY)) {
        handleOption("Other");
    }
}

else if(burgerScreen == true) {
    if(button1.contains(mouseX, mouseY)) {
        handleOption("Considered healthier");
    }
    else if(new Rectangle(650, 550, 250, 70)
            .contains(mouseX, mouseY)) {
        handleOption("I don't care (both)");
    }
}

else if(healthierBurgerScreen == true) {
    if(button1.contains(mouseX, mouseY)) {
        handleOption("Five Guys");
    }
    else if(button2.contains(mouseX, mouseY)) {
        handleOption("Burger King");
    }
}

else if(dontCareBurgerScreen == true) {
    if(new Rectangle(100, 550, 190, 70).contains(mouseX, mouseY)) {
        handleOption("Five Guys");
    }
    else if(new Rectangle(330, 550, 190, 70).contains(mouseX, mouseY)) {
        handleOption("Burger King");
    }
    else if(new Rectangle(560, 550, 190, 70).contains(mouseX, mouseY)) {
        handleOption("McDonald's");
    }
    else if(new Rectangle(790, 550, 190, 70).contains(mouseX, mouseY)) {
        handleOption("Whataburger");
    }
    else if(new Rectangle(1020, 550, 190, 70).contains(mouseX, mouseY)) {
        handleOption("Wendy's");
    }
}

else if(otherBeefScreen == true) {
    if(button1.contains(mouseX, mouseY)) {
        handleOption("Chipotle");
    }
    else if(button2.contains(mouseX, mouseY)) {
        handleOption("Panda Express");
    }
    else if(button3.contains(mouseX, mouseY)) {
        handleOption("Taco Bell");
    }
}

    else if(chickenTypeScreen == true) {

        if(button1.contains(mouseX, mouseY)) {
            handleOption("Fried");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("Wings");
        }
        else if(button3.contains(mouseX, mouseY)) {
            handleOption("Nuggets");
        }
        else if(new Rectangle(400, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Tenders");
        }
        else if(new Rectangle(650, 650, 250, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Chicken sandwich");
        }
        else if(new Rectangle(950, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Other");
        }
        
    }

    else if(friedScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Popeyes");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("KFC");
        }
        else if(button3.contains(mouseX, mouseY)) {
            handleOption("Bobo");
        }
    }

    else if(wingsScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Wingstop");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("Whataburger");
        }
        else if(button3.contains(mouseX, mouseY)) {
            handleOption("Popeyes");
        }
    }

    else if(nuggetsScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Chick-fil-A");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("McDonald's");
        }
        else if(button3.contains(mouseX, mouseY)) {
            handleOption("Taco Bell");
        }
        else if(new Rectangle(400, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Wendy's");
        }
        else if(new Rectangle(650, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Popeyes");
        }
    }

    else if(tendersScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Chick-fil-A");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("Wingstop");
        }
        else if(button3.contains(mouseX, mouseY)) {
            handleOption("Dave's Hot Chicken");
        }
        else if(new Rectangle(400, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Cane's");
        }
        else if(new Rectangle(650, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Popeyes");
        }
    }

    else if(sandwichScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Whataburger");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("Chick-fil-A");
        }
        else if(button3.contains(mouseX, mouseY)) {
            handleOption("Popeyes");
        }
        else if(new Rectangle(250, 650, 250, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Wingstop");
        }
        else if(new Rectangle(525, 650, 250, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Dave's Hot Chicken");
        }
        else if(new Rectangle(800, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Burger King");
        }
        else if(new Rectangle(1025, 650, 200, 70)
                .contains(mouseX, mouseY)) {
            handleOption("Cane's");
        }
    }

    else if(otherChickenScreen == true) {
        if(button1.contains(mouseX, mouseY)) {
            handleOption("Chipotle");
        }
        else if(button2.contains(mouseX, mouseY)) {
            handleOption("Panda Express");
        }
        else if(button3.contains(mouseX, mouseY)) {
            handleOption("Taco Bell");
        }
    }
    else if (pizzaScreen == true) {
    if (button1.contains(e.getPoint())) {
        handleOption("Stuffed crust");
    } else if (button2.contains(e.getPoint())) {
        handleOption("No stuffed crust");
    }
}

else if (stuffedCrustScreen == true) {
    if (button1.contains(e.getPoint())) {
        handleOption("Papa John's");
    } else if (button2.contains(e.getPoint())) {
        handleOption("Domino's");
    } else if (button3.contains(e.getPoint())) {
        handleOption("Pizza Hut");
    }
}

else if (costcoMembershipScreen == true) {
    if (button1.contains(e.getPoint())) {
        handleOption("Yes");
    } else if (button2.contains(e.getPoint())) {
        handleOption("No");
    }
}

else if (costcoPizzaScreen == true) {
    if (button1.contains(e.getPoint())) {
        handleOption("Costco Pizza");
    }
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