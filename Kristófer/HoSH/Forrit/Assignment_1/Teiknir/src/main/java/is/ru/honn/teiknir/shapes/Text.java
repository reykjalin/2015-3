package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Contains information on Text object
 *
 * Created by kristofer on 8/29/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Text extends Shape {
    protected String text, fontName;
    protected int fontSize;

    /**
     * Initializes text object.
     * @param x X position
     * @param y Y position
     * @param text Text to be displayed
     * @param fontSize Size of text
     * @param fontName Name of font to be used
     * @param color Text color
     */
    public Text(int x, int y, String text, int fontSize, String fontName, Color color) {
        super.x = x;
        super.y = y;
        this.text = text;
        this.fontSize = fontSize;
        this.fontName = fontName;
        super.color = color;
    }

    /**
     * Implements draw method from Shape. Tells program how to draw text.
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        // Set font properties
        g.setFont(new Font(fontName, Font.PLAIN, fontSize));
        g.setColor(color);
        g.drawString(text, x, y);
    }
}
