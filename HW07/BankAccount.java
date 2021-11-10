import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class creates a GUI for a bank account.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class BankAccount extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bank Account");
        primaryStage.minHeightProperty().set(500);
        BackgroundImage k = new BackgroundImage(new Image("file:tech.png"), BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        BorderPane root = new BorderPane();
        root.setBackground(new Background(k));

        StackPane stack = new StackPane();
        stack.setMaxWidth(25.0);
        Circle circle = new Circle(25, 25, 25);
        circle.setFill(Color.WHITE);
        Text text = new Text("$4.20");
        stack.getChildren().addAll(circle, text);

        root.setTop(stack);
        BorderPane.setAlignment(stack, Pos.TOP_RIGHT);

        Rectangle rect = new Rectangle(90, 50);
        root.setCenter(rect);
        BorderPane.setAlignment(rect, javafx.geometry.Pos.CENTER);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
