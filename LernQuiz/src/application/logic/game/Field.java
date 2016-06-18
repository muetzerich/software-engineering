package application.logic.game;

import java.util.ArrayList;
import java.util.List;
/**
 */
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
			this.field[playerToken.getIndexOnField()] = null;
			int newDest = dest-FIELD_SIZE;
			playerToken.setIndexOnField(newDest);
			this.field[newDest] = playerToken;
			return true;
		}else {
			this.field[playerToken.getIndexOnField()] = null;
			playerToken.setIndexOnField(dest);
			this.field[dest] = playerToken;
			return true;
		}
	}
	
	/**
	 * Set player on start field
	 * @param player current player
	 * @param playerToken player token
	 */
	public void setPlayerOnStartfield(Player player,Token playerToken) {
		this.field[player.getStartfield()] = playerToken;
	}
	
	/**
	 * Check if start field is free
	 * @param player a player
	 * @return true if starfield is free
	 */
	public boolean isStartFieldFree(Player player) {
		boolean isFree = false;
		if(this.field[player.getStartfield()]==null){
			isFree = true;
		} 
		return isFree;
	}

	/**
	 * Check if there are free destination fields for a player
	 * @param player a player
	 * @param dicePips dice pips
	 * @return true if free destinations fields
	 */
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
	
	/**
	 * Get all drawable Tokens
	 * @param player a player
	 * @param dicePips dice pips
	 * @retur nall drawable Tokens
	 */
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
	/**
	 * Calculate destination field
	 * @param token a Token
	 * @param dicePips the dice pips
	 * @return the calculated destination
	 */
	public int calculateDestination(application.logic.api.Token token,int dicePips) {
		int destination = token.getIndexOnField() + dicePips;
		if(destination > FIELD_SIZE){
			destination= destination-FIELD_SIZE;
		}
		return destination;
	}
}





