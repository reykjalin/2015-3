package is.ru.honn.feeds;

/**
 * Created by kristofer on 9/2/15.
 */
public interface FeedReader {
    void setSource(String source);
    boolean read();
    void setFeedHandler(FeedHandler handler);
}
