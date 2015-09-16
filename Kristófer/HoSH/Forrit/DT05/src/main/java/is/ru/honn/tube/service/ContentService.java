package is.ru.honn.tube.service;

import java.util.Collection;

public interface ContentService
{
    public void addContent(Content content);
    public Collection<Content> getContents();
}