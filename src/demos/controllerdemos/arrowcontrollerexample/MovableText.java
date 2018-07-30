package demos.controllerdemos.arrowcontrollerexample;

import configurations.Constants;
import controllers.ArrowKeyController;
import controllers.WASDController;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import uiitems.UIText;

/**
 * UIText that is movable through the keyboard
 * @author Bhagat
 *
 */
public class MovableText extends UIText implements ArrowKeyController.Controllable, WASDController.Controllable {

	private static final long serialVersionUID = -2488912190555003194L;

	/**
	 * creates a UIText object
	 * @param text the text to display
	 * @param x x position
	 * @param y y position
	 * @param size font size
	 * @param f font weight
	 * @param color font color
	 */
	public MovableText(String text, double x, double y, int size, FontWeight f, Color color) {
		super(text, x, y, size, f, color);
	}

	/**
	 * @see controllers.ArrowKeyController#up()
	 */
	@Override
	public void up() {
		y-=Constants.dim/100.0;
	}

	/**
	 * @see controllers.ArrowKeyController#down()
	 */
	@Override
	public void down() {
		y+=Constants.dim/100.0;
	}

	/**
	 * @see controllers.ArrowKeyController#right()
	 */
	@Override
	public void right() {
		x+=Constants.dim/100.0;
	}

	/**
	 * @see controllers.ArrowKeyController#left()
	 */
	@Override
	public void left() {
		x-=Constants.dim/100.0;	
	}
	
	/**
	 * create a movable text object that is centered within width
	 * @param text the text to display
	 * @param y the y position
	 * @param size the font size
	 * @param width the width of where to be centered
	 * @param f font weight
	 * @param color font color
	 * @return the created MovableText object
	 */
	public static MovableText centerMovableText(String text, double y, int size, double width, FontWeight f, Color color)
	{ 
		return new MovableText(text, centerText(text, y, size, width, f, color).getX(), y, size, f, color);
	}

}
