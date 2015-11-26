/**
 * Created by kristofer on 8/19/15.
 *
 * @author Kristófer R.
 * @version 1
 */
public class Point {
    private double dx, dy;

    // Constructor
    public Point(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    // Skilar gildi dx
    public double getx() {
        return dx;
    }
    // Skilar gildi dy
    public double gety() {
        return dy;
    }

    // Skilar streng með hnitum
    public String skrifa() {
        return "Hnit (" + dx + ", " + dy + ")";
    }
}
