package application.logic;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import application.logic.StateImpl.StateType;
import application.logic.api.Model;
import application.logic.api.Observer;
import application.logic.game.spielzug.SpielzugManager;

public class ModelImpl implements Model {

	private ArrayList<Observer<StateType>> observers = new ArrayList<Observer<StateType>>();
	private APIFactoryImpl factory;
	private StateType currentState;
	SpielzugManager spielzugManager;

	//Hier ist die Facade

	public ModelImpl(APIFactoryImpl factory) {
		this.factory = factory;
		
	}
	
	void start() {
		System.out.print("start model");
		this.currentState = StateType.THROW_DICE;
		this.spielzugManager = this.factory.getSpielzugManager();
	}
	
	public int getGewuerfelteZahl() {
		return this.spielzugManager.getCurrentPips();
	}
	
	public void detach(Observer<StateType> obs) {
		this.observers.remove(obs);
	}

	public void attach(Observer<StateType> obs) {
		this.observers.add(obs);
		obs.update(this.currentState);
	}


	public void rollDice() {
		if(this.currentState == StateType.THROW_DICE){
			StateType newState = this.spielzugManager.rollDice();
			this.setState(newState);
		} else {
			//Falls Fehleingabe dann setze erneut current State
			this.setState(this.currentState);
		}
	}

	/**
	 * System Operation move Figure
	 * Redirect to SpielzugManager and update current state.
	 */
	public void moveFigure(){
		if(this.currentState == StateType.MOVE_TOKEN){
			StateType newState = this.spielzugManager.moveFigure();
			this.setState(newState);
		} else {
			//Falls Fehleingabe dann setze erneut current State
			this.setState(this.currentState);
		}
	}

	/**
	 * Set the current State and notify all observers.
	 * @param state current state
	 */
	public void setState(StateType state) {
		this.currentState = state;
		for (Observer<StateType> obs: this.observers)
			obs.update(this.currentState);
	}

	public StateType getCurrentState() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCurrentPips() {
		return this.spielzugManager.getCurrentPips();
	}


}
