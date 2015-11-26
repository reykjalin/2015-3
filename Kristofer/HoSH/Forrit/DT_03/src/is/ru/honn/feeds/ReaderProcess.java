package is.ru.honn.feeds;

import is.ru.honn.factory.ReaderFactory;

/**
 * Created by kristofer on 9/2/15.
 */
public class ReaderProcess implements FeedHandler {
    FeedReader reader;

    public ReaderProcess() {
        reader = ReaderFactory.getFeedReader("http://www.olafurandri.com/?feed=rss2");
        reader.setFeedHandler(this);
    }

    public void read() {
        reader.read();
    }

    @Override
    public void processEntry(FeedEntry entry) {
        System.out.println(entry);
    }
}
