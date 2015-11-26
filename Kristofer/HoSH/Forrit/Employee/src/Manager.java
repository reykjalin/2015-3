/**
 * Created by kristofer on 8/19/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Manager extends Employee {
    private String title;

    // Constructor
    public Manager(String name, String title) {
        super(name);
        this.title = title;
    }

    // Get Manager title
    public String getTitle() {
        return title;
    }

    @Override
    // Print Manager name and title
    public String toString() {
        return "Manager: " + getName() + ", " + getTitle();
    }
}
