/**
 * 
 */
package util;

/**
 * utilities that have to do with numbers
 * @author Bhagat
 *
 */
public class NumberUtil {

	/**
	 * returns a random number between two numbers inclusively specified by the parameters
	 * @param start the first number in the range to generate a random number from
	 * @param stop the last number in the range to generate a random number from
	 * @return the generated random number from start to stop
	 */
	public static int rand(int start, int stop)
	{
		return (int)(Math.random()*(stop-start+1))+start;
	}

}
