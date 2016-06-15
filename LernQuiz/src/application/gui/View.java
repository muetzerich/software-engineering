package application.gui;

import application.logic.api.Model;
import application.logic.api.Player;
import application.logic.api.Token;
import application.logic.game.Game;

public class View {

	Model model;
	Game game;

	public View(Model model){
		this.model = model;
	}

	public void getOutputRollDice(){
		System.out.println("Bitte Würfeln.");
		System.out.println("Zum Würfeln bitte 'w' eingeben und mit Enter bestätigen.");
	}
	
	public void getOutputThrownDice(){
		System.out.println("Du hast eine "+this.model.getCurrentPips()+" gewürfelt.");
	}

	public void getOutputMoveToken(){
		System.out.println("Glückwunsch, du hast eine 6 gewürfelt! Deine Spielfigur "+"[]" +" ist nun im Spiel");
	}

	public void getOutputRollDiceAgain(){
		System.out.println("Du hast keine 6 gewürfelt und darfst noch "+model.numberOfThrowsLeft()+"-mal nachwürfeln.");
	}
	public void getOutputNewToken(){
	
	}
	
	public void getOutputMoveFigure(){
		System.out.println("Welche Spielfigur willst du bewegen?"); 
		System.out.println("Du kannst folgende Figuren bewegen: "+"[]");
		System.out.println("Bitte gebe den Namen der Figur ein und bestätige mit Enter");
	}
	
	public void getOutputSorryMessage(){
		System.out.println("Du hast leider 3-mal keine 6 gewürfelt.");
	}

	public void getOutputInvalidInput(){
		System.out.println("Deine Eingabe war ungültig. Bitte versuche es noch einmal.");
	}

	public void getOutputMoveImpossible(){

		//Konsolenausgabe hier
	}
	
	public void getOutputStatus() {
		System.out.println("Aktueller Spieler ist: "+ model.getCurrentPlayer().getColor());
		for (Player player : model.getPlayers()) {
			System.out.println(player.getColor());
			for (Token token : player.getTokensOnField()){
				System.out.println(token.getIndexOnField());
			}
		}
	}
}
