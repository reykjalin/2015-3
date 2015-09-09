package is.ru.honn;

/**
 * Created by kristofer on 9/9/15.
 */
public class Person {
    protected String name, email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\ne-mail: " + email;
    }
}
