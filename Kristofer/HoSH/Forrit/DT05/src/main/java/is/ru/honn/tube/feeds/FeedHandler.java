package is.ru.honn.tube.feeds;

import is.ru.honn.tube.service.Content;

public interface FeedHandler
{
  public void processContent(Content content);
}
