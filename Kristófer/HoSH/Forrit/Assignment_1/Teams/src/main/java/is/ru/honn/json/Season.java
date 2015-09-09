package is.ru.honn.json;

import java.util.ArrayList;

/**
 * Stores information about a League objects' season.
 *
 * @author Kristofer R.
 * @version 1
 */
public class Season {
    private String name;
    private ArrayList<Teams> teams;

    /**
     * Constructor initalizes variables name and teams
     * @param name Name of the season
     */
    public Season(String name) {
        this.name = name;
        teams = new ArrayList<Teams>();
    }

    /**
     * Add a team to the teams ArrayList
     * @param team The team that is to be added to the list
     */
    public void add(Teams team) {
        teams.add(team);
    }

    /**
     * Returns all teams competing in the season
     * @return List of teams
     */
    public ArrayList<Teams> getTeams() {
        return teams;
    }

    /**
     * Returns a specific team competing this season
     * @param index Index of the team to get
     * @return The specified team
     */
    public Teams getTeam(int index) {
        return teams.get(index);
    }

    /**
     * Override toString to return name of Season
     * @return Name of season
     */
    @Override
    public String toString() {
        return name;
    }
}
