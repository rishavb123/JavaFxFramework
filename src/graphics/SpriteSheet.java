package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 * sprite sheet class to make animations
 * @author Bhagat
 */
public class SpriteSheet {
	
	private int spriteWidth;
	private int spriteHeight;
	
	private BufferedImage spritesheet;
	private BufferedImage[][] frames;

	/**
	 * creates a sprite sheet object to make animations
	 * @param path the image path for the entire sprite sheet
	 * @param delay the millisecond delay between each frame
	 * @param hold whether or not to hold the animation at the last frame
	 * @param framesWidth the number of frames from side to side
	 * @param framesHeight the number of frames from top to bottom
	 */
	public SpriteSheet(String path, int framesWidth, int framesHeight)
	{
		
		try {
			spritesheet = ImageIO.read(this.getClass().getResourceAsStream("../../"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		spriteWidth = spritesheet.getWidth()/framesWidth;
		spriteHeight = spritesheet.getHeight()/framesHeight;
		
		frames = new BufferedImage[framesHeight][framesWidth];
		setFrames();
	}
	
	/**
	 * splits the sprite sheet up into the frames array
	 */
	public void setFrames()
	{
		for(int x = 0; x < frames.length; x++)
		{
			for(int y = 0; y < frames[x].length; y++)
				frames[x][y] = spritesheet.getSubimage(y*spriteWidth, x*spriteHeight, spriteWidth, spriteHeight);
		}
	}
	
	/**
	 * returns the JavaFX Image from the frames
	 * @param x the x or the first index from the frames array
	 * @param y the x or the second index from the frames array
	 * @return the JavaFX Image from the frames
	 */
	public Image getImage(int x, int y)
	{
		return SwingFXUtils.toFXImage(frames[x][y], null);
	}
	
	public Animation createAnimation(int row, long delay, boolean hold, int start, int stop)
	{
		return new Animation(Arrays.copyOfRange(frames[row], start, stop), delay, hold);
	}

	/**
	 * get the sub image of a Java FX Image object
	 * @param fxi the Java FX to be cut
	 * @param x the x position of the sub image in the Java FX image
	 * @param y the y position of the sub image in the Java FX image
	 * @param width the width of the sub image in the Java FX image
	 * @param height the height of the sub image in the Java FX image
	 * @return the sub image of the image
	 */
	public static Image getImage(Image fxi, int x, int y, int width, int height)
	{
		return SwingFXUtils.toFXImage(SwingFXUtils.fromFXImage(fxi, null).getSubimage(x, y, width, height), null);
	}
	
}
