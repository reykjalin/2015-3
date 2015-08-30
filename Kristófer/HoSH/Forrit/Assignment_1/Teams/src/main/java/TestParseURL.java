import is.ru.honn.json.League;
import is.ru.honn.json.TeamParser;

/**
 * Created by kristofer on 8/30/15.
 */
public class TestParseURL {
    public static void main(String[] args) {
        ClientRequest req = new ClientRequest();
        String content = req.getRequest("http://olafurandri.com/honn/teams.json");
        TeamParser parser = new TeamParser();
        League league = parser.parseTeams(content);
        System.out.println(league);
    }
}
