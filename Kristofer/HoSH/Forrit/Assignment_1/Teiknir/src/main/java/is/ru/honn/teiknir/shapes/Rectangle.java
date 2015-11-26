package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Contains information on Rectangle shape
 *
 * Created by kristofer on 8/29/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Rectangle extends Shape {
    protected int width, height;

    /**
     * Initializes rectangle shape
     * @param x X Position
     * @param y Y Position
     * @param width Rectangle width
     * @param height Rectangle height
     * @param color Rectangle color
     */
    public Rectangle(int x, int y, int width, int height, Color color) {
        super.x = x;
        super.y = y;
        super.color = color;
        this.width = width;
        this.height = height;
    }

    /**
     * Implements draw method from shape. Tells program how to draw the Rectangle shape.
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
}
