package application.gui;

import application.logic.api.Observer;
import application.logic.api.State;
import application.logic.*;
import application.logic.api.*;
import application.logic.StateImpl.StateType;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

class Controller implements Observer<StateType>{

	private ModelImpl model;

	private Semaphore sem = new Semaphore(0);
	private Map<String, Integer> call = new HashMap<String, Integer>();


	public Controller(ModelImpl m) {
		this.call.put("w", 1);
		this.call.put("z", 2);
		this.call.put("f", 3);
		this.model = m;
		this.model.attach(this);
	}
	;

	private void getInput() {
		String str = new String();
		while (true) {		
			System.out.println("bitte Aktion eingeben ( wuerfeln -w , ziehen - z, fertig - f):");
			try{
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				str = in.readLine();
			}
			catch(IOException e){}
			int i = (this.call.get(str) != null ? this.call.get(str): 0);
			switch (i) {
			case 1: {
				new Thread(){
					public void run(){
						System.out.println("Thread: " + getName() + " running");
						model.rollDice();
					}
				}.start();	
			};
			break;

			default:
				this.update(StateType.FEHLER);
				break;
			}

			try {
				sem.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public void update(StateType state) 
	{  
		System.out.println("Update:  state changed to : " + state);
		if (state == StateType.WUERFELN) {
			System.out.println("Zustand: Wuerfeln");
			System.out.println("gewuerfelt: " +  model.getGewuerfelteZahl());
		}

		if (state == StateType.FEHLER) {
			System.out.println("Zum Zustand passende Aktion eingeben!");
		}
		sem.release();

	}
}
