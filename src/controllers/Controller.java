package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * generic controller
 * @author Bhagat
 *
 */
public abstract class Controller<E> implements Serializable {
	
	private static final long serialVersionUID = -1651705400347962237L;
	protected boolean connected;
	protected E objToControl;
	public static int stateCounter=0;
	
	/**
	 * connect to the object to control and activate the controller
	 */
	public abstract void connect();
	
	/**
	 * disconnect to the object to control and deactive the controller
	 */
	public abstract void disconnect();
	
	/**
	 * @return the connected
	 */
	public boolean isConnected() {
		return connected;
	}
	
	@SuppressWarnings("unchecked")
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {      
        connected = aInputStream.readBoolean();
        objToControl = (E) aInputStream.readObject();
        if(connected)
        	connect();
    }
 
    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
        aOutputStream.writeBoolean(connected);
        aOutputStream.writeObject(objToControl);
    }
}
