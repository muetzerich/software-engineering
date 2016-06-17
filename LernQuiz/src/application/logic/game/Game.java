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
		
		this.players.add(new Player("blue", 0));
		this.players.add(new Player("green", 11));
		this.players.add(new Player("red", 23));
		this.players.add(new Player("yellow", 35));
		
		this.currentPlayer = this.players.get(0);
	}
	
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}
	
	public Player getLastPlayer() {
		return this.lastPlayer;
	}
	
	public void setNextPlayer(){
		int indexOFCurrentPlayer = this.players.indexOf(this.currentPlayer);
		this.lastPlayer =  this.players.get(indexOFCurrentPlayer);
		int newIndex = indexOFCurrentPlayer +1;
		if(newIndex >= players.size()){
			newIndex = 0;
		}
		this.currentPlayer = this.players.get(newIndex);
	}	
	
	public Field getField(){
		return this.field;
	}
	
	public List<Player> getPlayer() {
		return players;
	}
}
