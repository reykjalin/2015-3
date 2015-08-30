package is.ru.honn.teiknir.shapes;

import is.ru.honn.teiknir.Drawable;

import java.awt.*;

/**
 * Created by kristofer on 8/29/15.
 */
public abstract class Shape implements Drawable {
    protected int x, y;
    protected Color color;

    public abstract void draw(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        // Make sure shape does not go out of frame
        if(this.x < 0) {
            this.x += 500;
        } else if(this.x > 500) {
            this.x -= 500;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        // Make sure shape does not go out of frame
        if(this.y < 0) {
            this.y += 500;
        } else if(this.y > 500) {
            this.y -= 500;
        }
    }
}
