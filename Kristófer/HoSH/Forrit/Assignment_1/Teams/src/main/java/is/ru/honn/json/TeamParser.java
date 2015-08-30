package is.ru.honn.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Created by kristofer on 8/30/15.
 */
public class TeamParser {
    public void parseAndPrint(String s) {
        // Initialize all json objects
        JSONObject jsonObject = (JSONObject) JSONValue.parse(s);
        JSONArray apiArray = (JSONArray) jsonObject.get("apiResults");
        JSONObject apiResults = (JSONObject) apiArray.get(0);
        JSONObject league = (JSONObject) apiResults.get("league");
        JSONObject season = (JSONObject) league.get("season");
        JSONArray conferences_array = (JSONArray) season.get("conferences");
        JSONObject conferences = (JSONObject) conferences_array.get(0);
        JSONArray divisions_array = (JSONArray) conferences.get("divisions");
        JSONObject divisions = (JSONObject) divisions_array.get(0);
        JSONArray teams = (JSONArray) divisions.get("teams");

        // Print relevant information
        System.out.println(jsonObject.get("status"));
        System.out.println(jsonObject.get("recordCount"));
        System.out.println(jsonObject.get("startTimestamp"));
        System.out.println(jsonObject.get("endTimestamp"));
        System.out.println(jsonObject.get("timeTaken"));
        System.out.println(apiResults.get("name"));
        System.out.println(league.get("name"));
        System.out.println(season.get("name"));

        // Print team information
        for (int i = 0; i < teams.size(); i++) {
            JSONObject team = (JSONObject) teams.get(i);
            JSONObject venue = (JSONObject) team.get("venue");
            System.out.println(team.get("displayName") + ", " + venue.get("name"));
        }
    }
    public League parseTeams(String s) {
        // Initialize all json objects
        JSONObject jsonObject = (JSONObject) JSONValue.parse(s);
        JSONArray apiArray = (JSONArray) jsonObject.get("apiResults");
        JSONObject apiResults = (JSONObject) apiArray.get(0);
        JSONObject league = (JSONObject) apiResults.get("league");
        JSONObject season = (JSONObject) league.get("season");
        JSONArray conferences_array = (JSONArray) season.get("conferences");
        JSONObject conferences = (JSONObject) conferences_array.get(0);
        JSONArray divisions_array = (JSONArray) conferences.get("divisions");
        JSONObject divisions = (JSONObject) divisions_array.get(0);
        JSONArray teams = (JSONArray) divisions.get("teams");

        League data = new League(league.get("name").toString(), season.get("name").toString(), teams);
        return data;
    }
}
