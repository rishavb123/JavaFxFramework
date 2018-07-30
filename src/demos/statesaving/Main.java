package demos.statesaving;

import java.util.concurrent.Callable;

import application.App;
import controllers.ArrowKeyController;
import controllers.MouseController;
import controllers.WASDController;
import demos.controllerdemos.mousecontrollerexample.Person;
import framework.State;

/**
 * same as {@link demos.controllerdemos.mousecontrollerexample.Main} with state saving
 * @author Bhagat
 *
 */
public class Main {

	/**
	 * the main method
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		App.begin(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				
				State.gameState.load("res/binary/statesavingdemo.bin");
				Person p = (Person) State.gameState.getFromStorage("person");
				
//				Person p = new Person(0,0);
//				State.gameState.store("person", p);
				
				ArrowKeyController controller = new ArrowKeyController(p);
				WASDController controller2 = new WASDController(p);
				MouseController controller3 = new MouseController(p);
				controller.connect();
				controller2.connect();
				controller3.connect();
				
//				State.gameState.add(p);
				
				return null;
			}
			
		}, null, new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				State.gameState.save("res/binary/statesavingdemo.bin");
				return null;
			}
			
		}, args);
		
	}

}
