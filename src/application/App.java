package application;

import java.util.concurrent.Callable;

import configurations.Constants;
import framework.State;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.CallableUtil;

/**
 * The Main Application of the game
 * @author Bhagat
 *
 */
public class App extends Application implements EventHandler<InputEvent> {
		
	private GraphicsContext gc;
	private AnimateObjects animate;
	private Canvas canvas;
	private Stage stage;
	
	private static double width = Constants.width;
	private static double height = Constants.height;
	
	private static Callable<Void> startFunc;
	private static Callable<Void> nextFunc;
	private static Callable<Void> stopFunc;
		
	/**
	 * Method that gets called when the application is started
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public final void start(Stage stage) throws Exception 
	{
		this.stage = stage;
		
		Group root = new Group();
		canvas = new Canvas(width, height);
		root.getChildren().add(canvas);
		
		gc = canvas.getGraphicsContext2D();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		scene.addEventHandler(KeyEvent.ANY,this);
		scene.addEventHandler(MouseEvent.ANY, this);
		
		animate = new AnimateObjects();
		animate.start();
		
		stage.show();
		
		CallableUtil.run(startFunc);
		
	}
	
	@Override
	public void stop()
	{
		CallableUtil.run(stopFunc);
	}
	
	/**
	 * starts the application
	 * @param start method to call on start
	 * @param next method to call every frame
	 * @param args command line arguments
	 */
	public static void begin(Callable<Void> start, Callable<Void> next, Callable<Void> stop, String[] args)
	{
		startFunc = start;
		nextFunc = next;
		stopFunc = stop;
		main(args);
	}
	
	/**
	 * Sets the title or header of the application window
	 * @param title the title that will be set onto the window
	 */
	public final void setTitle(String title)
	{
		stage.setTitle(title);
	}
	
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

	// TODO FIX THIS |
	//               V
//	/**
//	 * Set an event for when this key is pressed
//	 * @param k {@link javafx.scene.input.KeyCode KeyCode} for the key that will be pressed
//	 * @param c {@link java.util.concurrent.Callable Callable} object containing the method to be run
//	 */
//	public final void setOnPressEvent(KeyCode k, Callable<Void> c)
//	{
//		onPressEvents.put(k, c);
//	}
	
	/**
	 * Main method calling launch to start the app
	 * @param args Command Line Arguments
	 */
	public final static void main(String[] args)
	{
		launch(args);
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
			CallableUtil.run(nextFunc);
		}
	}

}
