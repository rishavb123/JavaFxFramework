package framework;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import configurations.Direction;
import input.Key;
import input.Mouse;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import uiitems.Background;
import uiitems.UIItem;
import uiitems.interactiveitems.Interactive;
import util.ObjectSaver;
import util.RectUtil;

/**
 * A class to store the game state.
 * @author Bhagat
 *
 */
public class State implements Serializable
{
	private static final long serialVersionUID = 3084605437283801762L;
	private ArrayList<UIItem> items;
	private transient Background background;
	private HashMap<Object, Object> storage;
	private transient HashMap<KeyCode, Key> keyboard;
	private transient Mouse mouse;
	
	public static State gameState = new State();
	
	/**
	 * Constructs a state object and initialized items
	 */
	public State()
	{
		items = new ArrayList<>();
		storage = new HashMap<>();
		keyboard = new HashMap<>();
		mouse = new Mouse();
		setBackground(new Background());
	}
	
	/**
	 * Updates every item inside the items list and the background
	 * @param gc the graphics context to draw with
	 */
	public void update(GraphicsContext gc)
	{
		mouse.update();
		for(Key key: keyboard.values())
			key.update();
		background.update(gc);
		for(UIItem item: items)
		{
			item.update(gc);
			if(item instanceof Interactive)
				for(UIItem hit: items)
					if(hit != item)
						switch(RectUtil.intersects(item.getRect(), hit.getRect()))
						{
							case Direction.UP:
								((Interactive) item).touchAbove(hit);
								break;
							case Direction.DOWN:
								((Interactive) item).touchBelow(hit);
								break;
							case Direction.LEFT:
								((Interactive) item).touchLeft(hit);
								break;
							case Direction.RIGHT:
								((Interactive) item).touchRight(hit);
								break;
						}
						
		}
	}
	
	/**
	 * Returns the items variable
	 * @return a list of objects currently on screen
	 */
	public ArrayList<UIItem> getItems()
	{
		return items;
	}

	/**
	 * Setter for items
	 * @param items the items to set
	 */
	public void setItems(ArrayList<UIItem> items) {
		this.items = items;
	}
	
	public void clear()
	{
		setItems(new ArrayList<UIItem>());
	}

	/**
	 * Adds a {@link uiitems.UIItem UIItem} to the items list
	 * @param a the {@link uiitems.UIItem UIItem} to add to the list
	 */
	public void add(UIItem a)
	{
		items.add(a);
	}
	
	/**
	 * Gives the number of objects in items
	 * @return The size of the {@link java.util.ArrayList ArrayList} items
	 */
	public int getNumOfObjects()
	{
		return items.size();
	}
	
	/**
	 * Removes an element from the items list
	 * @param a The element to be removed from the list
	 */
	public void remove(UIItem a)
	{
		items.remove(a);
	}
	
	/**
	 * Tracks the specified key's actions
	 * @param k the key code for the key to be tracked
	 */
	public void track(KeyCode k)
	{
		if(!keyboard.containsKey(k))
			keyboard.put(k, new Key());
	}
	
	/**
	 * Tracks the list or array of keys' actions
	 * @param keyCodes list or array of key codes to be tracked
	 */
	public void track(Iterable<KeyCode> keyCodes)
	{
		for(KeyCode k: keyCodes)
			if(!keyboard.containsKey(k))
				keyboard.put(k, new Key());
	}
	
	/**
	 * Sets the state to a new state
	 * @param a the new state to start with
	 */
	public void setState(State a)
	{
		setItems(a.getItems());
		setBackground(a.getBackground());
		setStorage(a.getStorage());
		setKeyboard(a.getKeyboard());
	}

	/**
	 * gets the background
	 * @return the background
	 */
	public Background getBackground() {
		return background;
	}

	/**
	 * sets the background
	 * @param background the background to set
	 */
	public void setBackground(Background background) {
		this.background = background;
	}

	/**
	 * gets storage
	 * @return the store
	 */
	public HashMap<Object, Object> getStorage() {
		return storage;
	}

	/**
	 * sets storage
	 * @param storage the store to set
	 */
	public void setStorage(HashMap<Object, Object> storage) {
		this.storage = storage;
	}
	
	/**
	 * stores a value at a key in storage
	 * @param key key in storage
	 * @param value value to store
	 */
	public void store(Object key, Object value)
	{
		storage.put(key, value);
	}
	
	/**
	 * gets a value from storage
	 * @param key the key to access in storage 
	 * @return the value from storage
	 */
	public Object getFromStorage(Object key)
	{
		return storage.get(key);
	}

	/**
	 * @return the keyboard
	 */
	public HashMap<KeyCode, Key> getKeyboard() {
		return keyboard;
	}

	/**
	 * @param keyboard the keyboard to set
	 */
	public void setKeyboard(HashMap<KeyCode, Key> keyboard) {
		this.keyboard = keyboard;
	}
	
	/**
	 * @return the mouse
	 */
	public Mouse getMouse() {
		return mouse;
	}

	/**
	 * @param mouse the mouse to set
	 */
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	/**
	 * serialize the current state into a file
	 * @param path the file path
	 */
	public void save(String path)
	{
		try {
			ObjectSaver.write(this, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * load in a state from a file
	 * @param path the file path
	 * @return whether it loaded successfully or not
	 */
	public boolean load(String path)
	{
		try {
			State s = (State)ObjectSaver.read(path);
			this.setItems(s.getItems());
			this.setStorage(s.getStorage());
			return true;
		} catch (ClassNotFoundException | IOException e) {
			return false;
		}
	}
	
}
