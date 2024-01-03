import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Naloga1 extends Application {
	private static final Pane pane = new Pane();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(22);
		bst.insert(12);
		bst.insert(2);
		bst.insert(5);

		primaryStage.setScene(new Scene(pane, 800, 600));
		primaryStage.show();

		displayNode(bst.root, 1, 400);
	}

	private static void displayNode(BinarySearchTree.Node node, int depth, int center) {
		int centerY = 50 * depth;
		depth++;
		int polovicaX = 800 / (int) (Math.pow(2, depth));

		if(node.left != null) {
			int newX = center - polovicaX;

			pane.getChildren().add(new Line(center, centerY, newX, depth * 50));
			displayNode(node.left, depth, newX);
		}

		if(node.right != null) {
			int newX = center + polovicaX;

			pane.getChildren().add(new Line(center, centerY, newX, depth * 50));
			displayNode(node.right, depth, newX);
		}

		pane.getChildren().addAll(
				new Circle(center, centerY, 20, Color.GREEN),
				new Text(center, centerY, String.valueOf(node.data))
		);
	}
}