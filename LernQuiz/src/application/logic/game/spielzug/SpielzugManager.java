package application.logic.game.spielzug;
import java.util.List;

import application.logic.StateImpl.StateType;
import application.logic.game.Player;
import application.logic.game.Token;

public interface SpielzugManager {
	StateType throwDice();
	StateType moveFigure(String input);
	int getCurrentPips();
	int numberOfThrowsLeft();
	List<Player> getPlayers();
	List<Token> getDrawableTokens(Player player, int dicePips);
	Player getCurrentPlayer();
	Player getLastPlayer();
}
