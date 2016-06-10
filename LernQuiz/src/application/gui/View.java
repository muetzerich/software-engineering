package application.gui;

import java.util.concurrent.Semaphore;

import application.logic.StateImpl.StateType;
import application.logic.api.Observer;

public class View implements Observer<StateType> {
	
	private Controller controller;
	private Semaphore sem = new Semaphore(0);
	
	public View(Controller controller){
		
	}

	public void update(StateType state) {
		// TODO Auto-generated method stub
		
	}
}
