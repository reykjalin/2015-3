package is.ru.honn;

import is.ru.honn.json.League;
import is.ru.honn.json.TeamParser;

/**
 * Created to test URL parsing function
 *
 * @author Kristofer R.
 * @version 1
 */
public class TestParseURL {
    /**
     * Main function for testing URL parsing
     * @param args Program arguments
     */
    public static void main(String[] args) {
        ClientRequest req = new ClientRequest();
        String content = req.getRequest("http://olafurandri.com/honn/teams.json");
        TeamParser parser = new TeamParser();
        League league = parser.parseTeams(content);
        System.out.println(league);
    }
}
