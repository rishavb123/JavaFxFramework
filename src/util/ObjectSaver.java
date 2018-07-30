package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A class to save objects in binary files
 * @author Bhagat
 */
public class ObjectSaver {
	
	/**
	 * Save any {@link java.io.Serializable Serializable} object to a file
	 * @param obj the object you want to save to the file
	 * @param filename the filename of the file to write to
	 * @throws IOException From the creation of the Streams
	 */
	public static void write(Serializable obj, String filename) throws IOException
	{
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(obj);
		out.close();
		file.close();
	}
	
	/**
	 * Read a Serialized object from the file
	 * @param filename the filename for the file to read from
	 * @return the object read
	 * @throws IOException From the creation of the Streams
	 * @throws ClassNotFoundException From reading in the object
	 */
	public static Object read(String filename) throws IOException, ClassNotFoundException
	{
		FileInputStream file = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(file);
		Object obj = in.readObject();
		in.close();
		file.close();
		return obj;
	}
	
}
