import is.ru.honn.rufan.service.Player;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.PlayerServiceStub;
import is.ru.honn.rufan.service.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by kristofer on 9/18/15.
 */
public class TestPlayerService {
    @Autowired
    private PlayerService service = new PlayerServiceStub();

    @Before
    public void setup() {
        // Empty
    }

    @Test
    public void testAddPlayer() {
        Player p0 = new Player(1, "messi", "fusball");
        Player p1 = new Player();
        p1.setPlayerId(2);
        p1.setFirstName("Ronaldo");
        p1.setLastName("Blassar");

        p0.setTeamId(22);
        p1.setTeamId(22);


        // Test addPlayer
        try {
            service.addPlayer(p0);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }
        try {
            service.addPlayer(p1);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        // Test getPlayer
        Player newPlayer = service.getPlayer(1);
        // test addPlayer: fails
        try {
            service.addPlayer(newPlayer);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }

        // Test getPlayer: player doesn't exist
        Player nullPlayer = service.getPlayer(-1);
        assertEquals(null, nullPlayer);

        // Test getPlayers
        List<Player> players = service.getPlayers(22);
        assertEquals(2, players.size());
        assertEquals(service.getPlayers(22), players);
    }
}
