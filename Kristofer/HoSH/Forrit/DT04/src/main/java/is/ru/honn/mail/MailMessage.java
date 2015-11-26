package is.ru.honn.mail;

/**
 * Created by kristofer on 9/9/15.
 */
public class MailMessage {
    private String from;
    private String to;
    private String subject;
    private String body;

    public MailMessage()
    {
    }

    public MailMessage(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "From: " + this.from +
                " To: " + this.to +
                " Subject: " + this.subject;
    }
}
