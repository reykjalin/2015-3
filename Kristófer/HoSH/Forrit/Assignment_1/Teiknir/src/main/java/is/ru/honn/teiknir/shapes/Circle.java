package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by kristofer on 8/29/15.
 */
public class Circle extends Shape {
    protected int width, height;

    public Circle(int x, int y, int width, int height, Color color) {
        super.x = x;
        super.y = y;
        this.width = width;
        this.height = height;
        super.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }
}
