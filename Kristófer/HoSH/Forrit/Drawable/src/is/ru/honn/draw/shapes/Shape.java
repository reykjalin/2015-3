package is.ru.honn.draw.shapes;

import is.ru.honn.draw.Drawable;

import java.awt.*;

/**
 * Created by kristofer on 8/27/15.
 */
abstract public class Shape implements Drawable {
    protected int x, y;
    protected Color color;

    public abstract void draw(Graphics g);
}
