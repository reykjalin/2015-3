package is.ru.honn.test;

import is.ru.honn.mail.MailFactory;
import is.ru.honn.mail.MailMessage;
import is.ru.honn.mail.MailService;
import is.ru.honn.mail.MailServiceException;

/**
 * Created by kristofer on 9/9/15.
 */
public class TestMail {
    public static void main(String[] args) {
        MailFactory factory = new MailFactory();
        MailService mail = factory.getMailService();
        MailMessage msg = new MailMessage("kristofert13@ru.is", "kristofer022@live.com", "Final test", "Allt í gúddí?\n-Kristófer R.");
        try {
            mail.send(msg);
        } catch (MailServiceException msex) {
            System.out.println("Villa kom upp: " + msex.getMessage());
        }
    }
}
