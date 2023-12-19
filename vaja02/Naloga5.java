import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Naloga5 extends Application {
	private Group root = new Group();
	private static final double K = (double) 1 / 3;

	int OFFSET = 400;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(root, 800, 800);
		primaryStage.setTitle("Drevo");
		primaryStage.setScene(scene);
		primaryStage.show();

		drawLine(0, 300, 0);
	}

	private void drawLine(int startX, int startY, int endX) {
		int deltaX = endX - startX;
		double dolzina = Math.sqrt(deltaX * deltaX + startY * startY);

		System.out.println(dolzina);

		// Črta se bo zaradi konstantnega odmika začela daljšati, zaradi tega ne preverimo dolžine 5
		if(dolzina < 138) {
			return;
		}

		double hipo = dolzina * K;
		double kateta = K * deltaX;
		double c = Math.sqrt(hipo * hipo - kateta * kateta);

		// Zamaknemo še za OFFSET na X sredino in OFFSET / 2 na Y sredino ("geometrijska sredina")
		root.getChildren().add(new Line(OFFSET + startX, (OFFSET / 2) + startY, OFFSET + endX, OFFSET / 2));
		drawLine(startX + (int) (K * deltaX), startY - (int) c, startX + deltaX + 50);
	}
}