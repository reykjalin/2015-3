package is.ru.honn.game.framework;

/**
 * Created by kristofer on 9/9/15.
 */
public abstract class AbstractGame implements Game {
    protected int playersCount;

    public void setPlayersCount(int playersCount)
    {
        this.playersCount = playersCount;
    }

    public abstract void initializeGame();
    public abstract void makePlay(int player);
    public abstract boolean endOfGame();
    public abstract void printWinner();

    public final void playOneGame()
    {
        this.playersCount = playersCount;
        initializeGame();
        int j = 0;
        while (!endOfGame())
        {
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }
}
