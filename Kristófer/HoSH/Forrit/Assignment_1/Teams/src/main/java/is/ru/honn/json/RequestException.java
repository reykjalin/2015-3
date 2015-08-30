package is.ru.honn.json;

/**
 * Created by kristofer on 8/30/15.
 */
public class RequestException extends Exception {
    private String title;

    public RequestException(String title) {
        this.title = title;
    }

    @Override
    public String getMessage() {
        return title + ":\n" + getStackTrace();
    }
}
