package input;

/**
 * an interface to allow the use of mouse events on it
 * @author Bhagat
 *
 */
public interface MouseListener {

	/**
	 * to be called if the item is clicked
	 */
	public void mouseOnClick();
	
	/**
	 * to be called if the item is pressed on with the mouse
	 */
	public void mouseOnPress();
	
	/**
	 * to be called if the mouse is released on the item
	 */
	public void mouseOnRelease();
	
	/**
	 * to be called while the mouse is pressed
	 */
	public void mouseWhilePressed();
	
}
