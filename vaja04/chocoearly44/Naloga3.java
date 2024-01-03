import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Naloga3 extends Application {
	private static final Pane pane = new Pane();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		BinarySearchTree bst = new BinarySearchTree();

		HBox gumbi = new HBox();
		TextField tf = new TextField();

		Button btn = new Button("Dodaj");
		btn.setOnAction(actionEvent -> {
			bst.insert(Integer.parseInt(tf.getText()));
			displayNode(bst.root, 1, 400);
		});

		gumbi.getChildren().addAll(tf, btn);

		VBox root = new VBox();
		VBox.setVgrow(pane, Priority.ALWAYS);
		root.getChildren().addAll(pane, gumbi);

		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
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