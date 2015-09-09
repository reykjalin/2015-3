package is.ru.honn.factory;

/**
 *
 */
public class FactoryException extends Exception {
    public FactoryException(String message) {
        super(message);
    }

    public FactoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
