package is.ru.honn.service;

import is.ru.honn.domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by kristofer on 9/16/15.
 */
public class PlayerServiceStub implements PlayerService {
    Logger log = Logger.getLogger(PlayerServiceStub.class.getName());
    private List<Player> players = new ArrayList<Player>();

    public int addPlayer(Player player) throws ServiceException {
        for(Player p: players)
        {
            if (p.getUsername() == player.getUsername())
            {
                String msg = "Username: '" + player.getUsername() + "' already exists.";
                log.info(msg);
                throw new ServiceException(msg);
            }
        }

        players.add(player);
        log.info("New player added");
        return players.size()-1;
    }

    public Player getPlayer(int playerId) {
        for(Player p: players)
        {
            if (p.getPlayerId() == playerId)
                return p;
        }

        return null;
    }
}
