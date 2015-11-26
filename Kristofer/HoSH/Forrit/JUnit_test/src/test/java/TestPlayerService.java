import is.ru.honn.domain.Player;
import is.ru.honn.service.PlayerService;
import is.ru.honn.service.ServiceException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service.xml")

public class TestPlayerService extends TestCase
{
    Logger log = Logger.getLogger(TestPlayerService.class.getName());

    @Autowired
    private PlayerService service;

    @Before
    public void Setup()
    {
    }

    @Test
    public void testPlayer()
    {
        Player player0 = new Player(0, "messi", "Messi");
        Player player1 = new Player(1, "ronaldo", "Ronaldo");

        try {
            service.addPlayer(player0);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        int pos = 0;
        try {
            pos = service.addPlayer(player1);
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        assertEquals(2, pos+1);

        Player playerNew = service.getPlayer(1);
        assertSame(playerNew, player1);

        try
        {
            service.addPlayer(player1);
        }
        catch (ServiceException s)
        {
            assertSame(ServiceException.class, s.getClass());
        }
    }
}