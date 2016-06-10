package application.logic;

import java.util.ArrayList;

import application.logic.StateImpl.StateType;
import application.logic.api.Model;
import application.logic.api.Observer;
import application.logic.api.State;
import application.logic.spielzug.SpielzugManagerImpl;

public  class ModelImpl implements Model {
	
	private ArrayList<Observer<StateType>> observers = new ArrayList<Observer<StateType>>();
	private APIFactoryImpl factory;
	private StateType currentState;
	SpielzugManagerImpl spielzugManager;


	public int getGewuerfelteZahl() {
		return this.spielzugManager.getGewuerfelteZahl();
	}
	
	ModelImpl(APIFactoryImpl factory) {
		this.factory = factory;
	}

	public void detach(Observer<StateType> obs) {
		this.observers.remove(obs);
	}

	public void attach(Observer<StateType> obs) {
		this.observers.add(obs);
		obs.update(this.currentState);
	}

	public void rollDice() {
		this.spielzugManager.rollDice();
	}
	
	public void moveFigure(){
		this.spielzugManager.moveFigure();
	}
}
