/**
 * 
 */
package uiitems;

/**
 * @author Bhagat
 *
 */
public abstract class HealthItem extends UIItem {

	private static final long serialVersionUID = 8857188409232602333L;
	protected int health;
	protected int maxHealth;
	
	/**
	 * creates an Entity affected by gravity
	 * @param x initial x position
	 * @param y initial y position
	 * @param w initial width
	 * @param h initial height
	 * @param maxHealth initial and max health
	 */
	public HealthItem(double x, double y, double w, double h, int maxHealth) {
		super(x, y, w, h);
		this.maxHealth = maxHealth;
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param maxHealth the maxHealth to set
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	
}
