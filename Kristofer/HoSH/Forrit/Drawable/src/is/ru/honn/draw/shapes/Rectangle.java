package is.ru.honn.draw.shapes;

import java.awt.*;

/**
 * Created by kristofer on 8/27/15.
 */
public class Rectangle extends Shape {
    private int width, height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super.x = x;
        super.y = y;
        super.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
}
