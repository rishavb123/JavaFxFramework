package demos.controllerdemos.mousecontrollerexample;

import java.util.concurrent.Callable;

import application.App;
import controllers.ArrowKeyController;
import controllers.MouseController;
import controllers.WASDController;
import framework.State;

/**
 * simple game where you can move around and shoot
 * @author Bhagat
 *
 */
public class Main {

	/**
	 * the main method
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		App.begin(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Person p = new Person(0, 0);
				ArrowKeyController controller = new ArrowKeyController(p);
				WASDController controller2 = new WASDController(p);
				MouseController controller3 = new MouseController(p);
				controller.connect();
				controller2.connect();
				controller3.connect();
				State.gameState.add(p);
				return null;
			}
			
		}, null, null, args);
		
	}

}
