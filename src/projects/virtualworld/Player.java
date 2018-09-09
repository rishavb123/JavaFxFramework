/**
 * 
 */
package projects.virtualworld;

import controllers.MouseController;
import controllers.WASDController;
import javafx.scene.paint.Color;

/**
 * @author Bhagat
 *
 */
public class Player extends Person {

	private static final long serialVersionUID = 2619202762223175829L;
	private MouseController mouseController;
	private WASDController wasdController;

	public Player(double cx, double cy, double r, Color color) {
		super(cx, cy, r, color);
		
		setMouseController(new MouseController(this));
		setWasdController(new WASDController(this));
		
		mouseController.connect();
		wasdController.connect();
		
	}

	/**
	 * @return the mouseController
	 */
	public MouseController getMouseController() {
		return mouseController;
	}

	/**
	 * @param mouseController the mouseController to set
	 */
	public void setMouseController(MouseController mouseController) {
		this.mouseController = mouseController;
	}

	/**
	 * @return the wasdController
	 */
	public WASDController getWasdController() {
		return wasdController;
	}

	/**
	 * @param wasdController the wasdController to set
	 */
	public void setWasdController(WASDController wasdController) {
		this.wasdController = wasdController;
	}
	

}
