/**
 * 
 */
package uiitems.entities;

import uiitems.gravityitems.Gravity;

/**
 * @author Bhagat
 *
 */
public abstract class GravityEntity extends Entity implements Gravity {

	private static final long serialVersionUID = -1677734747794413545L;

	/**
	 * creates an Entity affected by gravity
	 * @param x initial x position
	 * @param y initial y position
	 * @param w initial width
	 * @param h initial height
	 * @param maxHealth initial and max health
	 */
	public GravityEntity(double x, double y, double w, double h, int maxHealth) {
		super(x, y, w, h, maxHealth);
	}

}
