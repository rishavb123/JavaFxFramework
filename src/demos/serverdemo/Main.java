package demos.serverdemo;

import java.util.concurrent.Callable;

import application.App;
import server.Server;
import framework.State;
import javafx.scene.input.KeyCode;

public class Main {

	public static void main(String[] args)
	{
		App.create(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Server server = new Server(3000, 100, true);
				server.start();
				State.gameState.track(KeyCode.SPACE);
				State.gameState.getKeyboard().get(KeyCode.SPACE).setOnClick(new Callable<Void>() {

					@Override
					public Void call() throws Exception {
						server.send("Hello World");
						return null;
					}});
				return null;
			}
		},
		new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				return null;
			}
		}, new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				return null;
			}
		}, args);
		
	}
	
}
