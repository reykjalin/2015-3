package is.ru.honn.rufan.service;

/**
 * Created by kristofer on 9/17/15.
 */
public class Country {
    protected int countryId;
    protected String name, abbreviation;

    public Country() {
    }

    public Country(int countryId, String name, String abbreviation) {
        this.countryId = countryId;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
