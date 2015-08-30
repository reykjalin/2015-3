package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by kristofer on 8/29/15.
 */
public class Text extends Shape {
    protected String text, fontName;
    protected int fontSize;

    public Text(int x, int y, String text, int fontSize, String fontName, Color color) {
        super.x = x;
        super.y = y;
        this.text = text;
        this.fontSize = fontSize;
        this.fontName = fontName;
        super.color = color;
    }

    @Override
    public void draw(Graphics g) {
        // Set font properties
        g.setFont(new Font(fontName, Font.PLAIN, fontSize));
        g.setColor(color);
        g.drawString(text, x, y);
    }
}
