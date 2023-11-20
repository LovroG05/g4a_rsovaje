import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Naloga4 extends Application {
	Timer t = new Timer();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Štoparca");

		VBox root = new VBox();

		HBox display = new HBox();
		Segment s = new Segment();
		Segment s1 = new Segment(s);
		s.nasl = s1;
		Segment s2 = new Segment(s1);
		s1.nasl = s2;

		display.getChildren().addAll(s2.getNode(), s1.getNode(), s.getNode());

		// Buttons
		HBox buttons = new HBox();

		Button startUp = new Button("startUP");
		startUp.setOnAction(e -> {
			t.purge();
			t.cancel();
			t = new Timer();

			s.setStanje(0);
			s1.setStanje(0);
			s2.setStanje(0);

			t.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					try {
						s.up();
					} catch(MOverFlowException e) {
						s.overflow();
					}
				}
			}, 0, 1000);
		});

		Button startDown = new Button("startDown");
		startDown.setOnAction(e -> {
			t.purge();
			t.cancel();
			t = new Timer();

			s.setStanje(9);
			s1.setStanje(9);
			s2.setStanje(9);

			t.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					try {
						s.down();
					} catch(MUnderFlowException e) {
						s.underflow();
					}
				}
			}, 0, 1000);
		});

		Button stop = new Button("stop");
		stop.setOnAction(e -> {
			t.purge();
			t.cancel();
			t = new Timer();
		});

		buttons.getChildren().addAll(startUp, startDown, stop);
		root.getChildren().addAll(display, buttons);

		Scene sc = new Scene(root, 300, 250);
		primaryStage.setScene(sc);
		primaryStage.show();

		sc.getWindow().setOnCloseRequest(windowEvent -> System.exit(0));
	}
}