package configurations;

/**
 * A publicly accessed file to store the configurations of the game
 * @author Bhagat
 *
 */
public class Constants 
{
	public static double dim = 600;
	public static double widthMultiplier = 2;
	public static double heightMultiplier = 1;
	public static double width = dim*widthMultiplier;
	public static double height = dim*heightMultiplier;
	public static boolean dev = true;
	
	/**
	 * returns a percentage of the width
	 * @param x the percent
	 * @return the number
	 */
	public static final double wpercent(double x) { return x*width/100; }
	
	/**
	 * returns a percentage of the height
	 * @param y the percent
	 * @return the number
	 */
	public static final double hpercent(double y) { return y*height/100; }
}
