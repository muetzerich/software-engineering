package application.logic.game;

import java.util.ArrayList;
import java.util.List;

public class Field {
	
	public static final int FIELD_SIZE = 48;
		
	private Token[] field = new Token[FIELD_SIZE];
	
	/**
	 * 
	 * @param token the actual player token
	 * @param dest destination on field
	 * @return true if token moved to field else false
	 */ 
	public boolean moveTokenOnField(Token playerToken, int dicePips){
		int dest = dicePips + playerToken.getIndexOnField();
		if(dest < 0 || this.field[dest] != null){
			return false;
		} else if(dest > FIELD_SIZE){
			int newDest = dest-FIELD_SIZE;
			playerToken.setIndexOnField(newDest);
			this.field[newDest] = playerToken;
			return true;
		}else {
			playerToken.setIndexOnField(dest);
			this.field[dest] = playerToken;
			return true;
		}
	}
	
	public void setPlayerOnStartfield(Player player,Token playerToken) {
		this.field[player.getStartfield()] = playerToken;
	}
	
	public boolean isStartFieldFree(Player player) {
		boolean isFree = false;
		if(this.field[player.getStartfield()]==null){
			isFree = true;
		} 
		return isFree;
	}

	public boolean isFreeDestinationsForPlayer(Player player, int dicePips) {
		boolean isPossible = false;
		for (Token token : player.getTokensOnField()) {
			int destination = token.getIndexOnField() + dicePips;
			if(destination > FIELD_SIZE){
				destination = destination-FIELD_SIZE;
			}
			if(this.field[destination]==null){
				isPossible = true;
			} 
		}
		return isPossible;
	}
	
	public List<Token> getDrawableTokens(Player player,int dicePips) {
		List<Token> drawableTokens = new ArrayList<Token>();
		for (Token token: player.getTokensOnField()){
			int destination = token.getIndexOnField() + dicePips;
			if(this.field[destination]==null){
				drawableTokens.add(token);
			} 
		}
		return drawableTokens;
	}
	
	public int calculateDestination(application.logic.api.Token token,int dicePips) {
		int destination = token.getIndexOnField() + dicePips;
		if(destination > FIELD_SIZE){
			destination= destination-FIELD_SIZE;
		}
		return destination;
	}
}





