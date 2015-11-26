package is.ru.honn.feeds.rss;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import is.ru.honn.feeds.AbstractFeedReader;
import is.ru.honn.feeds.FeedEntry;
import is.ru.honn.feeds.FeedHandler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kristofer on 9/2/15.
 */
public class RssFeedReader extends AbstractFeedReader {
    private String source;
    FeedHandler handler;

    public RssFeedReader() {
    }

    public RssFeedReader(String source) {

        this.source = source;
    }

    public String getSource() {
        return source;
    }

    @Override
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean read() {
        URL feedUrl = null;
        try {
            feedUrl = new URL(source);
        } catch (MalformedURLException e) {
            System.out.println("URL is not correct (Malformed)");
        }
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed syndFeed = null;
        try {
            syndFeed = input.build(new XmlReader(feedUrl));
        } catch (FeedException e) {
            System.out.println("URL is not correct");
            return false;
        } catch (IOException e) {
            System.out.println("URL is not correct");
            return false;
        }
        List list = syndFeed.getEntries();
        Iterator i = list.iterator();
        SyndEntry ent = null;
        while(i.hasNext()) {
            ent = (SyndEntry) i.next();
            handler.processEntry(new FeedEntry(ent.getTitle(), ent.getLink()));
        }

        return true;
    }

    @Override
    public void setFeedHandler(FeedHandler handler) {
        this.handler = handler;
    }
}
