package is.ru.honn.mail;

import is.ru.honn.factory.AbstractFactory;
import is.ru.honn.factory.FactoryException;

/**
 * Created by kristofer on 9/9/15.
 */
public class MailFactory extends AbstractFactory {
    public MailService getMailService() {
        MailService service;
        try {
            loadProperties("mail.properties");
            service = (MailService) loadClass(getProperties().getProperty("mail.service.class"));
            service.setMailServer(getProperties().getProperty("mail.server"));
        } catch (FactoryException fex) {
            throw new MailServiceException("Unable to load class.", fex);
        }
        return service;
    }
}
