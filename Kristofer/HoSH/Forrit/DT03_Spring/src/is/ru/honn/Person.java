package is.ru.honn;

/**
 * Created by kristofer on 9/9/15.
 */
public class Person {
    protected String name, email;

    public Person() {
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\ne-mail: " + email;
    }
}
