import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BankAccount extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bank Account");
        primaryStage.minHeightProperty().set(500);
        BackgroundImage k = new BackgroundImage(new Image("file:tech.png"), BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        BorderPane root = new BorderPane();
        root.setBackground(new Background(k));

        //TODO fix circle position
        StackPane stack = new StackPane();
        Circle circle = new Circle(25, 25, 25);
        Text text = new Text("$4.20");
        stack.getChildren().addAll(circle, text);
        StackPane.setAlignment(stack, javafx.geometry.Pos.TOP_RIGHT);
        root.setTop(stack);
        BorderPane.setAlignment(stack, javafx.geometry.Pos.TOP_RIGHT);

        Rectangle rect = new Rectangle(50, 90);
        root.setCenter(rect);
        BorderPane.setAlignment(rect, javafx.geometry.Pos.CENTER);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
