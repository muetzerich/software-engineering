package application.logic.api;
import java.util.List;
import application.logic.game.Player;
import application.logic.StateImpl.StateType;

public interface Model extends Subject<StateType>{
	public void rollDice();
	public void moveFigure(String input);
	public int getCurrentPips();
	public int numberOfThrowsLeft();
	public List<Player> getPlayers();
	public List<application.logic.game.Token> getDrawableTokens(Player player, int dicePips);
	public Player getCurrentPlayer();
	public Player getLastPlayer();
	public int calculateDestination(application.logic.api.Token token,int dicePips);
}
