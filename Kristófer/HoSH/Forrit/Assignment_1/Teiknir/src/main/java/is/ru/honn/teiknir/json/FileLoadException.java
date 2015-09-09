package is.ru.honn.teiknir.json;

/**
 * Custom exception class to get customized information on thrown exceptions.
 *
 * Created by kristofer on 8/29/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class FileLoadException extends Exception {
    private String message;

    /**
     * Initilizes message according to parameter
     * @param message Custom message
     */
    public FileLoadException(String message) {
        this.message = message;
    }

    /**
     * Overrides getMessage() function to show a custom message
     * @return New message
     */
    @Override
    public String getMessage() {
        // Returns what kind of exception it was('title') and exception stack trace
        return message + "\nStack trace: " + getStackTrace();
    }
}
