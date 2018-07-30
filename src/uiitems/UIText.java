package uiitems;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Text to be displayed
 * @author Bhagat
 *
 */
public class UIText extends UIItem {

	private static final long serialVersionUID = 5831282591115071458L;
	private Font font;
	private Text text;
	protected Color color;
	
	/**
	 * creates a new UIText object
	 * @param text what text will be displayed
	 * @param x x position
	 * @param y y position
	 * @param size text size
	 * @param f font weight
	 * @param color font color
	 */
	public UIText(String text, double x, double y, int size, FontWeight f, Color color) 
	{
		this.text = new Text(text);
		super.x = x;
		super.y = y;
		this.font = Font.font("Courier New", f, size);
		this.text.setFont(font);
		w = this.text.getLayoutBounds().getWidth();
		this.color = color;
	}
	
	/**
	 * @see uiitems.UIItem#draw(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void draw(GraphicsContext gc) 
	{
		gc.setFill(color);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		gc.setFont(font);
		gc.fillText(text.getText(), x, y);
		gc.fillText(text.getText(), x, y);
	}
	
	/**
	 * change the text
	 * @param text the text to set
	 */
	public void setText(String text)
	{
		this.text.setText(text);
	}
	
	/**
	 * gets the text being displayed
	 * @return the text
	 */
	public String getText()
	{
		return this.text.getText();
	}
	
	/**
	 * setter for x
	 * @param x the new x position
	 */
	public void setX(double x)
	{
		this.x = x;
	}
	
	/**
	 * setter for y
	 * @param y the new y position
	 */
	public void setY(double y)
	{
		this.y = y;
	}
	
	/**
	 * gives a UIText object that is centered within the width
	 * @param text the text to display
	 * @param y y position
	 * @param size font size
	 * @param width width of where you want to center it
	 * @param f font weight
	 * @param color font color
	 * @return the created UIText object
	 */
	public static UIText centerText(String text, double y, int size, double width, FontWeight f, Color color) 
	{
		
		Text t = new Text(text);
		t.setFont(Font.font("Courier New", f, size));
		
		double tw = t.getLayoutBounds().getWidth();
		
		int x = (int)((width-tw)/2);
		
		return new UIText(text, x, y, size, f, color);
		
	}


}
