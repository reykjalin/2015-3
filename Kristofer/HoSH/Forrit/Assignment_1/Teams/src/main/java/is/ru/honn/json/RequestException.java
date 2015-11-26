package is.ru.honn.json;

/**
 * Custom exception class made to better understand caught exceptions
 *
 * @author Kristofer R.
 * @version 1
 */
public class RequestException extends Exception {
    private String message;

    /**
     * Initializes message variable
     * @param message
     */
    public RequestException(String message) {
        this.message = message;
    }

    /**
     * Override getMessage to also show stack trace.
     * @return String containing a custom message including a stack trace.
     */
    @Override
    public String getMessage() {
        return message + "\n" + getStackTrace();
    }
}
