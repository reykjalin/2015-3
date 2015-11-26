package is.ru.honn.draw.shapes;

import sun.security.provider.SHA;

import java.awt.*;

/**
 * Created by kristofer on 8/27/15.
 */
public class Circle extends Shape {
    protected int width, height;

    public Circle(int x, int y, int width, int height, Color color) {
        super.x = x;
        super.y = y;
        super.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }
}
