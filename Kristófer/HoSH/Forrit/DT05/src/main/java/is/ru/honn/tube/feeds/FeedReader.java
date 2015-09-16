package is.ru.honn.tube.feeds;

public interface FeedReader
{
  public void read(String url) throws FeedException;
  public void setFeedHandler(FeedHandler handler);
}
