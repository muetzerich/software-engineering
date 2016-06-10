package application.logic.game;
public class Player {
	
	private static final int TOKEN_STORE_SIZE = 3;
	
	private String color;
	private Token[] tokenStore = new Token[TOKEN_STORE_SIZE];
	
	Player(String color){
		this.color = color;
		initializeTokenStore();
	}
	
	private void initializeTokenStore(){
		for(int i = 0; i <= TOKEN_STORE_SIZE; i++){
			this.addToken(i, new Token(i));
		}
	}
	
	private Token addToken(int index, Token token){
		return this.tokenStore[index] = token;
	}
	
	public Token getToken(int index){
		return this.tokenStore[index];
	}
	
	private String getColor() {
		return this.color;
	}
}
