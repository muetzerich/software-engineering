package application.logic.game.spielzug;
import application.logic.StateImpl.StateType;
import application.logic.game.Dice;

import java.util.Random;


public class SpielzugManagerImpl implements SpielzugManager {
	
	private Dice dice;
	
	public SpielzugManagerImpl(){
		this.dice = new Dice();
		System.out.println("SpielzugManager was created");
	}

	public StateType rollDice() {
		this.dice.rollDice();
		if (this.getCurrentPips() == 6){
			return StateType.THROWN; //TODO 
		}
		else return StateType.THROW_DICE;
	} 
	
	public StateType moveFigure() {
		return null;
	}

	public int getCurrentPips() {
		return this.dice.getcurrentPips();
	}
}
