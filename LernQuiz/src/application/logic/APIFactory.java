package application.logic;

import application.logic.api.Model;
import application.logic.spielzug.SpielzugManager;

public interface APIFactory {

	public Model getModel(); 
		
	public static APIFactory factory = APIFactoryImpl.makeFactory();

	public SpielzugManager getSpielzugManager();
}
