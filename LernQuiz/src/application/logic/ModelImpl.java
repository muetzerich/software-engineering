package application.logic;

import java.util.ArrayList;
import java.util.List;

import application.logic.StateImpl.StateType;
import application.logic.api.Model;
import application.logic.api.Observer;
import application.logic.game.Player;
import application.logic.game.Token;
import application.logic.game.spielzug.SpielzugManager;

public class ModelImpl implements Model {

	private ArrayList<Observer<StateType>> observers = new ArrayList<Observer<StateType>>();
	private APIFactoryImpl factory;
	private StateType currentState;
	private SpielzugManager spielzugManager;

	//Hier ist die Facade

	public ModelImpl(APIFactoryImpl factory) {
		this.factory = factory;

	}

	void start() {
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

	/**
	 * System Operation move Figure
	 * Redirect to SpielzugManager and update current state.
	 */
	public void moveFigure(String figureName){
		StateType newState;
		if(this.currentState == StateType.MOVE_TOKEN || this.currentState == StateType.MOVE_NOT_ALLOWED){
			newState = this.spielzugManager.moveFigure(figureName);
			this.setState(newState);
		} else {
			this.setState(this.currentState);
		}
	}

	public void rollDice() {
		StateType newState;
		if(this.currentState == StateType.THROW_AGAIN 
				|| this.currentState == StateType.THROW_DICE 
				|| this.currentState == StateType.NO_START_MOVE 
				|| this.currentState == StateType.NEW_TOKEN
				|| this.currentState == StateType.MOVED){
			newState = this.spielzugManager.throwDice();
				this.setState(newState);
		} else {
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

	public int getCurrentPips() {
		return this.spielzugManager.getCurrentPips();
	}

	public int numberOfThrowsLeft() {
		return this.spielzugManager.numberOfThrowsLeft();
	}

	public List<Player> getPlayers() {
		return this.spielzugManager.getPlayers();
	}

	public Player getCurrentPlayer() {
		return this.spielzugManager.getCurrentPlayer();
	}
	
	public List<Token> getDrawableTokens(Player player, int dicePips) {
		return this.spielzugManager.getDrawableTokens(player, dicePips);
	}
	
	public Player getLastPlayer() {
		return this.spielzugManager.getLastPlayer();
	}

	public int calculateDestination(application.logic.api.Token token,
			int dicePips) {
		return this.spielzugManager.calculateDestination(token, dicePips);

	}

}
