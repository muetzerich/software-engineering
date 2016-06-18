package application.gui;

import application.logic.api.Model;
import application.logic.api.Player;
import application.logic.api.Token;

public class View {

	Model model;

	public View(Model model){
		this.model = model;
	}
	
	public void getGreeting(){
		System.out.println("--------------------------------------------------------------");
		System.out.println("----------- _                     _____       _     ----------");
		System.out.println("-----------| |                   |  _  |     (_)    ----------");
		System.out.println("-----------| |     ___ _ __ _ __ | | | |_   _ _ ____----------");
		System.out.println("-----------| |    / _ \\ '__| '_ \\| | | | | | | |_  /----------");
		System.out.println("-----------| |___|  __/ |  | | | \\ \\/' / |_| | |/ / ----------");
		System.out.println("-----------\\_____/\\___|_|  |_| |_|\\__/\\_\\__,_|_/___|----------");
		System.out.println("--------------------------------------------------------------");
	}
	

	public void getOutputRollDice(){
		System.out.println("\nBitte W\u00FCrfeln.");
		System.out.println("Zum W\u00FCrfeln bitte 'w' eingeben und mit Enter best\u00E4tigen.");
	}

	public void getOutputThrownDice(){
		System.out.println("Du hast eine "+this.model.getCurrentPips()+" gew\u00FCrfelt.");
	}

	public void getOutputMoveTokenToStartfield(){
		System.out.println("Gl\u00FCckwunsch, du hast eine 6 gew\u00FCrfelt! \nwDeine Spielfigur "
				+this.model.getLastPlayer().getColor()+this.model.getLastPlayer().getLastMovedToken() +" ist nun im Spiel");
	}
	
	public void getOutputRollDiceAgain(){
		System.out.println("Du hast keine 6 gew\u00FCrfelt und darfst noch "+model.numberOfThrowsLeft()+"-mal nachw\u00FCrfeln.");
		System.out.println("--------------------------------------------------------------");
	}
	
	public void getOutputChooseFigure(){
		System.out.println("Welche Spielfigur willst du bewegen?"); 
		System.out.println("Du kannst folgende Figuren bewegen: ");
		for (Token token : model.getDrawableTokens(this.model.getCurrentPlayer(),this.model.getCurrentPips())) {
			System.out.println(this.model.getCurrentPlayer().getColor()+" "+token.getIndex()+" --> " +this.model.calculateDestination(token, this.model.getCurrentPips()));

		}
		System.out.println("Bitte gebe die Nummer der Figur ein und best\u00E4tige mit Enter");
	}
	
	public void getOutputMoveFigure() {
		System.out.println("Du darfst ziehen.");
		System.out.println("Zum Ziehen bitte 'z' eingeben und mit Enter best\u00E4tigen.");
	}

	public void getOutputSorryMessage(){
		System.out.println("Du hast leider 3-mal keine 6 gew\u00FCrfelt.\n");
	}

	public void getOutputInvalidInput(){
		System.out.println("Deine Eingabe war ung\u00FCltig.\nBitte versuche es noch einmal.");
	}
	
	public void getOutputMoveSuccess(){
		System.out.println("Dein Zug war erfolgreich");
	}

	public void getOutputStatus() {
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("----------------Der Spieler "+ model.getCurrentPlayer().getColor()+" ist am Zug-------------------");
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("Status Spielfeld:");
		for (Player player : model.getPlayers()) {
			System.out.println(player.getColor()+"\t"+player.getNumberOfTokenInField()+ " von "+ player.getStoreSize() + " Figuren im Spiel");
			for (Token token : player.getTokensOnField()){
				System.out.println("\tFigur "+token.getIndex()+" steht auf Feld "+token.getIndexOnField());
			}
		}
		System.out.println("--------------------------------------------------------------");
	}
}




                                        
                                        

