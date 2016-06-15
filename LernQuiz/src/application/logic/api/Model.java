package application.logic.api;
import application.logic.StateImpl.StateType;

public interface Model extends Subject<StateType>{
	
	public StateType getCurrentState();
	public int getCurrentPips();

}
