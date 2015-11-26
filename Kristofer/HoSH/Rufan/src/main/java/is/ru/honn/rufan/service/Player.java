package is.ru.honn.rufan.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kristofer on 9/17/15.
 */
public class Player {
    protected int playerId;
    protected String firstName;
    protected String lastName;
    protected int height;
    protected int weight;
    protected Date birthDate;
    protected Country nationality;
    protected int teamId;
    protected List<Position> positions = new ArrayList<Position>();

    public Player() {
    }

    public Player(int playerId, String firstName, String lastName) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void addPosition(Position position) {
        for(Position p : this.positions) {
            if(p.getPositionId() == position.getPositionId()) {
                return;
            }
        }
        this.positions.add(position);
    }
}
