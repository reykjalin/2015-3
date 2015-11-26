/**
 * Created by kristofer on 8/19/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Employee {
    private String name;

    // Constructors
    public Employee() {}
    public Employee(String name) {
        this.name = name;
    }

    // Get name of employee
    public String getName() {
        return name;
    }

    @Override
    // Print employee name
    public String toString() {
        return "Employee: " + getName();
    }
}
