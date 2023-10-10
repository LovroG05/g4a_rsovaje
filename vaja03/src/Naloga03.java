import javafx;
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
public class Naloga03 extends Application {

    private LinkedList<RTocka> seznamTock;
    private int currentIndex = 0; // Indeks trenutne točke
    private Pane canvas; // Platno za risanje

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        seznamTock = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            seznamTock.add(new RTocka(5 + i, 4, Color.YELLOW));
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

        for (RTocka tocka : seznamTock) {
            Circle circle = new Circle(tocka.x(), tocka.y(), 5);
            circle.setFill(tocka.barva());
            canvas.getChildren().add(circle);
        }
    }

    private void moveClockwise() {
        currentIndex = (currentIndex + 1) % seznamTock.size();
        drawSnake();
    }

    private void moveCounterClockwise() {
        currentIndex = (currentIndex - 1 + seznamTock.size()) % seznamTock.size();
        drawSnake();
    }

    private void moveInCurrentDirection() {
        RTocka currentPoint = seznamTock.get(currentIndex);
        currentIndex = (currentIndex + 1) % seznamTock.size();

        // Ustvarimo novo točko v isti smeri z rdečo barvo
        int newX = currentPoint.x() + 1;
        Color newColor = Color.RED;

        RTocka newPoint = new RTocka(newX, currentPoint.y(), newColor);
        seznamTock.add(currentIndex, newPoint);

        drawSnake();
    }
}
