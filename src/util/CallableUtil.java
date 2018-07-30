/**
 * 
 */
package util;

import java.util.concurrent.Callable;

/**
 * Utilities for Callable functions
 * @author Bhagat
 *
 */
public class CallableUtil {

	/**
	 * Run a callable function
	 * @param c the callable object
	 * @return what the function returned
	 */
	public static <E> E run(Callable<E> c)
	{
		if(c != null)
			try {
				return c.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
}
