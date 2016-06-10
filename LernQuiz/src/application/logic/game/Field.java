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
	boolean moveTokenOnField(Token playerToken, int dest){
		if(dest > FIELD_SIZE || dest < 0 || this.field[dest] != null){
			return false;
		} else {
			this.field[dest] = playerToken;
			return true;
		}
	}
	
	boolean isPossible(int field){
		return this.field[field] != null;
	}
}





