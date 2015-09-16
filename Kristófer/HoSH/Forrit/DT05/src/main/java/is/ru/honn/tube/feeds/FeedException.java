package is.ru.honn.tube.feeds;

public class FeedException extends Exception
{
  public FeedException(String message)
  {
    super(message);
  }

  public FeedException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
