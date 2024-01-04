import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Naloga2 extends Application {
	private static Sistem sistem = new Sistem();
	private final TableView<User> tableView = new TableView<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		TableColumn<User, Integer> numberColumn = new TableColumn<>("Number");
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

		TableColumn<User, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<User, String> nickColumn = new TableColumn<>("Nick");
		nickColumn.setCellValueFactory(new PropertyValueFactory<>("nick"));

		TableColumn<User, Integer> scoreColumn = new TableColumn<>("Score");
		scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

		TableColumn<User, Integer> igerColumn = new TableColumn<>("Iger");
		igerColumn.setCellValueFactory(new PropertyValueFactory<>("iger"));

		TableColumn<User, String> datumColumn = new TableColumn<>("Datum");
		datumColumn.setCellValueFactory(new PropertyValueFactory<>("datum"));

		tableView.getColumns().addAll(numberColumn, nameColumn, nickColumn, scoreColumn, igerColumn, datumColumn);

		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		Runnable task = () -> Platform.runLater(() -> updateTable());
		scheduler.scheduleAtFixedRate(task, 0, 2, TimeUnit.MINUTES);

		Scene scene = new Scene(tableView, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void updateTable() {
		tableView.getItems().clear();

		for(User u : sistem.getTable()) {
			tableView.getItems().add(u);
		}
	}
}