package is.ru.honn.draw;

import is.ru.honn.draw.shapes.Circle;
import is.ru.honn.draw.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kristofer on 8/27/15.
 */
public class Teiknir extends JPanel {
    private Page page = new Page();

    public Teiknir() {
        page.add(new Rectangle(100, 100, 200, 150, Color.blue));
        page.add(new Circle(300, 300, 100, 100, Color.red));
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.setTitle("Teiknir");
        f.setResizable(true);
        f.setSize(500, 500);

        Teiknir panel = new Teiknir();
        f.getContentPane().add(panel);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        page.paint(g);
    }
}
