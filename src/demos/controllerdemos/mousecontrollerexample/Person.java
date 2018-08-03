/**
 * 
 */
package demos.controllerdemos.mousecontrollerexample;

import configurations.Constants;
import controllers.ArrowKeyController;
import controllers.MouseController;
import controllers.WASDController;
import framework.State;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import uiitems.UIItem;

/**
 * person object for the demo
 * @author Bhagat
 *
 */
public class Person extends UIItem implements MouseController.Controllable, ArrowKeyController.Controllable, WASDController.Controllable {


	private static final long serialVersionUID = 3684054524050696057L;
	private double direction = 0;
	public static final int dx = 10;
	public static final int dy = 10;
	
	/**
	 * creates a person object at position (x, y)
	 */
	public Person(double x, double y) 
	{
		super(x, y, Constants.dim/12.0, Constants.dim/12.0);
	}

	/**
	 * draws the person
	 * @see uiitems.UIItem#draw(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void draw(GraphicsContext gc) 
	{
		gc.setFill(Color.BLUE);
		double rotationCenterX = x + 0.5*w;
	    double rotationCenterY = y + 0.5*h;
	    gc.save();
	    gc.fillOval(x,y,w,h);
	    gc.translate(rotationCenterX, rotationCenterY);
	    gc.rotate(direction);
		gc.fillRect(-w/4.0, -h, w/2.0, h);
		gc.restore();
	}

	/**
	 * make the person face the mouse
	 * @param mx mouse x position
	 * @param my mouse y position
	 */
	public void updateDirection(double mx, double my)
	{
		double cx = x+w/2.0;
		double cy = y+h/2.0;
		direction = -Math.toDegrees(Math.atan((mx-cx)/(my-cy)));
		if(my>cy)
			direction+=180;
		
	}
	
	/**
	 * generates a bullet and shoots it in the direction the person is facing
	 */
	public void shoot()
	{
		State.gameState.add(new Bullet(x+0.25*w, y+0.25*h, direction));
	}

	/**
	 * called when the mouse is moved
	 * @see MouseController.Controllable#mouseMoved(double, double)
	 * @param x the mouse x position
	 * @param y the mouse y position
	 */
	@Override
	public void mouseMoved(double x, double y) {
		updateDirection(x, y);
	}

	/**
	 * called when the mouse is pressed
	 * @see MouseController.Controllable#mousePressed(double, double)
	 * @param x the mouse x position
	 * @param y the mouse y position
	 */
	@Override
	public void mousePressed(double x, double y) {
		shoot();
	}

	/**
	 * called when the mouse is released
	 * @see MouseController.Controllable#mouseReleased(double, double)
	 * @param x the mouse x position
	 * @param y the mouse y position
	 */
	@Override
	public void mouseReleased(double x, double y) {}

	/**
	 * called when the up key is pressed
	 * @see controllers.ArrowKeyController.Controllable#up()
	 */
	@Override
	public void up() {
		y -= dy;
		updateDirection(State.gameState.getMouse().getX(), State.gameState.getMouse().getY());
	}

	/**
	 * called when the down key is pressed
	 * @see controllers.ArrowKeyController.Controllable#down()
	 */
	@Override
	public void down() {
		y += dy;
		updateDirection(State.gameState.getMouse().getX(), State.gameState.getMouse().getY());
	}

	/**
	 * called when the right key is pressed
	 * @see controllers.ArrowKeyController.Controllable#right()
	 */
	@Override
	public void right() {
		x += dx;
		updateDirection(State.gameState.getMouse().getX(), State.gameState.getMouse().getY());
	}

	/**
	 * called when the left key is pressed
	 * @see controllers.ArrowKeyController.Controllable#left()
	 */
	@Override
	public void left() {
		x -= dx;
		updateDirection(State.gameState.getMouse().getX(), State.gameState.getMouse().getY());
	}

}
