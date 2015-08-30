package is.ru.honn.teiknir.json;

/**
 * Created by kristofer on 8/29/15.
 */
public class FileLoadException extends Exception {
    private String title;

    public FileLoadException(String title) {
        this.title = title;
    }

    @Override
    public String getMessage() {
        // Returns what kind of exception it was('title') and exception stack trace
        return title + ":\n" + getStackTrace();
    }
}
