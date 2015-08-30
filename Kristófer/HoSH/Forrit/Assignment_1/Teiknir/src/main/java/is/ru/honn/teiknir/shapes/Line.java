package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by kristofer on 8/29/15.
 */
public class Line extends Shape {
    protected int xend, yend;

    public Line(int x, int y, int xend, int yend, Color color) {
        super.x = x;
        super.y = y;
        this.xend = xend;
        this.yend = yend;
        super.color = color;
    }

    @Override
    public void setX(int x) {
        int dx = super.x - x;
        xend -= dx;
        super.x = x;
        // Make sure shape does not go out of frame
        if(super.x < 0) {
            super.x += 500;
            xend += 500;
        } else if(super.x > 500) {
            super.x -= 500;
            xend -= 500;
        }
    }

    @Override
    public void setY(int y) {
        int dy = super.y - y;
        yend -= dy;
        super.y = y;
        // Make sure shape does not go out of frame
        if(super.y < 0) {
            super.y += 500;
            yend += 500;
        } else if(super.y > 500) {
            super.y -= 500;
            yend -= 500;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, xend, yend);
    }
}
