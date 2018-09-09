/**
 * 
 */
package demos.helloworld;

import java.util.concurrent.Callable;

import application.App;
import configurations.Constants;
import framework.State;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import uiitems.UIText;

/**
 * main class file for hello world project
 * @author Bhagat
 *
 */
public class Main 
{	
	/**
	 * main method for hello world project
	 * @param args cmd args
	 */
	public static void main(String[] args)
	{
		App.create(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				UIText t = UIText.centerText("Hello, World!", 0, 30, Constants.width, FontWeight.BOLD, Color.BLUEVIOLET);
				State.gameState.add(t);
				State.gameState.store("UIText", t);
				State.gameState.store("dy", 0);
				return null;
			}
			
		}, new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				int dy = (int)State.gameState.getFromStorage("dy");
				UIText t = (UIText)State.gameState.getFromStorage("UIText");
				if(dy>20)
					dy*=-1;
				dy++;
				State.gameState.store("dy", dy);
				t.setY(t.getY()+dy);
				if(t.getY() > Constants.height)
				{
					t.setY(0);
					State.gameState.store("dy", 0);
				}
				return null;
			}
			
		}, null, args);
		
	}
}
