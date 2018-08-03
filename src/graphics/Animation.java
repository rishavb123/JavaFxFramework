package graphics;

import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import util.ArrayUtil;

/**
 * Uses a One Dimension Buffered Image array to create an animation
 * @author Bhagat
 *
 */
public class Animation {

	private BufferedImage[] frames;
	
	private long delay;
	private long time;
	
	private int currentFrame;
	
	private boolean hold;
	private boolean holding;
	private boolean playedOnce;
	
	/**
	 * creates a animation from an array of Buffered Images
	 * @param frames the array of frames
	 * @param delay the delay between frames
	 * @param hold whether or not to hold on the last frame
	 * @param start where to start in the frames array for the animation
	 * @param stop where to stop in the frames array for the animation
	 */
	public Animation(BufferedImage[] frames, long delay, boolean hold) {
		this.frames = frames;
		
		this.delay = delay;
		time = System.nanoTime();
		
		this.hold = hold;
		holding = false;
		playedOnce = false;
		
		currentFrame = 0;
	}
	
	/**
	 * gets the current frame and converts it into a Java FX Image
	 * @return the Java FX Image of the current frame
	 */
	public Image getImage()
	{
		return SwingFXUtils.toFXImage(frames[currentFrame], null);
	}
	
	/**
	 * to be called every frame and ups the currentFrame if the delay if enough
	 */
	public void update()
	{
		
		if((System.nanoTime() - time) / 1000000 > delay)
		{
			time = System.nanoTime();
			currentFrame++;
		}
		
		if(currentFrame == this.frames.length)
		{
			if(hold) {
				currentFrame--;
				holding = true;
			}
			else {
				currentFrame = 0;
				playedOnce = true;
			}
		}
		
	}
	
	/**
	 * resets the animation to the initial frame
	 */
	public void reset()
	{
		playedOnce = false;
		currentFrame = 0;
	}

	/**
	 * @return the holding
	 */
	public boolean isHolding() {
		return holding;
	}

	/**
	 * @return the playedOnce
	 */
	public boolean hasPlayedOnce() {
		return playedOnce;
	}

	/**
	 * @return the frames
	 */
	public BufferedImage[] getFrames() {
		return frames;
	}

	/**
	 * @return the delay
	 */
	public long getDelay() {
		return delay;
	}

	/**
	 * @return the hold
	 */
	public boolean isHold() {
		return hold;
	}
	
	private static Animation combineTwoAnimations(Animation a, Animation b)
	{
		return new Animation(ArrayUtil.combine(a.getFrames(), b.getFrames(), new BufferedImage[a.getFrames().length + b.getFrames().length]), a.getDelay(), b.isHold());
	}
	
	public static Animation combine(Animation... arr)
	{
		if(arr.length == 0)
			return null;
		Animation total = arr[0];
		for(int x=1;x<arr.length;x++)
			total = combineTwoAnimations(total, arr[x]);
		return total;
	}
	
	
}
