package application.logic;

import application.logic.api.Model;
import application.logic.ModelImpl;
import application.logic.spielzug.SpielzugManager;
import application.logic.spielzug.SpielzugManagerImpl;

public class APIFactoryImpl implements APIFactory {

	private static APIFactoryImpl theFactory;
	private ModelImpl model;
	private SpielzugManagerImpl spielzugManager;

	private APIFactoryImpl() {
	}

	public Model getModel() {
		if (this.model == null) {
			 this.model = new ModelImpl(this);
		}
		return this.model;
	}

	public static APIFactory makeFactory() {
		if (theFactory == null) {
			theFactory = new APIFactoryImpl();
		}
		return theFactory;
	}

	public SpielzugManager getSpielzugManager() {
		if (this.spielzugManager == null) {
			 this.spielzugManager = new SpielzugManagerImpl();
		}
		return this.spielzugManager;
	}
}
