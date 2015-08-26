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

        Person Danny = new Employee("Danny", cal.getTime(), cal.getTime());
        Person Erika = new Employee("Erika", cal.getTime(), cal.getTime());
        Person Fred = new Employee("Fred", cal.getTime(), cal.getTime());
        Person Grace = new Employee("Grace", cal.getTime(), cal.getTime());
        Person Henri = new Employee("Henri", cal.getTime(), cal.getTime());
        Person Ida = new Manager("Ida", cal.getTime(), cal.getTime(), "The Boss");
        Person Leslie = new Person("Leslie", cal.getTime());

        ArrayList<Person> staff = new ArrayList<Person>();
        staff.add(0, Danny);
        staff.add(0, Erika);
        staff.add(0, Fred);
        staff.add(0, Grace);
        staff.add(0, Henri);
        staff.add(0, Ida);
        staff.add(0, Leslie);

        Collections.sort(staff);

        for(Object aStaff : staff) {
            Person p = (Person) aStaff;
            System.out.println(p);
        }
    }
}
