/**
 * 
 */
package demos.spritedemo;

import configurations.Constants;
import controllers.ArrowKeyController;
import graphics.Animation;
import graphics.SpriteSheet;
import javafx.scene.canvas.GraphicsContext;
import uiitems.UIItem;

/**
 * player class
 * @author Bhagat
 *
 */
public class Player extends UIItem implements ArrowKeyController.Controllable {
	
	private static final long serialVersionUID = 6249898419948056985L;
	private SpriteSheet spritesheet1;
	private SpriteSheet spritesheet2;
	private Animation animation;
	
	
	/**
	 * creates a Player
	 * @param x x position
	 * @param y y position
	 * @param w width
	 * @param h height
	 */
	public Player(double x, double y, double w, double h) {
		super(x, y, w, h);
		System.out.println(Constants.wpercent(10));
		spritesheet1 = new SpriteSheet("res/demos/imgs/Player.png", 22, 1);
		spritesheet2 = new SpriteSheet("res/demos/imgs/Enemy.png", 6, 1);
		animation = Animation.combine(spritesheet1.createAnimation(0, 100, false, 0, 22), spritesheet2.createAnimation(0, 100, false, 0, 6));
	}

	/**
	 * @see uiitems.UIItem#draw(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(animation.getImage(), x, y, w, h);
	}
	
	/**
	 * @see uiitems.UIItem#update(javafx.scene.canvas.GraphicsContext)
	 */
	@Override
	public void update(GraphicsContext gc) {
		animation.update();
		draw(gc);
	}

	@Override
	public void up() {
		y-=Constants.hpercent(1);
	}

	@Override
	public void down() {
		y+=Constants.hpercent(1);
	}

	@Override
	public void right() {
		x+=Constants.wpercent(1);
	}

	@Override
	public void left() {
		x-=Constants.wpercent(1);
	}

}
