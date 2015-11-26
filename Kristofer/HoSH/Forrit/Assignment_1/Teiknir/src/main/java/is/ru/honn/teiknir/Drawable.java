package is.ru.honn.teiknir;

import java.awt.*;

/**
 * Interface that contains the basic draw method. Classes that inherit this interface must implement draw function.
 *
 * Created by kristofer on 8/29/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public interface Drawable {
    /**
     * Draws object
     * @param g
     */
    void draw(Graphics g);
}
