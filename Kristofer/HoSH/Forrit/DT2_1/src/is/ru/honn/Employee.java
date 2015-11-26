package is.ru.honn;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kristofer on 8/26/15.
 */
public class Employee extends Person implements Worktime {
    protected double salary;
    protected Date dateOfHire;
    // DateFormat used to change date format
    protected DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public Employee(String name, Date dateOfBirth, Date dateOfHire, double salary) {
        super(name, dateOfBirth);
        this.dateOfHire = dateOfHire;
        this.salary = salary;
    }

    public String getDateOfHire() {
        // formatter used to change date format
        return formatter.format(this.dateOfHire);
    }

    public void setDateOfHire(Date dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    @Override
    public String toString() {
        return "Employee: " + getName() + ", hired " + getDateOfHire();
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;

    }

    @Override
    public int getWorkDays(Date now) {
        return (int)((now.getTime() - dateOfHire.getTime()) / 86400000);
    }
}
