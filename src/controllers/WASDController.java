package controllers;

import java.util.HashMap;
import java.util.concurrent.Callable;

import framework.State;
import input.Key;
import javafx.scene.input.KeyCode;
import util.ArrayUtil;

/**
 * A controller using the arrow keys
 * @author Bhagat
 *
 */
public class WASDController extends Controller<WASDController.Controllable> {

	private static final long serialVersionUID = 8213014937772742544L;

	/**
	 * creates a WASDController object
	 * @param c the object to be controlled
	 */
	public WASDController(Controllable c)
	{
		objToControl = c;
	}
	
	/**
	 * @see controllers.Controller#connect()
	 */
	@Override
	public void connect() {
		HashMap<KeyCode, Key> keyboard = State.gameState.getKeyboard();
		KeyCode[] keyCodes = {KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D};
		State.gameState.track(ArrayUtil.newArrayListFromArray(keyCodes));
		keyboard.get(KeyCode.W).setWhilePressed(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.up();
				return null;
			}
			
		});
		keyboard.get(KeyCode.S).setWhilePressed(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.down();
				return null;
			}
			
		});
		keyboard.get(KeyCode.A).setWhilePressed(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.left();
				return null;
			}
			
		});
		keyboard.get(KeyCode.D).setWhilePressed(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.right();
				return null;
			}
			
		});
		connected = true;
	}

	/**
	 * @see controllers.Controller#disconnect()
	 */
	@Override
	public void disconnect() {
		HashMap<KeyCode, Key> keyboard = State.gameState.getKeyboard();
		keyboard.get(KeyCode.W).removeWhilePressed();
		keyboard.get(KeyCode.S).removeWhilePressed();
		keyboard.get(KeyCode.A).removeWhilePressed();
		keyboard.get(KeyCode.D).removeWhilePressed();
		connected = false;
	}
	
	/**
	 * interface the will be implemented by anything that wants to be controlled by this class
	 * @author Bhagat
	 *
	 */
	public static interface Controllable 
	{
		/**
		 * will be triggered while the w arrow is pressed
		 */
		public void up();
		
		/**
		 * will be triggered while the s arrow is pressed
		 */
		public void down();
		
		/**
		 * will be triggered while the d arrow is pressed
		 */
		public void right();
		
		/**
		 * will be triggered while the a arrow is pressed
		 */
		public void left();
	}

}
