import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by kristofer on 8/27/15.
 *
 * Nota simpletimeformat til að laga timestamps
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
            else if(isOperator(inp) || isInt(inp)) {
                stack.push(inp);
                evaluate(stack);
            }
            else {
                System.out.println("Error: illegal input");
            }
        }
    }

    private void evaluate(Stack<String> stack) {
        String top;
        // Make sure I'm not popping an empty stack
        if(!stack.isEmpty()) {
            top = stack.pop();
        } else {
            System.out.println("Empty stack error.");
            return;
        }

        // Check if there is an operator or a number
        if(isInt(top)) {
            // If 'top' is a number push it back onto the stack and print the stack
            stack.push(top);
            System.out.println(stack);
        }
        else {
            int index = getIndex(top); // Finds which operator it is
            if(!stack.isEmpty()) {
                int a = Integer.valueOf(stack.pop());

                // index 4 is "!"
                if (index == 4) {
                    stack.push(getFactorial(a));
                } else {
                    // Make sure there was actually something to pop
                    if (!stack.isEmpty()) {
                        int b = Integer.valueOf(stack.pop());
                        switch (index) {
                            case 0: // index 0 is "+"
                                stack.push(String.valueOf(a + b));
                                break;
                            case 1: // index 1 is "-"
                                stack.push(String.valueOf(a - b));
                                break;
                            case 2: // index 2 is "*"
                                stack.push(String.valueOf(a * b));
                                break;
                            case 3: // index 3 is "/"
                                if (b != 0) {
                                    stack.push(String.valueOf(a / b));
                                } else {
                                    System.out.println("Can't divide by zero!");
                                    stack.push(String.valueOf(b));
                                    stack.push(String.valueOf(a));
                                }
                                break;
                            default:
                                System.out.println("Oops. Something went wrong. Don't worry though, " +
                                        "our code monkeys are working on it!");
                                break;
                        }
                        evaluate(stack);
                    } else {
                        // If 'a' was the only number on the stack, push it back onto the stack
                        stack.push(String.valueOf(a));
                    }
                }
            }
        }
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
                stack_str += temp.pop();
            } else {
                stack_str += temp.pop() + ", ";
            }
        }
        stack_str += "]";
        return stack_str;
    }
}
