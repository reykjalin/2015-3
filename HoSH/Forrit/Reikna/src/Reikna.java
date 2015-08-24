import java.util.ArrayList;

/**
 * Created by kristofer on 8/19/15.
 *
 * Create array with point coordinates
 *
 * @author Kristofer R.
 * @version 1.5
 */


public class Reikna {
    public static void main(String[] args) {
        Point p = new Point(4.0, 3.0);

        /**
         * Array implementation
         */
//        // Initialize array kurfa
//        Point[] kurfa = new Point[100];
//        for (int i = 0; i < kurfa.length; i++) {
//            kurfa[i] = new Point(Math.cos(i), Math.sin(i));
//        }
//        // Print contents of kurfa
//        for (int i = 0; i < kurfa.length; i++) {
//            System.out.println(kurfa[i].skrifa());
//        }

        /**
         * ArrayList implementation
         */
        // Initialize kurfa
        ArrayList<Point> kurfa = new ArrayList<Point>();
        for (int i = 0; i < 100; i++) {
            kurfa.add(i, new Point(Math.cos(i), Math.sin(i)));
        }
        // Print contents of kurfa
        for (int i = 0; i < kurfa.size(); i++) {
            System.out.println(kurfa.get(i).skrifa());
        }
    }
}
