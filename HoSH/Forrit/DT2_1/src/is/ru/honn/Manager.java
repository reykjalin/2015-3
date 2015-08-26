package is.ru.honn;

import java.util.Date;

/**
 * Created by kristofer on 8/26/15.
 */
public class Manager extends Employee {
    protected String title;

    public Manager(String name, Date dateOfBirth, Date dateOfHire, String title, double salary) {
        super(name, dateOfBirth, dateOfHire, salary);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Manager: " + getName() + ", " + getTitle();
    }
}
