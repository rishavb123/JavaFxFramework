package demos.spritedemo;

import java.util.concurrent.Callable;

import application.App;
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
				State.gameState.add(new Player(100,100,100,100));
				return null;
			}
			
		}, null, null, args);
	}

}
