/**
 * 
 */
package graphics;

import java.io.Serializable;

import javafx.scene.paint.Color;

/**
 * @author Bhagat
 *
 */
public class SerializableColor implements Serializable {

	private static final long serialVersionUID = -2617748929012759394L;
	private int r;
	private int g;
	private int b;
	private double a;
	
	public SerializableColor(Color c)
	{
		r = ((int)c.getRed())*255;
		b = ((int)c.getBlue())*255;
		g = ((int)c.getGreen())*255;
		a = c.getOpacity();
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return Color.rgb(r, g, b, a);
	}

}
