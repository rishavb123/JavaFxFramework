package uiitems;

import java.io.Serializable;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * An item that will appear on the screen
 * @author Bhagat
 *
 */
public abstract class UIItem implements Serializable{

	private static final long serialVersionUID = -9130136424755878639L;
	protected double x;
	protected double y;
	protected double w;
	protected double h;
	
	/**
	 * Will draw the item
	 * @param gc Graphics Context used to draw onto the main screen
	 */
	public abstract void draw(GraphicsContext gc);
	
	/**
	 * Called every frame
	 * @param gc Graphics Context used to draw onto the main screen
	 */
	public void update(GraphicsContext gc)
	{
		draw(gc);
	}
	
	/**
	 * creates and returns a rectangle representing the object's position
	 * @return the rectange representing the object
	 */
	public Rectangle2D getRect()
	{
		return new Rectangle2D(x, y, w, h);
	}
	
	/**
	 * checks if a specified {uiitem.UIItem UIItem} is intersecting with this one
	 * @param u the other {uiitem.UIItem UIItem}
	 * @return a boolean which is true if and only if the two {uiitem.UIItem UIItem}s are intersecting
	 */
	public boolean intersects(UIItem u)
	{
		return getRect().intersects(u.getRect());
	}
	
	/**
	 * checks if a point is within this object
	 * @param x the x position of the point
	 * @param y the y position of the point
	 * @return a boolean which is true if and only if the point is inside this item
	 */
	public boolean contains(double x, double y)
	{
		return getRect().contains(new Point2D(x,y));
	}
	
	/**
	 * Returns the x variable
	 * @return the x position
	 */
	public double getX() {return x;}
	
	/**
	 * Returns the y variable
	 * @return the y position
	 */
	public double getY() {return y;}
	
	/**
	 * Returns the w variable
	 * @return the width
	 */
	public double getWidth() {return w;}
	
	/**
	 * Returns the h variable
	 * @return the height
	 */
	public double getHeight() {return h;}
	

}

