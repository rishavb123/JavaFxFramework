/**
 * 
 */
package uiitems;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author Bhagat
 *
 */
public abstract class ImmovableItem extends UIItem {

	private static final long serialVersionUID = 8115205652123561778L;
	private final double ix;
	private final double iy;
	private final double iw;
	private final double ih;
	
	/**
	 * Constructs an immovable item
	 * @param x the x position
	 * @param y the y position
	 * @param w the width
	 * @param h the height
	 */
	public ImmovableItem(double x, double y, double w, double h) {
		super(x, y, w, h);
		ix = x;
		iy = y;
		iw = w;
		ih = h;
	}

	/**
	 * @see uiitems.UIItem#update(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void update(GraphicsContext gc) {
		x = ix;
		y = iy;
		w = iw;
		h = ih;
		super.update(gc);
	}

}
