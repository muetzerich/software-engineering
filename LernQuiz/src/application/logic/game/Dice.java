package application.logic.game;

import java.util.Random;

public class Dice {
	private Random rand = new Random();
	private int currentPips;

	public int rollDice(){
		this.currentPips = rand.nextInt(6)+1;
		return currentPips;
	}
	
	public int getcurrentPips() {
		return this.currentPips;
	}
}
