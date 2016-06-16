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
		System.out.println("Bitte Würfeln.");
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
	}
	
	public void getOutputNewToken(){

	}

	public void getOutputMoveFigure(){
		System.out.println("Welche Spielfigur willst du bewegen?"); 
		System.out.println("Du kannst folgende Figuren bewegen: "+"[]");
		for (Token token : model.getDrawableTokens(this.model.getCurrentPlayer(),this.model.getCurrentPips())) {
			System.out.println(this.model.getCurrentPlayer().getColor()+token.getIndex()+" --> ");

		}
		System.out.println("Bitte gebe den Namen der Figur ein und bestätige mit Enter");
	}
	
	public void getOutputChooseMoveFigure() {
		System.out.println("Du darfst ziehen.");
		System.out.println("Zum Ziehen bitte 'z' eingeben und mit Enter bestätigen.");
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
	
	public void getOutputMovedFigure(){
		System.out.println("Dein Zug war erfolgreich");
	}

	public void getOutputStatus() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Der Spieler "+ model.getCurrentPlayer().getColor()+" ist am Zug \n");
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
