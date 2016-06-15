package application;

import application.gui.View;
import application.gui.Controller;
import application.logic.APIFactory;
import application.logic.api.Model;

public class Main {
	public static void main(String[] args) {
		APIFactory api = APIFactory.factory;
		Model model = api.getModel();
		View view = new View(model);
		Controller controller = new Controller(model, view);
		controller.run();
	}
}
