package application.logic.api;

public interface Subject<T> {

	public void detach(Observer<T> obs);

	public void attach(Observer<T> obs);

}
