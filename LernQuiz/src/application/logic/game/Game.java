package application.logic.game;

import java.util.ArrayList;
import java.util.List;

public class Game{
	
	private List<Player> players;
	private Player currentPlayer;
	private Player lastPlayer;
	private Field field; 
	
	public Game(){
		this.field = new Field();
		this.players = new ArrayList<Player>();
		
		this.players.add(new Player("blau", 0));
		this.players.add(new Player("gr\u00FCn", 11));
		this.players.add(new Player("rot", 23));
		this.players.add(new Player("gelb", 35));
		
		this.currentPlayer = this.players.get(0);
	}
	/**
	 * get current player
	 * @return the current player
	 */
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}
	
	/**
	 * Get the last Player
	 * @return the last player
	 */
	public Player getLastPlayer() {
		return this.lastPlayer;
	}
	
	/**
	 * Change player
	 */
	public void setNextPlayer(){
		int indexOFCurrentPlayer = this.players.indexOf(this.currentPlayer);
		this.lastPlayer =  this.players.get(indexOFCurrentPlayer);
		int newIndex = indexOFCurrentPlayer +1;
		if(newIndex >= players.size()){
			newIndex = 0;
		}
		this.currentPlayer = this.players.get(newIndex);
	}	
	/**
	 * Get Field
	 * @return the Field
	 */
	public Field getField(){
		return this.field;
	}
	
	/**
	 * get all players
	 * @return all players
	 */
	public List<Player> getPlayer() {
		return players;
	}
}
