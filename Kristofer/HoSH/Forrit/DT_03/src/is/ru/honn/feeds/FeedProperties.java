package is.ru.honn.feeds;

import java.io.*;
import java.util.Properties;

/**
 * Created by kristofer on 9/2/15.
 */
public class FeedProperties extends Properties {
    public FeedProperties() {
        super();

        try {
            Reader inpReader = new FileReader("feeds.properties");
            this.load(inpReader);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Couldn't load file");
        }
    }
    public String getReader() {
        return this.getProperty("reader");
    }
}
