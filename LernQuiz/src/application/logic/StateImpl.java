package application.logic;

import application.logic.api.State;
public class StateImpl implements State {
	
	/**
	 * State Types
	 */
	public enum StateType {
	    THROW_DICE, THROWN, NEW_TOKEN, MOVE_NOT_ALLOWED, MOVE_TOKEN, ERROR
	  }
	
/*	*//**
	 * Get current State
	 * @return current State
	 *//*
	public StateType getState() {
		return this.state;
	}
	
	*//**
	 * Set current State
	 * @param new State
	 *//*
	public void setState(StateType state) {
		this.state = state;
	}
*/}


