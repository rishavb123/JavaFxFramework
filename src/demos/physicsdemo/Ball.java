/**
 * 
 */
package demos.physicsdemo;

import framework.State;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import uiitems.gravityitems.GravityItem;

/**
 * Ball class
 * @author Bhagat
 *
 */
public class Ball extends GravityItem
{
	// TODO fix mouse controls    
	private static final long serialVersionUID = -4172819203965845387L;
	private double centerX;
	private double centerY;
	private double r;
	public static double pull = 50;
	private Color c;
	
	/**
	 * creates a ball
	 * @param centerX the center of the ball's x position
	 * @param centerY the center of the ball's y position
	 * @param r the ball's radius
	 * @param c the ball's color
	 */
	public Ball(double centerX, double centerY, double r, Color c) {
		super(centerX-r, centerY-r, 2*r, 2*r);
		this.centerX = centerX;
		this.centerY = centerY;
		this.r = r;
		this.c = c;
	}

	/**
	 * called every frame
	 * @see uiitems.gravityitems.GravityItem#update(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void update(GraphicsContext gc) {
		double cmx = State.gameState.getMouse().getX();
		double cmy = State.gameState.getMouse().getY();
		this.x-=pull*(x-cmx)/Math.abs(x-cmx);
		this.y-=pull*(y-cmy)/Math.abs(y-cmy);
		super.update(gc);
		centerX = r+x;
		centerY = r+y;
	}



	/**
	 * draws the ball
	 * @see uiitems.UIItem#draw(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(c);
		gc.fillOval(x, y, w, h);
	}

	/**
	 * @return the centerY
	 */
	public double getCenterY() {
		return centerY;
	}

	/**
	 * @return the centerX
	 */
	public double getCenterX() {
		return centerX;
	}


}
