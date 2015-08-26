package is.ru.honn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kristofer on 8/26/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Test1 {
    // Danny, Erika, Fred, Grace, Henri, Ida

    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar();

        Person Danny = new Employee("Danny", cal.getTime(), cal.getTime(), 22000);
        Person Erika = new Employee("Erika", cal.getTime(), cal.getTime(), 22000);
        Person Fred = new Employee("Fred", cal.getTime(), cal.getTime(), 22000);
        Person Grace = new Employee("Grace", cal.getTime(), cal.getTime(), 22000);
        Person Henri = new Employee("Henri", cal.getTime(), cal.getTime(), 22000);
        Person Ida = new Manager("Ida", cal.getTime(), cal.getTime(), "The Boss", 32000);
        Person Leslie = new Employee("Leslie", cal.getTime(), cal.getTime(), 22000);

        ArrayList<Person> staff = new ArrayList<Person>();
        staff.add(Danny);
        staff.add(Erika);
        staff.add(Fred);
        staff.add(Grace);
        staff.add(Henri);
        staff.add(Ida);
        staff.add(Leslie);

        Collections.sort(staff);

        for(Object aStaff : staff) {
            Person p = (Person) aStaff;
            System.out.println(p + ": " + p.getSalary());
        }
    }
}
