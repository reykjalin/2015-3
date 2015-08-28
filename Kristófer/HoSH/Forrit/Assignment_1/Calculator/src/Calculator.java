import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by kristofer on 8/27/15.
 *
 * @author Kristófer R.
 * @version 1
 */
public class Calculator {
    private Stack<String> stack;

    public Calculator() throws IOException {
        stack = new Stack<String>();
        Boolean running = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (running) {
            // Read standard input
            String inp = "";
            try {
                inp = br.readLine();
            } catch (Exception ex) {
                System.out.println("Caught exception: " + ex.getStackTrace());
            }

            // Determine what the input contains
            if(inp.contentEquals("exit")) {
                running = false;
            }
            else if(isOperator(inp)) {
                stack.push(inp);
                evaluate(stack);
                System.out.println(stack);
            }
            else if(isInt(inp)) {
                stack.push(inp);
                System.out.println(stack);
            }
            else {
                System.out.println("Error: illegal input");
            }
        }
    }

    private int evaluate(Stack<String> stack) {
        String top;
        // Make sure I'm not popping an empty stack
        if(stack.size() > 0) {
            top = stack.pop();
        } else {
            System.out.println("Stack not big enough to do operations. Returning 0.");
            return 0;
        }

        /* Return top of stack if it's a number. Note: Know it's a number
        because otherwise it wouldn't be on stack. See constructor if statements */
        if(!isOperator(top)) {
            return Integer.valueOf(top);
        } // Not a number => operator. See if-else in constructor.
        else {
            // index determines which operator to use
            int index = getIndex(top);
            int a = evaluate(stack);
            switch (index) {
                case 0: // index 0 is "+"
                    stack.push(String.valueOf(evaluate(stack) + a));
                    break;
                case 1: // index 1 is "-"
                    stack.push(String.valueOf(evaluate(stack) - a));
                    break;
                case 2: // index 2 is "*"
                    stack.push(String.valueOf(evaluate(stack) * a));
                    break;
                case 3: // index 3 is "/"
                    if(a != 0) {
                        stack.push(String.valueOf(evaluate(stack) / a));
                    } else {
                        System.out.println("Can't divide by zero!");
                        stack.push(String.valueOf(a));
                    }
                    break;
                case 4: // index 4 is "!"
                    stack.push(getFactorial(a));
                    break;
                default: // error handling
                    System.out.println("Error: invalid operator");
                    break;
            }
        }
        // Return 0 by default
        return 0;
    }

    // Return factorial of 'a' as string
    private String getFactorial(int a) {
        int factorial = 1;
        for (int i = 1; i <= a; i++) {
            factorial *= i;
        }
        return String.valueOf(factorial);
    }

    // Returns true if string 's' is an integer
    private Boolean isInt(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Returns true if string 's' is an operator
    private Boolean isOperator(String s) {
        String operators = "+-*/!";
        if(operators.contains(s)) {
            return true;
        } else {
            return false;
        }
    }

    // Decides which operator 's' contains
    private int getIndex(String s) {
        String operators = "+-*/!";
        return operators.indexOf(s);
    }

    @Override
    public String toString() {
        Stack<String> temp = this.stack;
        String stack_str = "[";
        while(!temp.empty()) {
            if(stack.size() == 1) {
                stack_str += temp.pop() + "]";
            } else {
                stack_str += temp.pop() + ", ";
            }
        }
        return stack_str;
    }
}
