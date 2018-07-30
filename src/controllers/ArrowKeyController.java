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
public class ArrowKeyController extends Controller<ArrowKeyController.Controllable> {

	private static final long serialVersionUID = -7031182488255342713L;

	/**
	 * creates an ArrowKeyController object
	 * @param c the object to be controlled
	 */
	public ArrowKeyController(Controllable c)
	{
		objToControl = c;
	}
	
	/**
	 * @see controllers.Controller#connect()
	 */
	@Override
	public void connect() {
		HashMap<KeyCode, Key> keyboard = State.gameState.getKeyboard();
		KeyCode[] keyCodes = {KeyCode.UP, KeyCode.DOWN, KeyCode.RIGHT, KeyCode.LEFT};
		State.gameState.track(ArrayUtil.newArrayListFromArray(keyCodes));
		keyboard.get(KeyCode.UP).setWhilePressed(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.up();
				return null;
			}
			
		});
		keyboard.get(KeyCode.DOWN).setWhilePressed(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.down();
				return null;
			}
			
		});
		keyboard.get(KeyCode.LEFT).setWhilePressed(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.left();
				return null;
			}
			
		});
		keyboard.get(KeyCode.RIGHT).setWhilePressed(new Callable<Void>() {

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
		keyboard.get(KeyCode.UP).removeWhilePressed();
		keyboard.get(KeyCode.DOWN).removeWhilePressed();
		keyboard.get(KeyCode.LEFT).removeWhilePressed();
		keyboard.get(KeyCode.RIGHT).removeWhilePressed();
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
		 * will be triggered while the up arrow is pressed
		 */
		public void up();
		
		/**
		 * will be triggered while the down arrow is pressed
		 */
		public void down();
		
		/**
		 * will be triggered while the right arrow is pressed
		 */
		public void right();
		
		/**
		 * will be triggered while the left arrow is pressed
		 */
		public void left();
	}

}
