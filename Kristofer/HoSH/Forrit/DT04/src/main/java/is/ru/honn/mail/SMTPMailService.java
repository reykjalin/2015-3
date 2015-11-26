package is.ru.honn.mail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * SMTMailService
 */
public class SMTPMailService extends AbstractMailService {

    public void send(MailMessage message) {
        Logger logger = Logger.getLogger(SMTPMailService.class.getName());
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", getMailServer());
            Session session = Session.getDefaultInstance(props, null);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(message.getFrom()));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(message.getTo(), false));
            msg.setSubject(message.getSubject());
            msg.setText(message.getBody());
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (Exception ex) {
            String msg = "MailService: Sending mail failed: " + ex.getMessage();
            logger.severe(msg);
            throw new MailServiceException(msg, ex);
        }
    }
}
