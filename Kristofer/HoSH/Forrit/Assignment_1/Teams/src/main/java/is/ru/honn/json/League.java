package is.ru.honn.json;

/**
 * Stores information about a league. Stores information about league name and this leagues' season.
 *
 * @author Kristofer R.
 * @version 1
 */
public class League {
    private String name;
    private Season season;

    /**
     * Constructor initializes name and season variables
     * @param name Name of the league
     * @param season This leagues' season
     */
    public League(String name, Season season) {
        this.name = name;
        this.season = season;
    }

    /**
     * Override of the toString function
     * @return League name, season, team names, team abbreviations, team venues and the teams' home city
     */
    @Override
    public String toString() {
        String output;
        // Put together 'output' string
        output = "League: " + name + "\n";
        output += "Season: " + season + "\n";
        // "%1$-26s%2$-5s%3$-26s%4$-1s\n" is the format of the string
        output += String.format("%1$-26s%2$-5s%3$-26s%4$-1s\n", "Team Name", "Abb", "Venue", "City");
        output += "------------------------------------------------------------------------\n";
        // Add, in the following order, team name, abbreviation, venue and city to 'output'
        for (int i = 0; i < season.getTeams().size(); i++) {
            output += String.format("%1$-26s%2$-5s%3$-26s%4$-1s\n", season.getTeam(i), season.getTeam(i).getAbb(),
                    season.getTeam(i).getVenue(), season.getTeam(i).getVenue().getLocation());
        }
        return output;
    }
}
