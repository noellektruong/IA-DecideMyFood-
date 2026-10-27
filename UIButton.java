import java.awt.Rectangle;

public class UIButton {
    Rectangle rectangle;
    String label;
    String action;

    public UIButton(int x, int y, int width, int height,
                    String label, String action) {
        rectangle = new Rectangle(x, y, width, height);
        this.label = label;
        this.action = action;
    }
}