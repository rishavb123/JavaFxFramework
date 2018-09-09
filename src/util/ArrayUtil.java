package util;

import java.util.ArrayList;

/**
 * A few of Utility methods for Arrays and ArrayLists
 * @author Bhagat
 */
public final class ArrayUtil {
	
	/**
	 * Copies the list into a new {@link java.util.ArrayList ArrayList} at a different memory location
	 * @param list the list to be copied
	 * @return the copied list
	 */
	public static <E> ArrayList<E> copy(ArrayList<E> list)
	{
		ArrayList<E> list2 = new ArrayList<>();
		list2.addAll(list);
		return list2;
	}
	
	/**
	 * Copies one array into another
	 * @param arr the array to be copied
	 * @param arr2 the array to copy to
	 * @return the copied array
	 */
	public static <E> E[] copy(E[] arr, E[] arr2)
	{
		if(arr.length != arr2.length)
			return null;
		for(int x=0; x<arr.length; x++)
		{
			arr2[x] = arr[x];
		}
		return arr;
	}
	
	/**
	 * This method creates an array from an {@link java.util.ArrayList ArrayList}
	 * @param list the array list to create the array from
	 * @param arr the array to write to
	 * @return the new array created
	 */
	public static <E> E[] newArrayFromArrayList(ArrayList<E> list, E[] arr)
	{
		if(list.size() != arr.length)
			return null;
		for(int x=0; x<arr.length; x++)
			arr[x] = list.get(x);
		return arr;
	}
	
	/**
	 * This method creates a new {@link java.util.ArrayList ArrayList} with the elements specified by the parameters passed into the method
	 * @param items The elements that will fill the {@link java.util.ArrayList ArrayList} to be returned
	 * @return A new {@link java.util.ArrayList ArrayList} with the items specified from parameters
	 */
	@SafeVarargs
	public static <E> ArrayList<E> newArrayList(E... items)
	{
		ArrayList<E> list = new ArrayList<>();
		for(E a: items)
			list.add(a);
		return list;
	}
	
	/**
	 * This method creates a new {@link java.util.ArrayList ArrayList} with the elements specified by the array into the method
	 * @param items An array that will be converted into an {@link java.util.ArrayList ArrayList}
	 * @return A new {@link java.util.ArrayList ArrayList} created from the array <code>items</code>
	 */
	public static <E> ArrayList<E> newArrayListFromArray(E[] items)
	{
		ArrayList<E> list = new ArrayList<>();
		for(E a: items)
			list.add(a);
		return list;
	}
	
	/**
	 * Prints out an array in an {@link java.util.ArrayList ArrayList} format
	 * @param arr Array to be printed
	 */
	public static <E> void printArr(E[] arr)
	{
		System.out.println(newArrayListFromArray(arr));
	}
	
	/**
	 * combine two arrays into a third array
	 * @param a the first array to combine
	 * @param b the second array to combine
	 * @param writeTo the array to combine the other two onto
	 * @return the combined array
	 */
	public static <E> E[] combine(E[] a, E[] b, E[] writeTo)
	{
		if(a.length+b.length>writeTo.length)
			return null;
		
		for(int x=0;x<a.length;x++)
			writeTo[x] = a[x];
		for(int x=0;x<b.length;x++)
			writeTo[x+a.length] = b[x];
			
		return writeTo;
	}

	
}
