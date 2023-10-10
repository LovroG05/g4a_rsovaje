import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.LinkedList;
// ni testirano ker nisem uspel usposobiti javafx

public class Naloga04 extends Application {

    private LinkedList<Circle> seznamKrogov;
    private int currentIndex = 0; // Indeks trenutnega kroga
    private Pane canvas; // Platno za risanje

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        seznamKrogov = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            Circle krog = new Circle(5 + i, 4, 5); // Ustvarimo krog s središčem in radijem
            krog.setFill(Color.YELLOW);
            seznamKrogov.add(krog);
        }

        canvas = new Pane();
        drawSnake(); // Izrišemo kačo

        Button cwButton = new Button("CW"); // Premakne zaporedje v smeri urinega kazalca
        Button ccwButton = new Button("CCW"); // Premakne zaporedje v nasprotni smeri urinega kazalca
        Button napButton = new Button("NAP"); // Premakne zaporedje v obstoječi smeri

        cwButton.setOnAction(e -> moveClockwise());
        ccwButton.setOnAction(e -> moveCounterClockwise());
        napButton.setOnAction(e -> moveInCurrentDirection());

        HBox buttonBox = new HBox(10, cwButton, ccwButton, napButton);
        buttonBox.setLayoutX(20);
        buttonBox.setLayoutY(350);

        canvas.getChildren().add(buttonBox);

        Scene scene = new Scene(canvas, 400, 400);
        primaryStage.setTitle("Snake App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawSnake() {
        canvas.getChildren().clear(); // Počistimo platno

        for (Circle krog : seznamKrogov) {
            canvas.getChildren().add(krog);
        }
    }

    private void moveClockwise() {
        currentIndex = (currentIndex + 1) % seznamKrogov.size();
        drawSnake();
    }

    private void moveCounterClockwise() {
        currentIndex = (currentIndex - 1 + seznamKrogov.size()) % seznamKrogov.size();
        drawSnake();
    }

    private void moveInCurrentDirection() {
        currentIndex = (currentIndex + 1) % seznamKrogov.size();
        seznamKrogov.get(currentIndex).setFill(Color.RED); // Spremenimo barvo trenutnega kroga
        drawSnake();
    }
}

