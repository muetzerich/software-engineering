package application.logic.game;

import java.util.ArrayList;
import java.util.List;

public class Game{
	
	private List<Player> players;
	private Player currentPlayer;
	private Field field; 
	
	public Game(){
		this.field = new Field();
		this.players = new ArrayList<Player>();
		//Fix 4 Players
		this.players.add(new Player("blue", 0));
		this.players.add(new Player("green", 12));
		this.players.add(new Player("red", 24));
		this.players.add(new Player("yellow", 36));
		
		this.currentPlayer = this.players.get(0);
	}
	
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}
	
	public void setNextPlayer(){
		int indexOFCurrentPlayer = this.players.indexOf(this.currentPlayer);
		System.out.print("index of: "+indexOFCurrentPlayer);
		int newIndex = indexOFCurrentPlayer +1;
		if(newIndex >= players.size()){
			newIndex = 0;
		}
		System.out.print("index new: "+newIndex);
		this.currentPlayer = this.players.get(newIndex);
	}	
	
	public Field getField(){
		return this.field;
	}
	
	public List<Player> getPlayer() {
		return players;
	}
}
