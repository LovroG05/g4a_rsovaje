import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Naloga4 extends Application {
	private static final LinkedList<Circle> kaca = new LinkedList<>();
	private static Vektor2d glavaVektor = new Vektor2d(1, 0);

	private static final Pane canvas = new Pane();

	public static void main(String[] args) {
		for(int i = 5; i < 12; i++) {
			kaca.add(new Circle(i * 20, 10 * 20, 10, Color.RED));
		}

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();

		Button cw = new Button("CW");
		cw.setOnAction(actionEvent -> {
			Vektor2d star = glavaVektor;
			glavaVektor = new Vektor2d(-star.y(), star.x());
			move();
		});

		Button ccw = new Button("CCW");
		ccw.setOnAction(actionEvent -> {
			Vektor2d star = glavaVektor;
			glavaVektor = new Vektor2d(star.y(), -star.x());
			move();
		});

		Button nap = new Button("NAP");
		nap.setOnAction(actionEvent -> move());

		VBox.setVgrow(canvas, Priority.ALWAYS);

		HBox gumbi = new HBox();
		gumbi.getChildren().addAll(cw, ccw, nap);

		root.getChildren().addAll(canvas, gumbi);

		redraw();
	}

	private static void move() {
		kaca.removeFirst();
		Circle ls = kaca.getLast();
		kaca.addLast(
				new Circle(
						ls.getCenterX() + glavaVektor.x() * 20,
						ls.getCenterY() + glavaVektor.y() * 20,
						10,
						Color.RED
				)
		);

		redraw();
	}

	private static void redraw() {
		canvas.getChildren().clear();
		kaca.forEach(canvas.getChildren()::add);
	}

	public record Vektor2d(int x, int y) {
	}
}