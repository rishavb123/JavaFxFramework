package uiitems;

import configurations.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * a background class for the background of the window
 * @author Bhagat
 *
 */
public class Background extends UIItem {

	private static final long serialVersionUID = -5028651709267229347L;
	private Image image;
	private Color backgroundColor;
	private Color cover;
	
	public Background()
	{
		w = 0;
		backgroundColor = Color.rgb(0, 0, 0, 0);
		cover = Color.rgb(0, 0, 0, 0);
	}
	
	/**
	 * creates a background object based on only the image path
	 * @param path the image path
	 */
	public Background(String path) 
	{
		if(path!=null) image = new Image(path);
		w = Constants.width;
		backgroundColor = Color.rgb(0, 0, 0, 0);
		cover = Color.rgb(0, 0, 0, 0);
	}
	
	/**
	 * creates a background object with a specified width and background color
	 * @param path the image path
	 * @param width width of the image
	 * @param backgroundColor color behind the image
	 */
	public Background(String path, int width, Color backgroundColor) 
	{
		if(path!=null) image = new Image(path);
		super.w = w;
		this.backgroundColor = backgroundColor;
		this.cover = Color.rgb(0, 0, 0, 0);
	}
	
	/**
	 * creates a background object based on the image path and a cover
	 * @param path the image path
	 * @param cover the color that goes over the image
	 */
	public Background(String path, Color cover) 
	{
		if(path!=null) image = new Image(path);
		w = Constants.width;
		backgroundColor = Color.rgb(0, 0, 0, 0);
		this.cover = cover;
	}
	
	/**
	 * creates a background object with all attributes
	 * @param path the image path
	 * @param width the image width
	 * @param backgroundColor the color behind the image
	 * @param cover the color that goes over the image
	 */
	public Background(String path, int w, Color backgroundColor, Color cover) 
	{
		if(path!=null) image = new Image(path);
		this.w = w;
		this.backgroundColor = backgroundColor;
		this.cover = cover;
	}

	/**
	 * Draws the background
	 */
	@Override
	public void draw(GraphicsContext gc) 
	{
		gc.clearRect(0, 0, Constants.width, Constants.height);
		gc.setFill(backgroundColor);
		gc.fillRect(0, 0, Constants.width, Constants.height);
		gc.drawImage(image, (Constants.width - w)/2.0, 0, w, Constants.height);
		gc.setFill(cover);
		gc.fillRect(0, 0, Constants.width, Constants.height);
	}

	/**
	 * gets the background image
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * sets the background image
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * sets the width
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.w = width;
	}

	/**
	 * gets the background color
	 * @return the current background color
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * sets the background color
	 * @param backgroundColor the background color to set
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * gets the color of the cover
	 * @return the color of the cover
	 */
	public Color getCover() {
		return cover;
	}

	/**
	 * sets the covers color
	 * @param cover the cover to be set
	 */
	public void setCover(Color cover) {
		this.cover = cover;
	}

}
