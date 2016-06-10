package application.logic.api;
public interface Observer<T> {
	
	void update(T state);
}