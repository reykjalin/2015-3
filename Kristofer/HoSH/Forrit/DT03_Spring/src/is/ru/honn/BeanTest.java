package is.ru.honn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by kristofer on 9/9/15.
 */
public class BeanTest {
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");
        Person elvis = (Person) context.getBean("person");
        System.out.println(elvis);
    }
}
