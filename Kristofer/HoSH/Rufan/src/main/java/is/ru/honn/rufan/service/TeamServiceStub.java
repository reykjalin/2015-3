package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.League;
import is.ru.honn.rufan.domain.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kristofer on 9/17/15.
 */
public class TeamServiceStub implements TeamService {
    List<League> leagues = new ArrayList<League>();

    /**
     * Adds Team object to League object with the right leagueId.
     * @param leagueId: ID of league
     * @param team: Team to add
     * @return Index of new team
     * @throws ServiceException
     */
    public int addTeam(int leagueId, Team team) throws ServiceException {
        for(League l : leagues) {
            if(l.getLeagueId() == leagueId) {
                for(Team t : l.getSeason().getTeams()) {
                    if (t.getTeamId() == team.getTeamId()) {
                        String msg = "Team '" + team.getDisplayName() + "' already exists.";
                        throw new ServiceException(msg);
                    }
                }
                l.getSeason().getTeams().add(team);
                return l.getSeason().getTeams().size() - 1;
            }
        }
        String msg = "League with leagueId '" + leagueId + "' does not exist.";
        throw new ServiceException(msg);
    }

    /**
     * TODO: Implement. Skila öllum liðum?
     * @param leagueId: Id of league
     * @return
     */
    public List<Team> getTeams(int leagueId) {
        for(League l : leagues) {
            if(l.getLeagueId() == leagueId) {
                return l.getSeason().getTeams();
            }
        }
        return null;
    }
}
