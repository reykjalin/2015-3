package is.ru.honn.teiknir;

import is.ru.honn.teiknir.shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

/**
 * Contains information on Page object and relevant methods.
 *
 * Created by kristofer on 8/29/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Page {
    ArrayList<Shape> shapes;

    /**
     * Default constructor initializes empty page containing no shapes.
     */
    public Page() {
        shapes = new ArrayList<Shape>();
    }

    /**
     * Adds a shape to the page
     * @param s Shape to add
     */
    public void add(Shape s) {
        shapes.add(s);
    }

    /**
     * Draws all shapes stored in page
     * @param g
     */
    public void paint(Graphics g) {
        for (Drawable d : shapes) {
            d.draw(g);
        }
    }
}
