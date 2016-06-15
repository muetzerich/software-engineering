package application.logic.game.spielzug;
import java.util.List;

import application.logic.StateImpl.StateType;
import application.logic.game.Player;

public interface SpielzugManager {
	StateType throwDice();
	StateType moveFigure();
	int getCurrentPips();
	int numberOfThrowsLeft();
	List<Player> getPlayers();
	Player getCurrentPlayer();
}
