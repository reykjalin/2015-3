package is.ru.honn;

import is.ru.honn.json.RequestException;
import is.ru.honn.json.TeamParser;

/**
 * Contains main function to test file parsing function
 *
 * @author Kristofer R.
 * @version 1
 */
public class TestParseFile {
    /**
     * Main function of test program
     * @param args Program arguments
     */
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
