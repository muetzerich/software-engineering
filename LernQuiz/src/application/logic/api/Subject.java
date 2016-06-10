package application.logic.api;

public interface Subject<T> {
	public void rollDice();

	void detach(Observer<T> obs);

	void attach(Observer<T> obs);

}
