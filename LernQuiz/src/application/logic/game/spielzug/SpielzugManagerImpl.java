package application.logic.game.spielzug;
import application.logic.StateImpl.StateType;
import java.util.Random;


public class SpielzugManagerImpl implements SpielzugManager {
	
	private Random rand = new Random();
	private int gewuerfelteZahl;
	

	public int getGewuerfelteZahl() {
		return gewuerfelteZahl;
	}
	

	public StateType rollDice() {
		this.gewuerfelteZahl = rand.nextInt(6)+1;
		if (gewuerfelteZahl == 6){
			return null; //TODO 
		}
		else return StateType.WUERFELN;
	} 
	
	public StateType moveFigure() {
		return null;
	}
	
	
}
