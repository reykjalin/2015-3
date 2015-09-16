package is.ru.honn.tube.service;

import java.util.Collection;
import java.util.ArrayList;
import is.ruframework.domain.RuObject;

public class ContentServiceStub extends RuObject implements ContentService
{
    Collection<Content> col = new ArrayList<Content>();

    public void addContent(Content content)
    {
        col.add(content);
    }

    public Collection<Content> getContents()
    {
        return col;
    }
}