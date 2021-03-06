package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Utilities for reading and writing to files
 * @author Bhagat
 */
public final class FileHandler {
	
	
	/**
	 * the file path
	 */
	private String path;
	
	/**
	 * Creates a FileHandler object for one file
	 * @param path the file path
	 */
	public FileHandler(String path)
	{
		this.path = path;
	}
	
	/**
	 * Read the file specified in the constructor
	 * @return the read text
	 */
	public String read()
	{
		return read(this.path);
	}
	
	/**
	 * Write to the file specified in the constructor
	 * @param text the text to be written into the file
	 */
	public void write(String text)
	{
		write(this.path, text);
	}
	
	/**
	 * @return the path
	 */
	public String getPath() 
	{
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) 
	{
		this.path = path;
	}

	/**
	 * Reads from file specified by the <code>path</code>
	 * @param path the file path
	 * @return the contents of the file
	 */
	public static String read(String path)
	{
		File fi = new File(path);
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(fi));
			String text = "";
			String s;
			while((s = reader.readLine())!=null)
			{
				text+=s+"\n";
			}
			reader.close();
			return text.substring(0, text.length() - 1);

		} catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Writes the <code>text</code> to the file specified by the <code>path</code>
	 * @param path the file path
	 * @param text the text to be written to the file
	 */
	public static void write(String path, String text)
	{
		try {
			FileWriter fw = new FileWriter(path);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(text);
			
			fw.close();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
