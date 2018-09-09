package projects.virtualworld;

import configurations.Constants;
import controllers.MouseController;
import controllers.WASDController;
import graphics.SerializableColor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import uiitems.UIItem;

/**
 * @author Bhagat
 *
 */
public class Person extends UIItem implements MouseController.Controllable, WASDController.Controllable{

	private static final long serialVersionUID = 1584092554042613215L;
	protected double cx;
	protected double cy;
	protected double r;	
	protected double dx;
	protected double dy;
	protected SerializableColor color;
	
	public Person(double cx, double cy, double r, Color color) {
		super(cx - r/2.0, cy - r/2.0, r*2, r*2);
		this.color = new SerializableColor(color);
		this.cx = cx;
		this.cy = cy;
		this.r = r;
		dx = Constants.wpercent(0.75);
		dy = dx;
		System.out.println(dx);
	}

	@Override
	public void update(GraphicsContext gc) {
		x = cx - r/2.0;
		y = cy - r/2.0;
		draw(gc);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(color.getColor());
		gc.fillOval(x, y, w, h);
	}

	/**
	 * @return the cx
	 */
	public double getCx() {
		return cx;
	}

	/**
	 * @param cx the cx to set
	 */
	public void setCx(double cx) {
		this.cx = cx;
	}

	/**
	 * @return the cy
	 */
	public double getCy() {
		return cy;
	}

	/**
	 * @param cy the cy to set
	 */
	public void setCy(double cy) {
		this.cy = cy;
	}

	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}
	
	/**
	 * @return the color
	 */
	public Color getColor()
	{
		return color.getColor();
	}
	
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color)
	{
		this.color = new SerializableColor(color);
	}

	/**
	 * @param r the r to set
	 */
	public void setR(double r) {
		this.r = r;
	}

	@Override
	public void mouseMoved(double x, double y) {
		
	}

	@Override
	public void mousePressed(double x, double y) {
		
	}

	@Override
	public void mouseReleased(double x, double y) {
		
	}

	@Override
	public void up() {
		if(y-dy>0)
			cy-=dy;
	}

	@Override
	public void down() {
		if(y+h+dy<Constants.height)
			cy+=dy;
	}

	@Override
	public void right() {
		if(x+w+dx<Constants.width)
			cx+=dx;
	}

	@Override
	public void left() {
		if(x-dx>=0)
			cx-=dx;
	}

}
