package uiitems;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author Bhagat
 *
 */
public class ProgressBar extends UIItem {

	private static final long serialVersionUID = -6155311257681253685L;
	private Color color;
	private int max;
	private int value;
	private double ratio;

	
	/**
	 * creates a progress bar that is filled based on the percentage of value of the max
	 * @param max maximum value that fills the progress bar
	 * @param x x position
	 * @param y y position
	 * @param width width of the bar
	 * @param height height of the bar
	 * @param color color of the filled bar
	 */
	public ProgressBar(int max, double x, double y, double width, double height, Color color) {
		super.x = x;
		super.y = y;
		this.w = width;
		this.h = height;
		this.color = color;
		this.max = max;
		value = 0;
	}
	
	/**
	 * @see uiitems.UIItem#update(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void update(GraphicsContext gc)
	{
		ratio = (double)value/max;
		
		draw(gc);
	}

	/**
	 * @see uiitems.UIItem#draw(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void draw(GraphicsContext gc)
	{
		gc.setFill(color);
		gc.fillRect(x, y, w*ratio, h);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(x, y, w, h);
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @return the ratio
	 */
	public double getRatio() {
		return ratio;
	}

}
