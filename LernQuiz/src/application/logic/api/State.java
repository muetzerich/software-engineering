package application.logic.api;

import application.logic.StateImpl.StateType;

public interface State {
	
	public StateType getState();
		
	public void setState(StateType state);
}
