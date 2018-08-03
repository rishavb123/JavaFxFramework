/**
 * 
 */
package demos.controllerdemos.arrowcontrollerexample;

import java.util.concurrent.Callable;

import application.App;
import configurations.Constants;
import controllers.ArrowKeyController;
import controllers.WASDController;
import framework.State;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

/**
 * @author Bhagat
 *
 */
public class Main {

	/**
	 * main method
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		App.create(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				MovableText mt = MovableText.centerMovableText("Hello,", 0.2*Constants.height, 50, Constants.width, FontWeight.BOLD, Color.BLACK);
				MovableText mt2 = MovableText.centerMovableText("World!", 0.5*Constants.height, 50, Constants.width, FontWeight.BOLD, Color.BLACK);
				State.gameState.add(mt);
				State.gameState.add(mt2);
				ArrowKeyController controller = new ArrowKeyController(mt);
				controller.connect();
				WASDController controller2 = new WASDController(mt2);
				controller2.connect();
				return null;
			}
			
		}, null, null, args);
	}

}
