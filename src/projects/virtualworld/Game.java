package projects.virtualworld;

import application.App;
import configurations.Constants;
import framework.State;
import javafx.scene.paint.Color;

/**
 * @author Bhagat
 *
 */
public class Game extends App {

	/**
	 * @see application.App#start()
	 */
	@Override
	public void start() 
	{
		boolean exists = State.gameState.load("res/binary/world.bin");
		if(exists)
		{
			System.out.println("exists");
		}
		else
		{
			State.gameState.add(new Player(400, 100, 20, Color.BLUE));
		}
	}

	/**
	 * @see application.App#end()
	 */
	@Override
	public void end() 
	{
		if(!Constants.dev)
			State.gameState.save("res/binary/world.bin");
	}

	/**
	 * @see application.App#update(long)
	 */
	@Override
	public void update(long time) 
	{
		
	}
	
	/**
	 * main method
	 * @param args cmd args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

	

}
