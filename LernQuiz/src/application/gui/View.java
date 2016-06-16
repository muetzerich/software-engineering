package application.gui;

import application.logic.api.Model;
import application.logic.api.Player;
import application.logic.api.Token;
//TODO interface

public class View {

	Model model;

	public View(Model model){
		this.model = model;
	}

	public void getOutputRollDice(){
		System.out.println("\nBitte Würfeln.");
		System.out.println("Zum Würfeln bitte 'w' eingeben und mit Enter bestätigen.");
	}

	public void getOutputThrownDice(){
		System.out.println("Du hast eine "+this.model.getCurrentPips()+" gewürfelt.");
	}

	public void getOutputMoveTokenToStartfield(){
		System.out.println("Glückwunsch, du hast eine 6 gewürfelt! Deine Spielfigur "
				+this.model.getLastPlayer().getColor()+this.model.getLastPlayer().getLastMovedToken() +" ist nun im Spiel");
	}
	
	public void getOutputRollDiceAgain(){
		System.out.println("Du hast keine 6 gewürfelt und darfst noch "+model.numberOfThrowsLeft()+"-mal nachwürfeln.");
		System.out.println("--------------------------------------------------------------");
	}
	
	public void getOutputNewToken(){

	}

	public void getOutputMoveFigure(){
		System.out.println("Welche Spielfigur willst du bewegen?"); 
		System.out.println("Du kannst folgende Figuren bewegen: ");
		for (Token token : model.getDrawableTokens(this.model.getCurrentPlayer(),this.model.getCurrentPips())) {
			System.out.println(this.model.getCurrentPlayer().getColor()+token.getIndex()+" --> " +this.model.calculateDestination(token, this.model.getCurrentPips()));

		}
		System.out.println("Bitte gebe den Namen der Figur ein und bestätige mit Enter");
	}
	
	public void getOutputChooseMoveFigure() {
		System.out.println("Du darfst ziehen.");
		System.out.println("Zum Ziehen bitte 'z' eingeben und mit Enter bestätigen.");
	}

	public void getOutputSorryMessage(){
		System.out.println("Du hast leider 3-mal keine 6 gewürfelt.");
		System.out.println("--------------------------------------------------------------");
	}

	public void getOutputInvalidInput(){
		System.out.println("Deine Eingabe war ungültig.\n Bitte versuche es noch einmal.");
	}
	
	public void getOutputMovedFigure(){
		System.out.println("Dein Zug war erfolgreich");
	}

	public void getOutputStatus() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Der Spieler "+ model.getCurrentPlayer().getColor()+" ist am Zug");
		System.out.println("--------------------------------------------------------------");
		System.out.println("Status Spielfeld:");
		for (Player player : model.getPlayers()) {
			System.out.println(player.getColor()+"\t"+player.getNumberOfTokenInField()+ " von "+ player.getStoreSize() + " Figuren im Spiel: ");
			for (Token token : player.getTokensOnField()){
				System.out.println("\t"+player.getColor()+token.getIndex()+" Feld "+token.getIndexOnField()+"\n");
			}
		}
		System.out.println("--------------------------------------------------------------");
	}
}
