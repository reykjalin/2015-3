package is.ru.honn.mail;

import is.ru.honn.factory.FactoryException;

/**
 * Created by kristofer on 9/9/15.
 */
public class MailServiceException extends RuntimeException {
    public MailServiceException(String message) {
        super(message);
    }

    public MailServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
