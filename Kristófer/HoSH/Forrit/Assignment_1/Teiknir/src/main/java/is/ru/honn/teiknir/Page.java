package is.ru.honn.teiknir;

import is.ru.honn.teiknir.shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by kristofer on 8/29/15.
 */
public class Page {
    ArrayList<Shape> shapes;

    public Page() {
        shapes = new ArrayList<Shape>();
    }

    public void add(Shape s) {
        shapes.add(s);
    }

    public void paint(Graphics g) {
        for (Drawable d : shapes) {
            d.draw(g);
        }
    }
}
