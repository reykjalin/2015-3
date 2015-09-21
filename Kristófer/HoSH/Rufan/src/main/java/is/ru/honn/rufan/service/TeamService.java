package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;

import java.util.List;

/**
 * TeamService interface for services concerning RUFan teams
 * @author Kristofer R.
 */
public interface TeamService
{
    int addTeam(int leagueId, Team team) throws ServiceException;
    List<Team> getTeams(int leagueId);
}
