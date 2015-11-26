package is.ru.honn.service;

import is.ru.honn.domain.Player;

/**
 * Created by kristofer on 9/16/15.
 */
public interface PlayerService {
    public int addPlayer(Player player) throws ServiceException;
    public Player getPlayer(int playerId);
}
