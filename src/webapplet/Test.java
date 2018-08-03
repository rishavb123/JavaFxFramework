package webapplet;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

public class Test extends FXApplet {


	private static final long serialVersionUID = -2391328679577614131L;

	public void initApplet() {
		Label label = new Label("Hello World!");
        root.getChildren().add(label);

        Canvas canvas = new Canvas(1200, 600);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.fillRect(25,25,250,250);
    }

}
