package application.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import application.logic.StateImpl.StateType;
import application.logic.api.Model;
import application.logic.api.Observer;

public class Controller implements Observer<StateType>{

	private Model model;
	private View view;

	private Semaphore sem = new Semaphore(0);
	private Map<String, Integer> call = new HashMap<String, Integer>();

	public Controller(Model model, View view) {
		this.call.put("w", 1);
		this.call.put("z", 2);
		this.model = model;
		this.view = view;
	}

	private void getInput() {
		String str = new String();
		while (true) {	
			try {
				sem.acquire();
				this.call();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void call(){
		String str = new String();
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
					//System.out.println("Thread: " + getName() + " running");
					model.rollDice();
				}
			}.start();	
		};
		break;
		case 2: {
			new Thread(){
				public void run(){
					//System.out.println("Thread: " + getName() + " running");
					String input = new String();
					view.getOutputMoveFigure();
					try{
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						input = in.readLine();
					}
					catch(IOException e){}
					model.moveFigure(input);
				}
			}.start();	
		};
		break;
		default:
			this.update(StateType.ERROR);
			break;
		}
	}

	public void run(){
		this.model.attach(this);
		this.getInput();
	}

	/**
	 * Update output on state change
	 * @param state state
	 */
	public void update(StateType state) {  
		System.out.println("Update:  state changed to : " + state);
		switch(state){
		case THROW_DICE:
			view.getOutputStatus();
			view.getOutputRollDice();
			break;
		case THROW_AGAIN:
			view.getOutputThrownDice();
			view.getOutputRollDiceAgain();
			view.getOutputRollDice();
			break;
		case NO_START_MOVE:
			view.getOutputSorryMessage();
			view.getOutputStatus();
			view.getOutputRollDice();
			break;
		case NEW_TOKEN:
			view.getOutputMoveTokenToStartfield();
			view.getOutputStatus();
			view.getOutputRollDice();
			break;
		case MOVE_NOT_ALLOWED:
			break;
		case MOVE_TOKEN:
			view.getOutputChooseMoveFigure();
			break;
		case MOVED:
			view.getOutputMovedFigure();
			view.getOutputStatus();
			view.getOutputRollDice();
			break;
		default:
			view.getOutputInvalidInput();
			view.getOutputStatus();
			view.getOutputRollDice();
			break;
		}
		sem.release();

	}
}
