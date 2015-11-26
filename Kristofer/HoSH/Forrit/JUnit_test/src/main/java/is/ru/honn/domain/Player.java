package is.ru.honn.domain;

/**
 * Created by kristofer on 9/16/15.
 */
public class Player {
    protected int playerId;
    protected String username, name;

    public Player() {
    }

    public Player(int playerId, String username, String name) {
        this.playerId = playerId;
        this.username = username;
        this.name = name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
