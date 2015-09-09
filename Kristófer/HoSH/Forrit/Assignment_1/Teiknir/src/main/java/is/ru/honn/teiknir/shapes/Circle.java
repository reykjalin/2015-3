package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Stores information on how to draw a circle shape
 *
 * Created by kristofer on 8/29/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Circle extends Shape {
    protected int width, height;

    /**
     * Constructor initializes circle shape
     * @param x X position
     * @param y Y position
     * @param width Circle width
     * @param height Circle height
     * @param color Circle color
     */
    public Circle(int x, int y, int width, int height, Color color) {
        super.x = x;
        super.y = y;
        this.width = width;
        this.height = height;
        super.color = color;
    }

    /**
     * Implements draw method from shape. Tells program how to draw the shape.
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }
}
