package is.ru.honn.factory;

import is.ru.honn.feeds.FeedProperties;
import is.ru.honn.feeds.FeedReader;

/**
 * Created by kristofer on 9/2/15.
 */
public class ReaderFactory {
    public static FeedReader getFeedReader(String source) {
        FeedProperties fProp = new FeedProperties();
        Class instanceClass;
        FeedReader reader = null;
        try{
            instanceClass = Class.forName(fProp.getReader());
            reader = (FeedReader) instanceClass.newInstance();
            reader.setSource(source);
        } catch (Exception e) {
            throw new FactoryException("Finn ekki gildið", e);
        }
        return reader;
    }
}
