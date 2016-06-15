package application.logic;

import application.logic.api.Model;
import application.logic.game.Game;
import application.logic.game.spielzug.SpielzugManager;
import application.logic.game.spielzug.SpielzugManagerImpl;


public class APIFactoryImpl implements APIFactory {

	private static APIFactoryImpl theFactory;
	private ModelImpl modelImpl;
	private SpielzugManagerImpl spielzugManagerImpl;
	private Game game;
	
	private APIFactoryImpl() {};

	public Model getModel() {
		return this.getModelImpl();
	}

	public SpielzugManager getSpielzugManager() {
		return this.getSpielzugManagerImpl();

	}

	private ModelImpl getModelImpl() {
		if (this.modelImpl == null) {
			this.modelImpl = new ModelImpl(this);
			this.modelImpl.start();
		}
		return this.modelImpl;
	}

	static APIFactory makeFactory() {
		if (APIFactoryImpl.theFactory == null) {
			APIFactoryImpl.theFactory = new APIFactoryImpl();
		}
		return APIFactoryImpl.theFactory;
	}

	private SpielzugManager getSpielzugManagerImpl() {
		if (this.spielzugManagerImpl == null) {
			this.game = new Game();
			this.spielzugManagerImpl = new SpielzugManagerImpl(this.game);
		}
		return this.spielzugManagerImpl;
	}
}
