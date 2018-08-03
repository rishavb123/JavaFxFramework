package uiitems.entities;

import javafx.scene.canvas.GraphicsContext;
import uiitems.HealthItem;
import uiitems.gravityitems.Gravity;

/**
 * a {@link uiitems.UIItem uiitem} representing an entity in a game
 * @author Bhagat
 *
 */
public abstract class Entity extends HealthItem implements Gravity{

	private static final long serialVersionUID = 8535189821111581254L;
	private double dx;
	private double dy;
	
	/**
	 * creates an entity object
	 * @param x the starting x position
	 * @param y the starting y position
	 * @param w the width
	 * @param h the height
	 * @param maxHealth the starting and maximum health
	 */
	public Entity(double x, double y, double w, double h, int maxHealth) {
		super(x, y, w, h, maxHealth);
		dx = 0;
		dy = 0;
	}
	
	/**
	 * @see uiitems.UIItem#update(GraphicsContext)
	 */
	@Override
	public void update(GraphicsContext gc)
	{
		x+=dx;
		y+=dy;
		draw(gc);
	}
	
	/**
	 * @return the dx
	 */
	public double getDx() {
		return dx;
	}

	/**
	 * @param dx the dx to set
	 */
	public void setDx(double dx) {
		this.dx = dx;
	}

	/**
	 * @return the dy
	 */
	public double getDy() {
		return dy;
	}

	/**
	 * @param dy the dy to set
	 */
	public void setDy(double dy) {
		this.dy = dy;
	}

}
