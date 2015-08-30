import is.ru.honn.json.RequestException;
import is.ru.honn.json.TeamParser;

/**
 * Created by kristofer on 8/30/15.
 */
public class TestParseFile {
    public static void main(String[] args) {
        ClientRequest req = new ClientRequest();
        String content = "";
        try {
            content = req.getFileContent("teams.json");
        } catch (RequestException e) {
            System.out.println(e.getMessage());
        }
        TeamParser parser = new TeamParser();
        parser.parseAndPrint(content);
    }
}
