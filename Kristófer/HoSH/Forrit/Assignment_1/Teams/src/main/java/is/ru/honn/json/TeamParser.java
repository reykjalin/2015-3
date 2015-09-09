package is.ru.honn.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.text.*;
import java.util.Date;

/**
 * Stores functions for parsing text from .json files.
 *
 * @author Kristofer R.
 * @version 1
 */
public class TeamParser {
    /**
     * Gets as a parameter text from .json file and prints content to standard output.
     * @param s Text from .json file
     */
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
        System.out.println("startTimestamp: " + stringToDate(jsonObject.get("startTimestamp").toString()));
        System.out.println("endTimestamp: " + stringToDate(jsonObject.get("endTimestamp").toString()));
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

    /**
     * Gets as a parameter text from a .json file and stores content in a League object.
     * @param s Text from .json file
     * @return League object that contains information about season and teams.
     */
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

        // Initialize new Season
        Season season_data = new Season(season.get("name").toString());
        for (int i = 0; i < teams.size(); i++) {
            // Get necessary JSON objects
            JSONObject jTeam = (JSONObject) teams.get(i);
            JSONObject jVenue = (JSONObject) jTeam.get("venue");
            // Initialize new Venue and Team and add those to season_data
            Venue venue = new Venue(jVenue.get("name").toString(), jVenue.get("city").toString());
            Teams team = new Teams(jTeam.get("displayName").toString(), jTeam.get("abbreviation").toString(), venue);
            season_data.add(team);
        }
        // Initialize new League
        League league_data = new League(league.get("name").toString(), season_data);
        return league_data;
    }

    /**
     * Converts string parameter to Date variable
     * @param date_str Contains date in a string format
     * @return Date variable set according to parameter
     */
    public Date stringToDate(String date_str) {
        Date date = new Date();
        SimpleDateFormat orgFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
        try {
            date = orgFormat.parse(date_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
