/**
 * 
 */
package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Bhagat
 *
 */
public class Server extends Thread{

	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	
	private ServerSocket server;
	private Socket connection;
	
	private int port;
	private int maxPeople;
	
	private boolean logs;
	
	public Server(int port, int maxPeople)
	{
		this.port = port;
		this.maxPeople = maxPeople;
		logs = false;
	}
	
	public Server(int port, int maxPeople, boolean logs)
	{
		this.port = port;
		this.maxPeople = maxPeople;
		this.logs = logs;
	}
	
	public void run()
	{
		try {
			server = new ServerSocket(port, maxPeople);
			while(true)
			{
				try {
					log("Waiting to connect");
					connection = server.accept();
					log("Connected to "+connection.getInetAddress().getHostName());
					log("Setting up streams");
					outputStream = new ObjectOutputStream(connection.getOutputStream());
					outputStream.flush();
					inputStream = new ObjectInputStream(connection.getInputStream());
					log("Streams are now set up");
				} catch (EOFException eof) {
					log("done");
				} finally {
					log("Closing Connections");
					try {
						inputStream.close();
						outputStream.close();
						connection.close();
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public <E> void send(E obj)
	{
		try {
			outputStream.writeObject(obj);
			outputStream.flush();
			log(obj.toString());
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void log(String s)
	{
		if(logs)
			System.out.println(s);
	}
	
}
