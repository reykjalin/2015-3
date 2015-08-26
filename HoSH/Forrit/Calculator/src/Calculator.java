import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by kristofer on 8/25/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Calculator {
    public static void main(String[] args) {
        String inp = "";
        Stack<String> stack = new Stack<String>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inp = br.readLine();
        stack.push(inp)
        while(!stack.empty()) {

            try {
                inp = br.readLine();
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Stack trace: " + ex.getStackTrace());
            }
            stack.push(inp);
        }

        System.out.println(inp);
    }
}
