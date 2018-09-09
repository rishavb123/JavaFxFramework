/**
 * 
 */
package uiitems.interactiveitems;

import graphics.SerializableColor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import uiitems.ImmovableItem;
import uiitems.UIItem;
import uiitems.gravityitems.Gravity;
import util.RectUtil;

/**
 * Block Class for gravity items
 * @author Bhagat 
 */
public class Block extends ImmovableItem implements Interactive{

	private static final long serialVersionUID = -8356731719769183064L;
	private SerializableColor color;

	public Block(double x, double y, double w, double h, Color c) {
		super(x, y, w, h);
		color = new SerializableColor(c);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(Color.BLACK);
		gc.setFill(color.getColor());
		RectUtil.stroke(gc, getRect());
		RectUtil.fill(gc, getRect());
	}

	@Override
	public void touchAbove(UIItem u) {
		if(u instanceof Gravity)
		{
			((Gravity) u).setDy(Math.abs(((Gravity) u).getDy())*-1);
		}
		u.setY(y-u.getHeight());
	}

	@Override
	public void touchBelow(UIItem u) {
		if(u instanceof Gravity)
		{
			((Gravity) u).setDy(Math.abs(((Gravity) u).getDy())/5);
		}
		u.setY(y+h);
	}

	@Override
	public void touchLeft(UIItem u) {
		if(u instanceof Gravity)
		{
			((Gravity) u).setDx(Math.abs(((Gravity) u).getDx())/-5);
		}
		u.setX(x-u.getWidth());
	}

	@Override
	public void touchRight(UIItem u) {
		if(u instanceof Gravity)
		{
			((Gravity) u).setDx(Math.abs(((Gravity) u).getDx())/5);
		}	
		u.setX(x+w);
	}

}
