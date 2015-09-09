package is.ru.honn.json;

/**
 * Stores information on a Team
 *
 * @author Kristofer R.
 * @version 1
 */
public class Teams {
    private String name, abb;
    private Venue venue;

    /**
     * Initializes class variables
     * @param name Name of team
     * @param abb Abbreviation of team name
     * @param venue Name of teams' venue
     */
    public Teams(String name, String abb, Venue venue) {
        this.name = name;
        this.abb = abb;
        this.venue = venue;
    }

    /**
     * Returns teams' Venue object
     * @return Venue object
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * Returns string containing team name abbreviation
     * @return Abbreviation of name
     */
    public String getAbb() {

        return abb;
    }

    /**
     * Override of toString() method to show team name
     * @return Team name
     */
    @Override
    public String toString() {
        return name;
    }
}
