package application.logic;

import application.logic.api.State;
public class StateImpl implements State {

	/**
	 * State Types
	 */
	public enum StateType {
		THROW_DICE, THROWN, THROW_AGAIN, NEW_TOKEN, MOVE_NOT_ALLOWED, MOVE_TOKEN,NO_START_MOVE, ERROR
	}
}


