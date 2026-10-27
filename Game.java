
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

public class Game extends JPanel implements MouseListener, KeyListener {

    private ImageIcon backImg;
    private ImageIcon foodButtonImg;

    private boolean startScreen = true;
    private boolean resultsScreen = false;

    private ArrayList<Food> foods = new ArrayList<Food>();
    private ArrayList<Food> recommendations = new ArrayList<Food>();
    private ArrayList<UIButton> buttons = new ArrayList<UIButton>();
    private Set<String> selectedCharacteristics = new HashSet<String>();

    private int resultIndex = 0;

    private String[] characteristics = {
        "Savory", "Sweet", "Sour", "Spicy", "Salty",
        "Crispy", "Crunchy", "Soft", "Fluffy", "Chewy",
        "Juicy", "Cheesy", "Creamy", "Chocolatey",
        "Fresh", "Saucy", "Cold"
    };

    private class Food {
        String name;
        String ingredients;
        Set<String> characteristics;

        Food(String name, String ingredients, String... characteristics) {
            this.name = name;
            this.ingredients = ingredients;
            this.characteristics = new HashSet<String>(
                Arrays.asList(characteristics)
            );
        }
    }

    private class UIButton {
        Rectangle rectangle;
        String label;
        String action;

        UIButton(int x, int y, int width, int height,
                 String label, String action) {
            rectangle = new Rectangle(x, y, width, height);
            this.label = label;
            this.action = action;
        }
    }
//hello my name is joy
    public Game() {
        setPreferredSize(new Dimension(1400, 900));

        setupImages();
        setupFoods();

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
    }

    private void setupImages() {
        backImg = new ImageIcon("dog.jpg");
        foodButtonImg = new ImageIcon("button.jpg");
    }

