package is.ru.honn.mail;

/**
 * Created by kristofer on 9/9/15.
 */
public abstract class AbstractMailService implements MailService {
    protected String mailServer;
    // this is used by the factory to inject

    public abstract void send(MailMessage msg);

    public void setMailServer(String mailServer)
    {
        this.mailServer = mailServer;
    }

    public String getMailServer()
    {
        return mailServer;
    }
}
