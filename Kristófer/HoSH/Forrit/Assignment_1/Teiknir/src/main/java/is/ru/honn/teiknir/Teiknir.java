package is.ru.honn.teiknir;

import is.ru.honn.teiknir.json.FileLoadException;
import is.ru.honn.teiknir.json.FileLoader;
import is.ru.honn.teiknir.json.JsonConverter;
import is.ru.honn.teiknir.shapes.*;
import is.ru.honn.teiknir.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by kristofer on 8/29/15.
 */
public class Teiknir extends JPanel implements KeyListener {
    private Page page = new Page();
    // 'index' used to keep track of which shape is active
    private int index = 0;

    // Default constructor
    public Teiknir() {
        page.add(new Rectangle(10, 10, 100, 100, Color.blue));
        page.add(new Circle(200, 200, 100, 100, Color.red));
        page.add(new Line(0, 0, 500, 500, Color.magenta));
        page.add(new Text(150, 150, "NEVER USE COMIC SANS", 18, "Times New Roman", Color.black));
        setFocusable(true);
        addKeyListener(this);
    }
    // Constructor takes args as parameter
    public Teiknir(String[] args) {
        // Load text from json file
        FileLoader loader = new FileLoader();
        String content = "";
        try {
            content = loader.loadFileName(args[0]);
        } catch (FileLoadException e) {
            e.getMessage();
            System.exit(-1);
        }
        // 'conv' used to parse json file text
        JsonConverter conv = new JsonConverter();
        // Get page by parsing json file text and passing to Teiknir
        page = conv.parseJson(content);
        // Focusable true so KeyListener will work
        setFocusable(true);
        addKeyListener(this);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.setTitle("Teiknir");
        f.setResizable(true);
        f.setSize(500, 500);

        Teiknir panel;
        if(args.length != 0) {
            panel = new Teiknir(args);
        } else {
            panel = new Teiknir();
        }
        f.getContentPane().add(panel);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        page.paint(g);
    }

    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public void keyPressed(KeyEvent e) {
        // Move objects based on key presses
        switch (e.getKeyCode()) {
            case KeyEvent.VK_L:
                page.shapes.get(index).setX(page.shapes.get(index).getX() + 1);
                break;
            case KeyEvent.VK_I:
                page.shapes.get(index).setY(page.shapes.get(index).getY() - 1);
                break;
            case KeyEvent.VK_J:
                page.shapes.get(index).setX(page.shapes.get(index).getX() - 1);
                break;
            case KeyEvent.VK_K:
                page.shapes.get(index).setY(page.shapes.get(index).getY() + 1);
                break;
            case KeyEvent.VK_Q:
                index++;
                if(index >= 4) {
                    index = 0;
                }
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        // Not used
    }
}