    private void setupFoods() {
        foods.clear();

        foods.add(new Food("Burger",
            "Beef patty, bun, lettuce, tomato, cheese",
            "Savory", "Cheesy", "Juicy"));

        foods.add(new Food("Nuggets",
            "Chicken, breading, seasoning",
            "Savory", "Crispy"));

        foods.add(new Food("Wings",
            "Chicken wings, seasoning, sauce",
            "Savory", "Crispy", "Spicy", "Saucy"));

        foods.add(new Food("Fried chicken",
            "Chicken, flour, breading, seasoning",
            "Savory", "Crispy", "Juicy"));

        foods.add(new Food("Spaghetti",
            "Pasta, tomato sauce, seasoning, optional cheese",
            "Savory", "Saucy", "Cheesy"));

        foods.add(new Food("Quesadilla",
            "Tortilla, cheese, optional chicken",
            "Savory", "Cheesy", "Crispy"));

        foods.add(new Food("Fries",
            "Potatoes, oil, salt",
            "Savory", "Crispy", "Crunchy", "Salty"));

        foods.add(new Food("Steak",
            "Beef, salt, pepper, seasoning",
            "Savory", "Juicy"));

        foods.add(new Food("Pizza",
            "Pizza dough, tomato sauce, cheese, toppings",
            "Savory", "Cheesy", "Saucy"));

        foods.add(new Food("Salad",
            "Lettuce, vegetables, optional dressing",
            "Fresh", "Crunchy"));

        foods.add(new Food("Chinese food",
            "Rice or noodles, vegetables, meat, sauce",
            "Savory", "Sweet", "Spicy", "Saucy"));

        foods.add(new Food("Nachos",
            "Tortilla chips, cheese, salsa, optional meat",
            "Savory", "Cheesy", "Crunchy", "Spicy"));

        foods.add(new Food("Hot dog",
            "Hot dog sausage, bun, optional toppings",
            "Savory", "Juicy"));

        foods.add(new Food("Waffles",
            "Flour, eggs, milk, butter, optional syrup",
            "Sweet", "Crispy", "Fluffy"));

        foods.add(new Food("Pancakes",
            "Flour, eggs, milk, butter, optional syrup",
            "Sweet", "Soft", "Fluffy"));

        foods.add(new Food("Cereal",
            "Cereal grains, optional milk, optional sugar",
            "Sweet", "Crunchy"));

        foods.add(new Food("Ice cream",
            "Milk, cream, sugar, flavoring",
            "Sweet", "Cold", "Creamy"));

        foods.add(new Food("Brownies",
            "Chocolate, flour, sugar, butter, eggs",
            "Sweet", "Chocolatey", "Soft", "Chewy"));

        foods.add(new Food("Cookies",
            "Flour, sugar, butter, eggs, optional chocolate chips",
            "Sweet", "Crispy", "Chewy", "Chocolatey"));

        foods.add(new Food("Cupcakes",
            "Flour, sugar, eggs, butter, frosting",
            "Sweet", "Soft", "Creamy"));

        foods.add(new Food("Cake",
            "Flour, sugar, eggs, butter, frosting",
            "Sweet", "Soft", "Fluffy", "Creamy"));

        foods.add(new Food("Dumplings",
            "Dough, meat or vegetables, seasoning",
            "Savory", "Juicy", "Soft"));

        foods.add(new Food("Baos",
            "Steamed dough, meat or vegetables, sauce",
            "Savory", "Soft", "Fluffy"));

        foods.add(new Food("Kebab",
            "Grilled meat, seasoning, optional vegetables",
            "Savory", "Juicy", "Spicy"));

        foods.add(new Food("Fried fish",
            "Fish, breading, flour, seasoning",
            "Savory", "Crispy", "Juicy"));

        foods.add(new Food("Mashed potatoes",
            "Potatoes, butter, milk, salt",
            "Savory", "Soft", "Creamy"));

        foods.add(new Food("Macaroni and cheese",
            "Macaroni, cheese, milk, butter",
            "Savory", "Cheesy", "Creamy"));

        foods.add(new Food("Chicken tenders",
            "Chicken, breading, flour, seasoning",
            "Savory", "Crispy", "Juicy"));

        foods.add(new Food("Chicken sandwich",
            "Chicken, bread or bun, lettuce, cheese, sauce",
            "Savory", "Juicy", "Cheesy", "Crispy"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        drawBackground(g2);

        buttons.clear();

        if (startScreen) {
            drawStartScreen(g2);
        } else if (resultsScreen) {
            drawResultsScreen(g2);
        } else {
            drawSelectionScreen(g2);
        }

        g2.dispose();
    }

    private void drawBackground(Graphics2D g) {
        if (backImg != null && backImg.getIconWidth() > 0) {
            g.drawImage(
                backImg.getImage(),
                0, 0, getWidth(), getHeight(), this
            );
        } else {
            g.setColor(new Color(255, 225, 235));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    private void drawStartScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", Font.BOLD, 48));
        drawCentered(g, "What Should I Eat?", 250);

       


        addButton(g, 500, 430, 400, 80, "Start", "START");
        addButton(g, 500, 535, 400, 65, "Exit", "EXIT");
    }

    private void drawSelectionScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", Font.BOLD, 38));
        drawCentered(g, "Choose Your Characteristics", 85);

        g.setFont(new Font("Consolas", Font.PLAIN, 19));
        drawCentered(g, "Select as many as you want, then click Find Food.", 130);

        int startX = 160;
        int startY = 190;
        int buttonWidth = 250;
        int buttonHeight = 65;
        int gapX = 25;
        int gapY = 22;
        int columns = 4;

        for (int i = 0; i < characteristics.length; i++) {
            int row = i / columns;
            int column = i % columns;

            int x = startX + column * (buttonWidth + gapX);
            int y = startY + row * (buttonHeight + gapY);

            String characteristic = characteristics[i];
            boolean selected =
                selectedCharacteristics.contains(characteristic);

            if (selected) {
                g.setColor(new Color(225, 120, 160));
                g.fillRoundRect(x, y, buttonWidth, buttonHeight, 18, 18);
            }

            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(selected ? 3 : 1));
            g.drawRoundRect(x, y, buttonWidth, buttonHeight, 18, 18);

            g.setFont(new Font("Consolas", Font.BOLD, 19));
            g.setColor(Color.BLACK);

            drawCenteredInButton(
                g, characteristic, x, y, buttonWidth, buttonHeight
            );

            buttons.add(new UIButton(
                x, y, buttonWidth, buttonHeight,
                characteristic, "CHAR:" + characteristic
            ));
        }

        addButton(g, 250, 700, 250, 65, "Clear Choices", "CLEAR");
        addButton(g, 575, 700, 250, 65, "Find Food", "FIND");
        addButton(g, 900, 700, 250, 65, "Exit", "EXIT");
    }

    private void drawResultsScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", Font.BOLD, 38));
        drawCentered(g, "Your Food Recommendations", 65);

        if (recommendations.isEmpty()) {
            g.setFont(new Font("Consolas", Font.PLAIN, 24));
            drawCentered(
                g, "No matching foods found. Try different choices!", 300
            );
        } else {
            int cardX = 100;
            int cardWidth = 1200;
            int cardHeight = 175;

            int endIndex = Math.min(
                resultIndex + 3, recommendations.size()
            );

            for (int i = resultIndex; i < endIndex; i++) {
                Food food = recommendations.get(i);
                int y = 115 + (i - resultIndex) * 190;

                g.setColor(new Color(255, 245, 248, 225));
                g.fillRoundRect(cardX, y, cardWidth, cardHeight, 20, 20);

                g.setColor(Color.BLACK);
                g.setStroke(new BasicStroke(2));
                g.drawRoundRect(cardX, y, cardWidth, cardHeight, 20, 20);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Consolas", Font.BOLD, 27));
                g.drawString(
                    (i + 1) + ". " + food.name,
                    cardX + 25, y + 38
                );

                g.setFont(new Font("Consolas", Font.PLAIN, 16));
                g.drawString(
                    "Ingredients: " + food.ingredients,
                    cardX + 25, y + 75
                );

                ArrayList<String> sortedCharacteristics =
                    new ArrayList<String>(food.characteristics);
                Collections.sort(sortedCharacteristics);

                g.drawString(
                    "Characteristics: " +
                    String.join(", ", sortedCharacteristics),
                    cardX + 25, y + 108
                );

                if (!selectedCharacteristics.isEmpty()) {
                    g.setFont(new Font("Consolas", Font.BOLD, 15));
                    g.drawString(
                        "Matching choices: " + getMatchingCount(food) +
                        " of " + selectedCharacteristics.size(),
                        cardX + 25, y + 140
                    );
                }
            }

            g.setFont(new Font("Consolas", Font.PLAIN, 18));
            drawCentered(
                g,
                "Showing " + (resultIndex + 1) + "-" + endIndex +
                " of " + recommendations.size() + " foods",
                700
            );
        }

        if (resultIndex + 3 < recommendations.size()) {
            addButton(g, 270, 745, 250, 65, "More Results", "MORE");
        }

        addButton(g, 560, 745, 250, 65, "Change Choices", "CHANGE");
        addButton(g, 850, 745, 250, 65, "Restart", "RESTART");
        addButton(g, 1140, 745, 150, 65, "Exit", "EXIT");
    }

