package application.logic.game.spielzug;
import application.logic.StateImpl.StateType;

public interface SpielzugManager {

	StateType rollDice();
	StateType moveFigure();
}
