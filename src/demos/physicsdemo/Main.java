package demos.physicsdemo;

import java.util.concurrent.Callable;

import application.App;
import configurations.Constants;
import framework.State;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import uiitems.UIText;
import uiitems.interactiveitems.Block;
import util.ArrayUtil;
import util.GraphicsUtil;
import util.NumberUtil;

/**
 * physics demo
 * @author Bhagat
 *
 */
public class Main extends App {

	/**
	 * called on start of the application
	 * @see application.App@start()
	 */
	@Override
	public void start()
	{
		UIText text = new UIText(Double.toString(Ball.pull), 1, 100, 30, FontWeight.BOLD, Color.BLUE);
//		State.gameState.store("Pull Text", text);
		State.gameState.track(ArrayUtil.newArrayList(
				KeyCode.UP, KeyCode.DOWN, KeyCode.C
		));
		State.gameState.getKeyboard().get(KeyCode.UP).setOnClick(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Ball.pull+=10;
				text.setText(Double.toString(Ball.pull));
				return null;
			}
			
		});
		State.gameState.getKeyboard().get(KeyCode.DOWN).setOnClick(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Ball.pull-=10;
				text.setText(Double.toString(Ball.pull));
				return null;
			}
			
		});
		State.gameState.getKeyboard().get(KeyCode.C).setOnClick(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				State.gameState.clear();
				State.gameState.add(text);
				return null;
			}
			
		});
		State.gameState.add(text);
		
		for(int i=0; i<100; i++)
		{
			Ball b = new Ball(NumberUtil.rand(0, (int)Constants.width-20), NumberUtil.rand(0, (int)Constants.height-20), 20, Color.rgb(NumberUtil.rand(0, 255), NumberUtil.rand(0, 255), NumberUtil.rand(0, 255)));;
			b.setDx(NumberUtil.rand(-20, 20));
			b.setDy(NumberUtil.rand(-40, 40));
			State.gameState.add(b);
		}
		
		for(int i=0; i<200; i+=10)
			State.gameState.add(new Block(Constants.hpercent(i), Constants.hpercent(90), Constants.hpercent(10), Constants.hpercent(10), Color.ALICEBLUE));
			
		State.gameState.getMouse().setOnPress(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				for(int i=0; i<100; i++)
				{
					Ball b = new Ball(NumberUtil.rand(0, (int)Constants.width-20), NumberUtil.rand(0, (int)Constants.height-20), 20, GraphicsUtil.randomColor());
					b.setDx(NumberUtil.rand(-20, 20));
					b.setDy(NumberUtil.rand(-40, 40));
					State.gameState.add(b);
				}
				return null;
			}
			
		});
	}

	/**
	 * called when the application is closing
	 * @see application.App#end()
	 */
	@Override
	public void end() 
	{
		
	}

	/**
	 * called every frame
	 * @see application.App#update(long)
	 */
	@Override
	public void update(long time) 
	{

	}
	
	/**
	 * main method calling the launch method
	 * @param args command line arguments
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

}
