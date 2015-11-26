package is.ru.honn.mail;

/**
 * MailService Interface
 */
public interface MailService {
    public void setMailServer(String mailServer);
    public void send(MailMessage message);
}
