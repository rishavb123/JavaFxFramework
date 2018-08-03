/**
 * 
 */
package uiitems;

import javafx.scene.canvas.GraphicsContext;

/**
 * A hidden item that will have functionality but will not be displayed
 * @author Bhagat
 *
 */
public abstract class HiddenItem extends UIItem {


	private static final long serialVersionUID = -7045007457815025608L;

	/**
	 * creates a hidden item that will not be display be may still have functionality
	 */
	public HiddenItem() {
		super(0, 0, 0, 0);
	}

	/**
	 * draw method that will not draw anything
	 * @see uiitems.UIItem#draw(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public final void draw(GraphicsContext gc) {}

	/**
	 * update method that will not call the draw method but will instead call the update method without any params
	 * @see uiitems.UIItem#update(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void update(GraphicsContext gc)
	{
		update();
	}
	
	/**
	 * method to be called every frame
	 */
	public abstract void update();
}
