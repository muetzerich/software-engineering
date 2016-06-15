package application.logic.api;
public interface Observer<T> {
	
	public void update(T state);
}