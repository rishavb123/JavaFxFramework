/**
 * 
 */
package configurations;

import java.util.HashMap;

/**
 * Constants for a gravity game
 * @author Bhagat
 *
 */
public class GravityConfig extends Constants
{
	public static final double g = dim/300;
	public static HashMap<Integer, Boolean> directions = new HashMap<Integer, Boolean>() {
		private static final long serialVersionUID = -5572127757456175760L;

	{
		put(Direction.UP, false);
		put(Direction.DOWN, true);
		put(Direction.LEFT, false);
		put(Direction.RIGHT, false);
	}};
	

	
}
