package is.ru.honn.rufan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by kristofer on 9/17/15.
 */
public class PlayerServiceStub implements PlayerService {
    protected Logger log = Logger.getLogger(PlayerServiceStub.class.getName());
    protected List<Player> lis = new ArrayList<Player>();

    /**
     * Get a player by a specific ID
     * @param playerId: ID of a player
     * @return p: Player that has the ID
     */
    public Player getPlayer(int playerId) {
        for(Player p: lis) {
            if(p.getPlayerId() == playerId) {
                return p;
            }
        }
        return null;
    }

    /**
     * Returns a List of players that belong to a certain team.
     * @param teamId: Id of their team
     * @return retList: List of players
     */
    public List<Player> getPlayers(int teamId) {
        List<Player> retList = new ArrayList<Player>();
        for(Player p : lis) {
            if(p.getTeamId() == teamId) {
                retList.add(p);
            }
        }
        return retList;
    }

    /**
     * TODO: tékka hvort virkni sé rétt!
     * @param abbreviation
     * @return
     */
    public List<Player> getPlayersByAbbreviation(String abbreviation) {
        List<Player> retList = new ArrayList<Player>();

        for(Player p : lis) {
            if(p.getNationality().getAbbreviation() == abbreviation) {
                retList.add(p);
            }
        }

        return retList;
    }

    /**
     * Adds new Player object to player list. Throws exception if player already exists.
     * @param player: object to be added
     * @return Added players position in list
     * @throws ServiceException
     */
    public int addPlayer(Player player) throws ServiceException {
        for(Player p : lis) {
            if(p.getPlayerId() == player.getPlayerId()) {
                String msg = "Player '" + player.getFirstName() + " " + player.getLastName() + "' already exists.";
                log.info(msg);
                throw new ServiceException(msg);
            }
        }
        lis.add(player);
        return lis.size() - 1;
    }
}
