/**
 * Created by kristofer on 8/19/15.
 *
 * Testing Calculator class
 *
 * @author Kristofer R.
 * @version 1
 */
public class CalcTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // Initialize expression
        String[] expr = {"2", "2", "-"};
        System.out.println(calc.evalRPN(expr));
    }
}
