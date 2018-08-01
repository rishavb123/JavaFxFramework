/**
 * 
 */
package application;

import configurations.Constants;
import framework.State;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import webapplet.FXApplet;

/**
 * Main Application class for web applets
 * @author Bhagat
 *
 */
public abstract class Applet extends FXApplet implements EventHandler<InputEvent>{

	private static final long serialVersionUID = -1146021402964369329L;
	
	protected GraphicsContext gc;
	private AnimateObjects animate;
	private Canvas canvas;
	
	private static double width = Constants.width;
	private static double height = Constants.height;
		
	/**
	 * @see webapplet.FXApplet#initApplet()
	 */
	@Override
	public void initApplet()
	{
		Group root = new Group();
		canvas = new Canvas(width, height);
		root.getChildren().add(canvas);
		
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLUE);
		Scene scene = new Scene(root);
		scene.addEventHandler(KeyEvent.ANY,this);
		scene.addEventHandler(MouseEvent.ANY, this);

		animate = new AnimateObjects();
		animate.start();
				
		//startFunc();
		gc.fillRect(10, 10, 100, 100);
	}

	
	public abstract void startFunc();
	public abstract void nextFunc();
	
	/**
	 * Method to handle an Events
	 * @see javafx.event.EventHandler#handle(javafx.scene.input.InputEvent)
	 */
	@Override
	public void handle(final InputEvent event) 
	{
		if(event instanceof KeyEvent)
		{
			KeyEvent keyEvent = (KeyEvent)event;
			
			if(event.getEventType().toString().equals("KEY_PRESSED") )
			{
				if(State.gameState.getKeyboard().containsKey(keyEvent.getCode()))
					State.gameState.getKeyboard().get(keyEvent.getCode()).press();
			}
			else if(event.getEventType().toString().equals("KEY_RELEASED") )
			{
				if(State.gameState.getKeyboard().containsKey(keyEvent.getCode()))
					State.gameState.getKeyboard().get(keyEvent.getCode()).release();
			}
		}
		else if(event instanceof MouseEvent)
		{
			MouseEvent mouseEvent = (MouseEvent)event;
			
			if(event.getEventType().toString().equals("MOUSE_PRESSED"))
			{
				State.gameState.getMouse().press();
			}
			else if(event.getEventType().toString().equals("MOUSE_RELEASED"))
			{
				State.gameState.getMouse().release();
			}
			else if(event.getEventType().toString().equals("MOUSE_MOVED") || event.getEventType().toString().equals("MOUSE_DRAGGED"))
			{
				State.gameState.getMouse().moved(mouseEvent.getSceneX(), mouseEvent.getSceneY());
			}
		}
	}
		
	/**
	 * animate objects is to create a method that runs every frame
	 * @author Bhagat
	 *
	 */
	public final class AnimateObjects extends AnimationTimer
	{
		/**
		 * updates the state and calls the next method everyframe
		 */
		public final void handle(long time)
		{
			State.gameState.update(gc);
//			nextFunc();
		}
	}

}
