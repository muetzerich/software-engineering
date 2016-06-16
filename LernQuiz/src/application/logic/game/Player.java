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

	public Token getToken(int index){
		return this.tokenStore[index];
	}
	
	public Token[] getAllTokens(){
		return this.tokenStore;
	}
	
	public int getNumberOfTokenInStore(){
		int counter = 0;
		for (int i = 0; i < this.tokenStore.length; i++){
			if (this.tokenStore[i].isInGame() == false ){
				counter ++;
			}
		}
		return counter;
	}
	
	public int getNumberOfTokenInField(){
		int counter = 0;
		for (int i = 0; i < this.tokenStore.length; i++){
			if (this.tokenStore[i].isInGame() == true ){
				counter ++;
			}
		}
		return counter;
	}
	
	public void setTokenOnStartfield(){
		for(int i = 0; i < TOKEN_STORE_SIZE; i++){
			if(!this.tokenStore[i].isInGame()){
				this.lastMovedToken = this.tokenStore[i].setIsInGame(this.startField);
				return;
			}
		}
	}
	
	public int getLastMovedToken() {
		return lastMovedToken;
	}

	public String getColor() {
		return this.color;
	}

	public int getStartfield(){
		return this.startField;
	}
	
	public int getStoreSize() {
		return this.TOKEN_STORE_SIZE;
	}
	
	public List<Token> getTokensOnField() {
		List<Token> tokensOnField = new ArrayList<Token>();
		for (int i = 0; i < this.tokenStore.length; i ++){
			if (this.tokenStore[i].isInGame() == true ){
				tokensOnField.add(this.tokenStore[i]);
			}
		}
		return tokensOnField;
	}
}
