package is.ru.honn.feeds;

/**
 * Created by kristofer on 9/2/15.
 */
public class FeedEntry {
    String title, link;

    public FeedEntry(String title, String link) {
        this.title = title;
        this.link = link;
    }

    @Override
    public String toString() {
        return title + "\n" + link + "\n";
    }
}
