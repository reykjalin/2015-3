/**
 * Practice project in HoSH 2015
 *
 * @author Kristófer R.
 * @version 1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Object;

public class Hallo extends Object {
    public static void main(String[] args) {
        String advice = "Gott er þeim sem glatt hafa sinni,\n" +
                "guð sé með oss öllum hér inni.\n";

        // Print out advice
        System.out.print(advice);

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
