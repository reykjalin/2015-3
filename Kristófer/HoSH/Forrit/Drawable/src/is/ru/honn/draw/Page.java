package is.ru.honn.draw;

import is.ru.honn.draw.shapes.Shape;
import sun.security.provider.SHA;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by kristofer on 8/27/15.
 */
public class Page {
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void add(Shape s) {
        shapes.add(s);
    }

    public void paint(Graphics g) {
        for(Drawable d: shapes) {
            d.draw(g);
        }
    }
}
