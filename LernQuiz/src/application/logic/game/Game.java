package application.logic.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private List<Player> players;
	private Player currentPlayer;
	
	Game(){
		this.players = new ArrayList<Player>();
		
		//Fix 4 Players
		this.players.add(new Player("blue"));
		this.players.add(new Player("green"));
		this.players.add(new Player("red"));
		this.players.add(new Player("yellow"));
	}
	
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}
	
	public void setNextPlayer(){
		int indexOFCurrentPlayer = this.players.indexOf(this.currentPlayer);
		int newIndex = indexOFCurrentPlayer++;
		if(newIndex > players.size()){
			newIndex = 0;
		}
		this.currentPlayer = this.players.get(newIndex);
	}	
}
