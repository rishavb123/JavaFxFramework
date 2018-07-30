package input;

import java.util.concurrent.Callable;

import framework.State;
import uiitems.UIItem;
import util.CallableUtil;

/**
 * represents the mouse
 * @author Bhagat
 *
 */
public class Mouse {

	private double x;
	private double y;
	private boolean pressed;
	private Callable<Void> onPress;
	private Callable<Void> onRelease;
	private Callable<Void> whilePressed;
	private Callable<Void> onMove;
	
	public Mouse()
	{
		x = 0;
		y = 0;
		pressed = false;
	}
	
	/**
	 * function to be called when the mouse is moved
	 * @param d the new x position
	 * @param e the new y position
	 */
	public void moved(double d, double e)
	{
		this.x = d;
		this.y = e;
		CallableUtil.run(onMove);
	}
	
	/**
	 * function to be called every frame
	 */
	public void update()
	{
		if(isPressed())
		{
			CallableUtil.run(whilePressed);
			for(UIItem item: State.gameState.getItems())
			{
				if(item instanceof MouseListener && item.contains(x, y))
					((MouseListener) item).mouseWhilePressed();
			}
		}	
	}
	
	/**
	 * function to be called when the mouse is pressed
	 */
	public void press()
	{
		if(!isPressed())
		{
			CallableUtil.run(onPress);
			pressed = true;
			for(UIItem item: State.gameState.getItems())
			{
				if(item instanceof MouseListener && item.contains(x, y))
					((MouseListener) item).mouseOnPress();
			}
		}
	}
	
	/**
	 * function to be called when the mouse is released
	 */
	public void release()
	{
		CallableUtil.run(onRelease);
		pressed = false;
		for(UIItem item: State.gameState.getItems())
		{
			if(item instanceof MouseListener && item.contains(x, y))
				((MouseListener) item).mouseOnRelease();
		}
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param d the x to set
	 */
	public void setX(double d) {
		this.x = d;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the onPress
	 */
	public Callable<Void> getOnPress() {
		return onPress;
	}

	/**
	 * @param onPress the onPress to set
	 */
	public void setOnPress(Callable<Void> onPress) {
		this.onPress = onPress;
	}
	
	/**
	 * removes the on press method
	 */
	public void removeOnPress()
	{
		onPress = null;
	}

	/**
	 * @return the onRelease
	 */
	public Callable<Void> getOnRelease() {
		return onRelease;
	}

	/**
	 * @param onRelease the onRelease to set
	 */
	public void setOnRelease(Callable<Void> onRelease) {
		this.onRelease = onRelease;
	}
	
	/**
	 * removes the on release method
	 */
	public void removeOnRelease()
	{
		onRelease = null;
	}

	/**
	 * @return the whilePressed
	 */
	public Callable<Void> getWhilePressed() {
		return whilePressed;
	}

	/**
	 * @param whilePressed the whilePressed to set
	 */
	public void setWhilePressed(Callable<Void> whilePressed) {
		this.whilePressed = whilePressed;
	}
	
	/**
	 * remove the while pressed function
	 */
	public void removeWhilePressed()
	{
		whilePressed = null;
	}

	/**
	 * @return the pressed
	 */
	public boolean isPressed() {
		return pressed;
	}

	/**
	 * @param pressed the buttonDown to set
	 */
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	/**
	 * @return the onMove
	 */
	public Callable<Void> getOnMove() {
		return onMove;
	}

	/**
	 * @param onMove the onMove to set
	 */
	public void setOnMove(Callable<Void> onMove) {
		this.onMove = onMove;
	}
	
}
