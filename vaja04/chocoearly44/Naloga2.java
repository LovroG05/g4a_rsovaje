import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Naloga2 extends Application {
	private final XYChart.Series<String, Number> series = new XYChart.Series<>();

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

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		barChart.getData().add(series);

		Scene scene = new Scene(barChart, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

		traverse(bst.root, 1);
	}

	private void traverse(BinarySearchTree.Node node, int steps) {
		System.out.println(node.data);
		series.getData().add(new XYChart.Data<>(String.valueOf(node.data), steps));
		steps++;

		if(node.left != null) {
			traverse(node.left, steps);
		}

		if(node.right != null) {
			traverse(node.right, steps);
		}
	}
}
