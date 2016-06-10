package application.gui;

import application.logic.StateImpl.StateType;
import application.logic.api.Observer;

public class View implements Observer<StateType> {
	
	private Controller controller;
	
	public View(Controller controller){
		
	}

	public void update(StateType state) {
		// TODO Auto-generated method stub
		
	}
}
