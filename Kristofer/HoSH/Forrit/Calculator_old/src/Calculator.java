/**
 * Created by kristofer on 8/19/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Calculator {
    // Evaluates RPN expressions and returns results
    public int evalRPN(String[] tokens) {
        // Read tokens and decide which operation to perform
        switch (tokens[2]) {
            case "+":
                return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
            case "-":
                return Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[1]);
            case "*":
                return Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[1]);
            case "/":
                return Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[1]);
            default:
                System.out.println("Something went wrong, try again.");
                return 0;
        }
    }
}