    private void addButton(Graphics2D g, int x, int y, int width,
                           int height, String label, String action) {
        if (foodButtonImg != null && foodButtonImg.getIconWidth() > 0) {
            g.drawImage(
                foodButtonImg.getImage(),
                x, y, width, height, this
            );
        } else {
            g.setColor(new Color(225, 120, 160));
            g.fillRoundRect(x, y, width, height, 18, 18);
        }

        g.setFont(new Font("Consolas", Font.BOLD, 21));
        g.setColor(Color.BLACK);

        drawCenteredInButton(g, label, x, y, width, height);

        buttons.add(new UIButton(x, y, width, height, label, action));
    }

    private void drawCentered(Graphics2D g, String text, int y) {
        FontMetrics metrics = g.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        g.drawString(text, x, y);
    }

    private void drawCenteredInButton(Graphics2D g, String text,
                                      int x, int y, int width, int height) {
        FontMetrics metrics = g.getFontMetrics();

        int textX = x + (width - metrics.stringWidth(text)) / 2;
        int textY = y + (height - metrics.getHeight()) / 2
            + metrics.getAscent();

        g.drawString(text, textX, textY);
    }

    private int getMatchingCount(Food food) {
        int count = 0;

        for (String characteristic : selectedCharacteristics) {
            if (food.characteristics.contains(characteristic)) {
                count++;
            }
        }

        return count;
    }

    private void findRecommendations() {
        recommendations.clear();
        resultIndex = 0;

        for (Food food : foods) {
            if (selectedCharacteristics.isEmpty()
                    || getMatchingCount(food) > 0) {
                recommendations.add(food);
            }
        }

        Collections.sort(recommendations, new Comparator<Food>() {
            @Override
            public int compare(Food first, Food second) {
                return Integer.compare(
                    getMatchingCount(second),
                    getMatchingCount(first)
                );
            }
        });

        resultsScreen = true;
    }

    private void handleButton(String action) {
        if (action.equals("START")) {
            startScreen = false;
            resultsScreen = false;

        } else if (action.equals("EXIT")) {
            System.exit(0);

        } else if (action.equals("CLEAR")) {
            selectedCharacteristics.clear();

        } else if (action.equals("FIND")) {
            findRecommendations();

        } else if (action.equals("MORE")) {
            resultIndex += 3;

        } else if (action.equals("CHANGE")) {
            resultsScreen = false;

        } else if (action.equals("RESTART")) {
            selectedCharacteristics.clear();
            recommendations.clear();
            resultIndex = 0;
            resultsScreen = false;
            startScreen = true;

        } else if (action.startsWith("CHAR:")) {
            String characteristic = action.substring(5);

            if (selectedCharacteristics.contains(characteristic)) {
                selectedCharacteristics.remove(characteristic);
            } else {
                selectedCharacteristics.add(characteristic);
            }
        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();

        for (int i = buttons.size() - 1; i >= 0; i--) {
            UIButton button = buttons.get(i);

            if (button.rectangle.contains(clickPoint)) {
                handleButton(button.action);
                return;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
