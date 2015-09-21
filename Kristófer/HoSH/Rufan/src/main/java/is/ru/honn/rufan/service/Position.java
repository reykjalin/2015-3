package is.ru.honn.rufan.service;

/**
 * Created by kristofer on 9/17/15.
 */
public class Position {
    protected int positionId, sequence;
    protected String name, abbreviation;

    public Position(int positionId, String name, String abbreviation, int sequence) {
        this.positionId = positionId;
        this.sequence = sequence;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
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
