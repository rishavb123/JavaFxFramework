/**
 * 
 */
package application;

import configurations.Constants;
import framework.State;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import uiitems.UIText;
import webapplet.FXApplet;

/**
 * Main Application class for web applets
 * @author Bhagat
 *
 */
public class Applet extends FXApplet{

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
		canvas = new Canvas(width, height);
		root.getChildren().add(canvas);
		
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLUE);

		animate = new AnimateObjects();
		animate.start();
		
		start();
		
		State.gameState.add(UIText.centerText("Hello World", height/2 - height/20, (int)(height/10), width, FontWeight.BOLD, Color.BLUE));
		
	}
	
	/**
	 * method called when the applet is created
	 */
	public void start() {}
	
	/**
	 * method called at every frame
	 */
	public void update() {}
	
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
			update();
		}
	}

}
