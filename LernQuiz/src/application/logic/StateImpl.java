package application.logic;

import application.logic.api.State;
public class StateImpl implements State {
	
	public enum StateType {
	    WUERFELN, FEHLER
	  }
	
	StateType state = StateType.FEHLER;

	  
	public StateType getState() {
		return this.state;
	}

	public void setState(StateType state) {
		this.state = state;
	}
}


