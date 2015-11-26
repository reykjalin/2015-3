package is.ru.honn.game.framework;

/**
 * Created by kristofer on 9/9/15.
 */
public interface Game {
    void setPlayersCount(int playerCount);
    void initializeGame();
    void makePlay(int player);
    boolean endOfGame();
    void printWinner();
    void playOneGame();
}
