package application.logic.game.spielzug;
import java.util.List;

import application.logic.StateImpl.StateType;
import application.logic.game.Dice;
import application.logic.game.Game;
import application.logic.game.Player;
import application.logic.game.Token;

public class SpielzugManagerImpl implements SpielzugManager {

	private Dice dice;
	private Game game;
	private Player currentPlayer;

	public static int ALLOWED_NUMBER_OF_THROWS = 3;

	private int numberOfThrows = 0;

	public SpielzugManagerImpl(Game game){
		this.game = game;
		this.dice = new Dice();
	}

	public StateType throwDice() {
		this.currentPlayer = this.game.getCurrentPlayer();
		this.dice.rollDice();
		this.numberOfThrows++;
		return this.diceIsThrown();

	} 

	private StateType diceIsThrown(){
		this.currentPlayer = this.game.getCurrentPlayer();
		if(this.currentPlayer.getNumberOfTokenInStore() == 3 
				&& this.numberOfThrows <= 2 && this.getCurrentPips() != 6){
			return StateType.THROW_AGAIN;	
		} else if(this.currentPlayer.getNumberOfTokenInStore() == 3 
				&& this.numberOfThrows == 3 && this.getCurrentPips() != 6){
			this.changePlayer();
			return StateType.NO_START_MOVE;	
		} else if (this.getCurrentPips() == 6 && this.currentPlayer.getNumberOfTokenInStore()>0 
				&& this.game.getField().isStartFieldFree(currentPlayer)){
			this.currentPlayer.setTokenOnStartfield();
			this.game.getField().setPlayerOnStartfield(currentPlayer, currentPlayer.getToken(currentPlayer.getLastMovedToken()));
			this.changePlayer();
			return StateType.NEW_TOKEN;
		} else if (this.currentPlayer.getNumberOfTokenInStore()<3 
				&& this.game.getField().isFreeDestinationsForPlayer(this.currentPlayer,this.dice.getCurrentPips())){
			return StateType.MOVE_TOKEN;
		}else if (this.currentPlayer.getNumberOfTokenInStore()<3 
				&& !this.game.getField().isFreeDestinationsForPlayer(this.currentPlayer,this.dice.getCurrentPips())){
			this.changePlayer();
			return StateType.MOVE_NOT_ALLOWED; 
		}else {
			return StateType.THROW_DICE;
		}
	}

	private void changePlayer(){
		this.game.setNextPlayer();
		this.numberOfThrows = 0;
	}

	public StateType moveFigure(String input) {
		int parsedInput = 0;
		try{
			parsedInput = Integer.parseInt(input);
		}
		catch(NumberFormatException e){
			return StateType.ERROR_MOVE;
		}
		if(this.checkInput(parsedInput)){
			this.game.getField().moveTokenOnField(currentPlayer.getToken(parsedInput),this.getCurrentPips());
			this.changePlayer();
			return StateType.MOVED;
		} else {
			return StateType.ERROR_MOVE;
		}
	}

	private boolean checkInput(int input){
		boolean isValid = false;
		for(Token token: this.game.getField().getDrawableTokens(this.currentPlayer, this.getCurrentPips())){
			if(token.getIndex() == input){
				isValid = true;
			}
		}
		return isValid;
	}

	public int getCurrentPips() {
		return this.dice.getCurrentPips();
	}

	public List<Player> getPlayers() {
		return this.game.getPlayer();
	}

	public Player getCurrentPlayer() {
		return this.game.getCurrentPlayer();
	}

	public Player getLastPlayer() {
		return this.game.getLastPlayer();
	}
	
	public List<Token> getDrawableTokens(Player player, int dicePips) {
		return this.game.getField().getDrawableTokens(player, dicePips);
	}
	
	public int calculateDestination(application.logic.api.Token token,int dicePips) {
		return this.game.getField().calculateDestination(token, dicePips);
	}

	public int numberOfThrowsLeft() {
		return ALLOWED_NUMBER_OF_THROWS-this.numberOfThrows;
	}
}
