package util;

import configurations.Direction;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Bhagat
 *
 */
public class RectUtil {

	/**
	 * checks which direction b intersected with a
	 * @param a a javafx 2d rectangle
	 * @param b a javafx 2d rectangle
	 * @return the Direction
	 */
	public static int intersects(Rectangle2D a, Rectangle2D b)
	{
		if(!b.intersects(a))
			return 0;
		
		if(b.getMaxX() >= a.getMinX() && b.getMaxX() <= a.getMaxX())
			if(b.getMaxY() >= a.getMinY() && b.getMaxY() <= a.getMaxY())
				if(b.getMaxX() - a.getMinX() > b.getMaxY() - a.getMinY())
					return Direction.UP;
				else
					return Direction.LEFT;
			else
				if(b.getMaxX() - a.getMinX() > a.getMaxY() - b.getMinY())
					return Direction.DOWN;
				else
					return Direction.LEFT;
		else
			if(b.getMaxY() >= a.getMinY() && b.getMaxY() <= a.getMaxY())
				if(a.getMaxX() - b.getMinX() > b.getMaxY() - a.getMinY())
					return Direction.UP;
				else
					return Direction.RIGHT;
			else
				if(a.getMaxX() - b.getMinX() > a.getMaxY() - b.getMinY())
					return Direction.DOWN;
				else
					return Direction.RIGHT;
	}
	
	/**
	 * draws a rectangle
	 * @param gc graphics context to draw onto the canvas
	 * @param a the rectangle to draw
	 */
	public static void fill(GraphicsContext gc, Rectangle2D a)
	{
		gc.fillRect(a.getMinX(), a.getMinY(), a.getWidth(), a.getHeight());
	}
	
	/**
	 * draws an outline of a rectangle
	 * @param gc graphics context to draw onto the canvas
	 * @param a the rectangle to draw
	 */
	public static void stroke(GraphicsContext gc, Rectangle2D a)
	{
		gc.strokeRect(a.getMinX(), a.getMinY(), a.getWidth(), a.getHeight());
	}
}
