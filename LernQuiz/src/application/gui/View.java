package application.gui;

import application.logic.api.Model;

public class View {

	Model model;

	public View(Model model){
		this.model = model;
	}

	public void getOutputRollDice(){
		System.out.println("Bitte Würfeln.");
		System.out.println("Zum Würfeln bitte w eingeben.");
	}
	
	public void getOutputThrownDice(){
		System.out.println("Du hast eine"+this.model.getCurrentPips()+"gewürfelt.");
		System.out.println("Zum Würfeln bitte w eingeben.");
	}
	

	public void getOutputStatus(){
		System.out.println("Status");
	}

	public void getOutputMoveToken(){
		System.out.println("Move Token");
	}

	public void getOutputRollDiceAgain(){

		//Konsolenausgabe hier
	}

	public void getOutputNewToken(){

		//Konsolenausgabe hier
	}

	public void getOutputInvalidInput(){

		//Konsolenausgabe hier
	}

	public void getOutputMoveImpossible(){

		//Konsolenausgabe hier
	}
}
