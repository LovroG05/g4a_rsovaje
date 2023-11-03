import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test3jfx extends Application {
	private static Test2kacica kacica = new Test2kacica(4);

	private static Group root = new Group();
	private static Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		scene = new Scene(root, 800, 600);

		primaryStage.setTitle("Kachacha");
		primaryStage.setScene(scene);
		primaryStage.show();

		scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
			switch(ke.getCode()) {
				case LEFT -> kacica.obrniLevo();
				case RIGHT -> kacica.obrniDesno();
			}

			ke.consume();
		});

		new Thread(() -> {
			try {
				while(true) {
					if(kacica.naprej(5)) {
						Platform.runLater(Test3jfx::redraw);
						Thread.sleep(100);
					} else {
						Platform.runLater(Test3jfx::konecIgre);
						break;
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	private static void konecIgre() {
		root.getChildren().clear();
		scene.setFill(Color.RED);
	}

	private static void redraw() {
		root.getChildren().clear();

		kacica.getKaca().forEach(el -> {
			Rectangle shape = new Rectangle();
			shape.setFill(el.barva);
			shape.setX(el.koordinata.x());
			shape.setY(el.koordinata.y());
			shape.setWidth(2);
			shape.setHeight(2);

			root.getChildren().add(shape);
		});

		kacica.getOvire().forEach((element, el) -> {
			Rectangle shape = new Rectangle();
			shape.setX(el.koordinata.x());
			shape.setY(el.koordinata.y());
			shape.setWidth(2);
			shape.setHeight(2);

			root.getChildren().add(shape);
		});
	}
}
