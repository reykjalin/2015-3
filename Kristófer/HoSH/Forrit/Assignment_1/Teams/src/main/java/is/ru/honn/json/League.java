package is.ru.honn.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by kristofer on 8/30/15.
 */
public class League {
    private String name, season;
    JSONArray teams;

    public League(String name, String season, JSONArray teams) {
        this.name = name;
        this.season = season;
        this.teams = teams;
    }

    @Override
    public String toString() {
        String output, tname, tabb, tvenue, tcity;
        output = "League: " + name + "\n";
        output += "Season: " + season + "\n";
        output += String.format("%1$-26s%2$-5s%3$-26s%4$-1s\n", "Team Name", "Abb", "Venue", "City");
        output += "------------------------------------------------------------------------\n";
        for (int i = 0; i < teams.size(); i++) {
            JSONObject team = (JSONObject) teams.get(i);
            JSONObject venue = (JSONObject) team.get("venue");
            tname = team.get("displayName").toString();
            tabb = team.get("abbreviation").toString();
            tvenue = venue.get("name").toString();
            tcity = venue.get("city").toString();
            String[] columns = {tname, tabb, tvenue, tcity};

            output += String.format("%1$-26s%2$-5s%3$-26s%4$-1s\n", tname, tabb, tvenue, tcity);
        }
        return output;
    }
}
