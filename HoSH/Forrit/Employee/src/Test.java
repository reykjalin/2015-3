/**
 * Created by kristofer on 8/19/15.
 *
 * Testing Manager and Employee classes
 *
 * @author Kristofer R.
 * @version 1
 */
public class Test {
    public static void main(String[] args) {
        Employee e0 = new Employee("Dilbert");
        Employee e1 = new Manager("Pointy haired", "Boss");

        Employee[] elist = new Employee[2];
        elist[0] = e0;
        elist[1] = e1;

        for (int i = 0; i < elist.length; i++) {
            System.out.println("e" + i + ": " + elist[i].getName());
            if (elist[i] instanceof Manager) {
                Manager m = (Manager)elist[i];
                System.out.println("\t" + m.getTitle());
            }
        }
    }
}
