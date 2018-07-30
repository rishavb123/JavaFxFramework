package controllers;

import java.util.concurrent.Callable;

import framework.State;

/**
 * @author Bhagat
 *
 */
public class MouseController extends Controller<MouseController.Controllable> {

	private static final long serialVersionUID = 8563948634150957954L;

	/**
	 * creates a mouse controller
	 * @param c the object to be controlled
	 */
	public MouseController(Controllable c)
	{
		objToControl = c;
	}

	/**
	 * @see controllers.Controller#connect()
	 */
	@Override
	public void connect() {
		State.gameState.getMouse().setOnMove(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.mouseMoved(State.gameState.getMouse().getX(), State.gameState.getMouse().getY());
				return null;
			}
		
		});
		
		State.gameState.getMouse().setOnRelease(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.mouseReleased(State.gameState.getMouse().getX(), State.gameState.getMouse().getY());
				return null;
			}
		
		});
		
		State.gameState.getMouse().setOnPress(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				objToControl.mousePressed(State.gameState.getMouse().getX(), State.gameState.getMouse().getY());
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

		connected = false;
	}

	/**
	 * interface the will be implemented by anything that wants to be controlled by this class
	 * @author Bhagat
	 *
	 */
	public static interface Controllable {
		
		/**
		 * to be called when the mouse moves
		 * @param x the new x position
		 * @param y the new y position
		 */
		public void mouseMoved(double x, double y);
		
		/**
		 * to be called when the mouse is pressed
		 * @param x the current x position
		 * @param y the current y position
		 */
		public void mousePressed(double x, double y);
		
		/**
		 * to be called when the mouse is released
		 * @param x the current x position
		 * @param y the current y position
		 */
		public void mouseReleased(double x, double y);
		
	}	
}
