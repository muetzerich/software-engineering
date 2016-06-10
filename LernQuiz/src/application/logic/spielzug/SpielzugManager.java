package application.logic.spielzug;
import application.logic.StateImpl.StateType;

public interface SpielzugManager {
	StateType rollDice();
	StateType moveFigure();
}
