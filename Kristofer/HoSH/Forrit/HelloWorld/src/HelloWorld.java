/**
 * Created by kristofer on 8/18/15.
 */
public class HelloWorld {
    public void sayHello(String s) {
        System.out.println("Hello " + s);
    }

    public static void main(String[] args) {
        // Have to initialize class, can't call function directly
        HelloWorld hello = new HelloWorld();
        hello.sayHello("World");
    }
}
