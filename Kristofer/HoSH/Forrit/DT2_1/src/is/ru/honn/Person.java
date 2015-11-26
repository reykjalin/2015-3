package is.ru.honn;

import java.util.Date;

/**
 * Created by kristofer on 8/26/15.
 *
 * @author Kristofer R.
 * @version 1
 */
abstract public class Person implements Comparable {
    protected  String name;
    protected Date dateOfBirth;

    public Person() {
    }

    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person: " + getName();
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        return this.name.compareTo(p.getName());
    }

    public abstract double getSalary();
}
