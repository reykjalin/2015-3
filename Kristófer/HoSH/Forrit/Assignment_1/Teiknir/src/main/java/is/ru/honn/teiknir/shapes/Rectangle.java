package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by kristofer on 8/29/15.
 */
public class Rectangle extends Shape {
    protected int width, height;

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
