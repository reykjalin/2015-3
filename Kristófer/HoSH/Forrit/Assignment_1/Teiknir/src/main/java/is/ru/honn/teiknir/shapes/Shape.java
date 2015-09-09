package is.ru.honn.teiknir.shapes;

import is.ru.honn.teiknir.Drawable;

import java.awt.*;

/**
 * Abstract class with general basic information that can be globally applied to shapes.
 *
 * Created by kristofer on 8/29/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public abstract class Shape implements Drawable {
    protected int x, y;
    protected Color color;

    /**
     * Method that classes that inherit this class must implement. Draws shape.
     * @param g
     */
    public abstract void draw(Graphics g);

    /**
     * Returns X position of shape
     * @return Data from x variable
     */
    public int getX() {
        return x;
    }

    /**
     * Sets a new X position for shape
     * @param x New x position
     */
    public void setX(int x) {
        this.x = x;
        // Make sure shape does not go out of frame
        if(this.x < 0) {
            this.x += 500;
        } else if(this.x > 500) {
            this.x -= 500;
        }
    }

    /**
     * Returns Y position of shape
     * @return Data from y variable
     */
    public int getY() {
        return y;
    }

    /**
     * Sets a new Y position for shape
     * @param y New y position
     */
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
