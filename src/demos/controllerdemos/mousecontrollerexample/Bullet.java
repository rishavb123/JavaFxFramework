/**
 * 
 */
package demos.controllerdemos.mousecontrollerexample;

import configurations.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import uiitems.UIItem;

/**
 * @author Bhagat
 *
 */
public class Bullet extends UIItem {


	private static final long serialVersionUID = -3967243818919790375L;
	private double direction;
	private static final double speed = Constants.dim/24.0;
	
	/**
	 * creates a new bullet
	 * @param x x position
	 * @param y y position
	 * @param direction the direction it will travel in
	 */
	public Bullet(double x, double y, double direction)
	{
		super(x, y, Constants.dim/24.0, Constants.dim/24.0);
		this.direction = 180-direction;
		move();
	}
	
	/**
	 * causes the bullet to move in the direction stored in direction
	 */
	public void move()
	{
		double dx = speed*Math.sin(Math.toRadians(direction));
		double dy = speed*Math.cos(Math.toRadians(direction));
		x+=dx;
		y+=dy;
	}
	
	/**
	 * @see uiitems.UIItem#update(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void update(GraphicsContext gc) {
		move();
		draw(gc);
	}



	/**
	 * draws the bullet
	 * @see uiitems.UIItem#draw(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void draw(GraphicsContext gc) 
	{
		gc.setFill(Color.RED);
		gc.fillOval(x, y, w, h);
	}
	
}
