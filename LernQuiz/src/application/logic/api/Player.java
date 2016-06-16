package application.logic.api;

import java.util.List;

import application.logic.game.Token;

public interface Player {
	public List<Token> getTokensOnField();
	public int getNumberOfTokenInStore();
	public int getNumberOfTokenInField();
	public String getColor();
	public int getStoreSize();
	public int getLastMovedToken();
}
