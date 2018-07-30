package input;

import java.util.concurrent.Callable;

import util.CallableUtil;

/**
 * key storing if it is pressed or not
 * @author Bhagat
 *
 */
public class Key {

	private boolean pressed;
	private Callable<Void> onClick;
	private Callable<Void> onRelease;
	private Callable<Void> whilePressed;
	
	/**
	 * called every frame to call whilePressed if the key is pressed
	 */
	public void update() {
//		System.out.print(isPressed()+" ");
		if(pressed)
			CallableUtil.run(whilePressed);
	}
	
	/**
	 * @return the pressed
	 */
	public boolean isPressed() {
		return pressed;
	}

	/**
	 * presses the key by setting release to true
	 */
	public void press()
	{
		if(!isPressed())
		{
			pressed = true;
			CallableUtil.run(onClick);
		}
	}
	
	/**
	 * releases the key by setting release to false
	 */
	public void release()
	{
		pressed = false;
		CallableUtil.run(onRelease);
	}

	/**
	 * @return the onClick
	 */
	public Callable<Void> getOnClick() {
		return onClick;
	}

	/**
	 * @param onClick the onClick to set
	 */
	public void setOnClick(Callable<Void> onClick) {
		this.onClick = onClick;
	}
	
	/** 
	 * removes the on click function trigger
	 */
	public void removeOnClick()
	{
		onClick = null;
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
	 * removes the on release function trigger
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
	 * removes the while pressed function
	 */
	public void removeWhilePressed()
	{
		whilePressed = null;
	}

}
