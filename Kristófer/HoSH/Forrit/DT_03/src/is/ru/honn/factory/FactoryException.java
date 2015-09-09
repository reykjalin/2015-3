package is.ru.honn.factory;

/**
 * Created by kristofer on 9/2/15.
 */
public class FactoryException extends RuntimeException {
    public FactoryException() {
    }

    public FactoryException(String message) {
        super(message);
    }

    public FactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactoryException(Throwable cause) {
        super(cause);
    }
}
