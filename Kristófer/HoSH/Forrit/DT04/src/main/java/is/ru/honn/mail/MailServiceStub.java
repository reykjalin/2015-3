package is.ru.honn.mail;

import java.util.logging.Logger;

/**
 * Created by kristofer on 9/9/15.
 */
public class MailServiceStub extends AbstractMailService {
    private Logger logger = Logger.getLogger(MailServiceStub.class.getName());

    public void send(MailMessage message) {
        logger.info(message.toString());
        logger.info("Mail server: " + this.getMailServer());
    }
}
