package is.ru.honn.json;

/**
 * Stores information of a venue
 *
 * @author Kristofer R.
 * @version 1
 */
public class Venue {
    private String name, location;

    /**
     * Initializes class variables
     * @param name Venue name
     * @param location Venue location
     */
    public Venue(String name, String location) {
        this.name = name;
        this.location = location;
    }

    /**
     * Returns location of venue
     * @return Data stored in location variable
     */
    public String getLocation() {
        return location;
    }

    /**
     * Override of toString() method to show venue name
     * @return Data stored in name variable
     */
    @Override
    public String toString() {
        return name;
    }
}
