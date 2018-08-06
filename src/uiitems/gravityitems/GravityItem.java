package uiitems.gravityitems;

import configurations.Direction;
import configurations.GravityConfig;
import javafx.scene.canvas.GraphicsContext;
import uiitems.UIItem;

/**
 * uiitem that is affected by gravity
 * @author Bhagat
 *
 */
public abstract class GravityItem extends UIItem implements Gravity{

	private static final long serialVersionUID = -4667965665109557341L;
	protected double dx;
	protected double dy;
	
	/**
	 * creates an Entity affected by gravity
	 * @param x initial x position
	 * @param y initial y position
	 * @param w initial width
	 * @param h initial height
	 */
	public GravityItem(double x, double y, double w, double h) {
		super(x, y, w, h);
		dx=0;
		dy=0;
	}
	
	
	/**
	 * @see uiitems.UIItem#update(GraphicsContext)
	 */
	@Override
	public void update(GraphicsContext gc)
	{
		applyGravity(this);
		x+=dx;
		y+=dy;
		draw(gc);
	}
	
	/**
	 * applies gravity to a certain object
	 * @param obj the object to apply gravity to
	 */
	public static void applyGravity(Gravity obj)
	{
		if(GravityConfig.directions.get(Direction.UP))
			obj.setDy(obj.getDy()-GravityConfig.g);
		if(GravityConfig.directions.get(Direction.DOWN))
			obj.setDy(obj.getDy()+GravityConfig.g);
		if(GravityConfig.directions.get(Direction.RIGHT))
			obj.setDx(obj.getDx()+GravityConfig.g);
		if(GravityConfig.directions.get(Direction.LEFT))
			obj.setDx(obj.getDx()-GravityConfig.g);

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
