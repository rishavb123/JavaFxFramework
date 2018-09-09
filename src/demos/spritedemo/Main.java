package demos.spritedemo;

import java.util.concurrent.Callable;

import application.App;
import configurations.Constants;
import controllers.ArrowKeyController;
import framework.State;

/**
 * main class for running the sprite sheet demo
 * @author Bhagat
 *
 */
public class Main {
	

	/**
	 * main method
	 * @param args command line args
	 */
	public static void main(String[] args) {
		App.create(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Player p = new Player(Constants.wpercent(10),Constants.hpercent(10),Constants.wpercent(10),Constants.hpercent(20));
				ArrowKeyController c = new ArrowKeyController(p);
				c.connect();
				State.gameState.add(p);
				return null;
			}
			
		}, null, null, args);
	}

}
