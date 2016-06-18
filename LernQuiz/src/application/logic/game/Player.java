package application.logic.game;

import java.util.ArrayList;
import java.util.List;

public class Player implements application.logic.api.Player {

	private static final int TOKEN_STORE_SIZE = 3;

	private String color;
	private int startField;
	private Token[] tokenStore = new Token[TOKEN_STORE_SIZE];
	private int lastMovedToken;

	Player(String color, int startfield){
		this.color = color;
		this.startField = startfield;
		initializeTokenStore();
	}

	private void initializeTokenStore(){
		for(int i = 0; i < TOKEN_STORE_SIZE; i++){
			this.addToken(i, new Token(i));
		}
	}

	private Token addToken(int index, Token token){
		return this.tokenStore[index] = token;
	}

	/**
	 * Get Token 
	 * @param index token position 
	 * @return a token 
	 */
	public Token getToken(int index){
		return this.tokenStore[index];
	}

	/**
	 * get all Tokens
	 * @return all Tokens
	 */
	public Token[] getAllTokens(){
		return this.tokenStore;
	}

	/**
	 * Get number of Tokens in store
	 * @return number of token in store
	 */
	public int getNumberOfTokenInStore(){
		int counter = 0;
		for (int i = 0; i < this.tokenStore.length; i++){
			if (this.tokenStore[i].isInGame() == false ){
				counter ++;
			}
		}
		return counter;
	}

	/**
	 * Get number of Tokens on Field
	 */
	public int getNumberOfTokenInField(){
		int counter = 0;
		for (int i = 0; i < this.tokenStore.length; i++){
			if (this.tokenStore[i].isInGame() == true ){
				counter ++;
			}
		}
		return counter;
	}

	/**
	 * Set Token on start field
	 */
	public void setTokenOnStartfield(){
		for(int i = 0; i < TOKEN_STORE_SIZE; i++){
			if(!this.tokenStore[i].isInGame()){
				this.lastMovedToken = this.tokenStore[i].setIsInGame(this.startField);
				return;
			}
		}
	}
	/**
	 * Get all Tokens on Field
	 * @return all tokens on field
	 */
	public List<Token> getTokensOnField() {
		List<Token> tokensOnField = new ArrayList<Token>();
		for (int i = 0; i < this.tokenStore.length; i ++){
			if (this.tokenStore[i].isInGame() == true ){
				tokensOnField.add(this.tokenStore[i]);
			}
		}
		return tokensOnField;
	}


	public int getLastMovedToken() {
		return lastMovedToken;
	}

	public String getColor() {
		return this.color;
	}

	public int getStartfield() {
		return this.startField;
	}

	public int getStoreSize() {
		return Player.TOKEN_STORE_SIZE;
	}


}
