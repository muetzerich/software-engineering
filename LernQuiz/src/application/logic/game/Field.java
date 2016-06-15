package application.logic.game;

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
		//TODO Fall wenn größer Field Size
		if(dest > FIELD_SIZE || dest < 0 || this.field[dest] != null){
			return false;
		} else {
			playerToken.setIndexOnField(dest);
			this.field[dest] = playerToken;
			return true;
		}
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
			if(this.field[destination]==null){
				isPossible = true;
			} 
		}
		return isPossible;
	}
}





