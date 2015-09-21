import is.ru.honn.rufan.service.TeamService;
import is.ru.honn.rufan.service.TeamServiceStub;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kristofer on 9/18/15.
 */
public class TestTeamService {
    @Autowired
    TeamService service = new TeamServiceStub();

    @Before
    public void setup() {
        // Empty
    }

    @Test
    public void test() {

    }
}
