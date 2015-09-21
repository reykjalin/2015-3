package is.ru.honn.rufan.service;

import java.util.List;

/**
 * Created by kristofer on 9/17/15.
 */
public interface PlayerService
{
    Player getPlayer(int playerId);
    List<Player> getPlayers(int teamId);
    List<Player> getPlayersByAbbreviation(String abbreviation);
    int addPlayer(Player player) throws ServiceException;
}
