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
	public static HashMap<Integer, Boolean> directions = setDirections();
	
	private static final HashMap<Integer, Boolean> setDirections() {
		directions.put(Direction.UP, false);
		directions.put(Direction.DOWN, true);
		directions.put(Direction.LEFT, false);
		directions.put(Direction.RIGHT, false);
		return directions;
	}
	
}
