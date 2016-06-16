package application.logic.game;
public class Token implements application.logic.api.Token{
	private int indexInStore;
	private boolean isInGame = false;
	private int indexOnField = 0;
	
	Token(int index){
		this.indexInStore = index; 
	}
	
	public int getIndex(){
		return this.indexInStore;
	}
	
	public boolean isInGame(){
		return this.isInGame;
	}
	
	public int setIsInGame(int startfield){
		this.isInGame = true;
		this.indexOnField = startfield;
		return this.indexInStore;
	}

	public int getIndexOnField() {
		return indexOnField;
	}

	public void setIndexOnField(int indexOnField) {
		this.indexOnField = indexOnField;
	}
}
