package is.ru.honn.tube.service;

import java.util.Date;

/**
 * Created by kristofer on 9/16/15.
 */
public class Content {
    private String title;
    private String link;
    private Date pubDate;
    private String description;
    private int approved;

    public Content() {
    }

    public Content(String title, String link, Date pubDate, String description, int approved) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.description = description;
        this.approved = approved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }
}
