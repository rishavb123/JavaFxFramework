package testing;

import java.util.ArrayList;

import util.ArrayUtil;

/**
 * A place to test code
 * @author Bhagat
 *
 */
public class ArrayListTest {

	/**
	 * The main method to run test code
	 * @param args Command Line arguments
	 */
	public static void main(String[] args) {
		ArrayList<Double> list = ArrayUtil.newArrayList(1.2,3.14,5.2,2.7);
		System.out.println(list);
		list.remove(3.14);
		System.out.println(list);
	}

}
