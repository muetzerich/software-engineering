
package application.logic.game.spielzug;
import java.util.List;

import application.logic.StateImpl.StateType;
import application.logic.game.Player;
import application.logic.game.Token;

public interface SpielzugManager {
	int getCurrentPips();
	int numberOfThrowsLeft();
	int calculateDestination(application.logic.api.Token token,int dicePips);
	
	StateType moveFigure(String input);
	List<Player> getPlayers();
	public StateType throwDice();
	List<Token> getDrawableTokens(Player player, int dicePips);
	Player getCurrentPlayer();
	Player getLastPlayer();
}

