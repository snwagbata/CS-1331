import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * File for the AnimalSnactuary UI.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class AnimalSanctuary extends Application {
    private ArrayList<AnimalInfo> animals = new ArrayList<AnimalInfo>(6);
    private ArrayList<AnimalInfo> animalsQueue = new ArrayList<AnimalInfo>(4);
    private TilePane tile = new TilePane();
    private VBox queue = new VBox();
    private ListView<StackPane> queueList = new ListView<StackPane>();

    // I will love to declare that graphics are not my strong suit.
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("My Animal Sanctuary");
        primaryStage.minHeightProperty().set(648);
        primaryStage.minWidthProperty().set(1152);
        BackgroundImage k = new BackgroundImage(new Image("animalImage.jpg"), BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        GridPane root = new GridPane();
        root.setVgap(30);
        root.setHgap(30);
        root.setBackground(new Background(k));

        // Text at the top
        Text title = new Text("Welcome to the Animal Sanctuary!");
        title.setFill(Color.CHOCOLATE);
        title.setStyle("-fx-font: 42 arial;");

        // Left side of the grid
        HBox left = new HBox();
        left.setMinWidth(150);

        // Each Box
        StackPane stack, stack2, stack3, stack4, stack5, stack6;
        stack = getEmptyBox();
        stack2 = getEmptyBox();
        stack3 = getEmptyBox();
        stack4 = getEmptyBox();
        stack5 = getEmptyBox();
        stack6 = getEmptyBox();

        // Setting the vertical and horizontal gaps between the columns and add empty
        // boxes to the grid
        tile.setPrefColumns(3);
        tile.setPrefRows(2);
        tile.setVgap(30);
        tile.setHgap(30);
        tile.getChildren().addAll(stack, stack2, stack3, stack4, stack5, stack6);

        // New stage for collecting animal info
        Dialog<AnimalInfo> animalStage = newAnimalDialog();

        // Right side of the grid
        // Contains the animal queue and animal addition button
        ImageView addIcon = new ImageView("add.png");
        addIcon.setFitHeight(45);
        addIcon.setFitWidth(45);
        Button addAnimal = new Button("Add New Animal", addIcon);
        addAnimal.setMinHeight(50);
        addAnimal.setOnAction(e -> {
            Optional<AnimalInfo> result = animalStage.showAndWait();
            result.ifPresent(animal -> {
                System.out.println(animal);
                if (animals.size() + 1 <= 6) {
                    animals.add(animal);
                    updateTile();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Would you like to add animal to queue?",
                            ButtonType.YES, ButtonType.NO);
                    alert.setTitle("Error");
                    alert.setHeaderText("There is no more room!");
                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.YES && animalsQueue.size() < 4) {
                            animalsQueue.add(animal);
                            queueList.getItems().add(animalQueueTile(animal));
                        } else if (response == ButtonType.YES && animalsQueue.size() >= 4) {
                            Alert alert2 = new Alert(AlertType.ERROR,
                                    "You have reached the maximum number of animals in the queue!", ButtonType.OK);
                            alert2.setTitle("Error");
                            alert2.showAndWait();
                        }
                    });
                }
                animalStage.close();
            });
        });
        queue.getChildren().add(addAnimal);
        Region space = new Region();
        space.setMinHeight(40);
        queue.getChildren().add(space);
        Text queueTitle = new Text("Animal Queue");
        queueTitle.setFill(Color.BLACK);
        queueTitle.setStyle("-fx-font: 16 arial;");
        queue.getChildren().add(queueTitle);
        // change background color of the cells in the queueList
        queueList.setCellFactory(param -> new ListCell<StackPane>() {
            @Override
            protected void updateItem(StackPane item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setBackground(
                            new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                    setGraphic(item);
                }
            }
        });
        queueList.setPrefHeight(queueList.getItems().size() * 77.25);
        queueList.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
        // remove background color of the cells in the queueList
        queueList.setCellFactory(param -> new ListCell<StackPane>() {
            @Override
            protected void updateItem(StackPane item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                    setBackground(
                            new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    setBackground(
                            new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                    setGraphic(item);
                }
            }
        });
        queue.getChildren().add(queueList);

        // Add the animal grid and queue to the scene and the scene to the stage
        root.add(title, 1, 0);
        root.add(left, 0, 0);
        root.add(tile, 1, 1);
        root.add(queue, 2, 1);
        // Add the scene to the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    private StackPane getEmptyBox() {
        StackPane stack = new StackPane();
        stack.setMaxWidth(25.0);
        Rectangle rect = new Rectangle(200, 200);
        rect.setFill(Color.WHITE);
        Text text = new Text("Empty");
        text.setFill(Color.BLACK);
        stack.getChildren().addAll(rect, text);
        return stack;
    }

    private Dialog<AnimalInfo> newAnimalDialog() {
        Dialog<AnimalInfo> animalStage = new Dialog<>();
        animalStage.setTitle("Add Animal");
        animalStage.setHeaderText("Add New Animal to Sanctuary");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField name = new TextField();
        name.setPromptText("Name here: ");
        name.requestFocus();
        TextField health = new TextField();
        health.setPromptText("Health here: ");
        ComboBox<Enum<Animal>> type = new ComboBox<>();
        type.getItems().addAll(Animal.values());

        grid.add(new Label("Name:"), 0, 0);
        grid.add(name, 1, 0);
        grid.add(new Label("Animal Health:"), 0, 1);
        grid.add(health, 1, 1);
        grid.add(new Label("Animal Type:"), 0, 2);
        grid.add(type, 1, 2);

        // add grid to dialog
        animalStage.getDialogPane().setContent(grid);
        // Set the button types.
        ButtonType addButton = new ButtonType("Add", ButtonData.OK_DONE);
        animalStage.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        animalStage.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {

                String tname = name.getText();
                int thealth = 5;
                try {
                    thealth = Integer.parseInt(health.getText());
                } catch (NumberFormatException e) {
                    System.out.println("Health must be a number");
                }
                Animal ttype = (Animal) type.getValue();
                name.clear();
                health.clear();
                type.getSelectionModel().clearSelection();
                return new AnimalInfo(tname, thealth, ttype);
            }
            return null;
        });
        return animalStage;
    }

    private StackPane animalBox(AnimalInfo animal) {
        StackPane stack = new StackPane();
        Rectangle rect = new Rectangle(200, 200);
        rect.setFill(Color.LAVENDER);
        Text name = new Text("Name: " + animal.getName());
        name.wrappingWidthProperty().set(100);
        name.setFill(Color.BLACK);
        Text health = new Text("Health: " + animal.getHealth());
        health.setFill(Color.BLACK);
        Text type = new Text("Type: " + animal.getType());
        type.setFill(Color.BLACK);

        // Arrange the name and health labels and fields on the stackpane vertically
        VBox vbox = new VBox();
        vbox.setMaxSize(80, 50);
        vbox.setSpacing(10);
        vbox.getChildren().addAll(name, health, type);

        stack.getChildren().addAll(rect, vbox);
        stack.setOnMouseClicked(e -> {
            animals.remove(animal);
            tile.getChildren().remove(stack);
            tile.getChildren().add(getEmptyBox());
        });
        return stack;
    }

    private StackPane animalQueueTile(AnimalInfo animal) {
        StackPane stack = new StackPane();
        Rectangle rect = new Rectangle(200, 70);
        rect.setFill(Color.LAVENDER);
        Text finalText = new Text(String.format("%s (%s), %d", animal.getName(), animal.getType(), animal.getHealth()));
        finalText.setFill(Color.BLACK);
        finalText.wrappingWidthProperty().set(150);

        stack.getChildren().addAll(rect, finalText);
        stack.setOnMouseClicked(e -> {
            if (animals.size() + 1 <= 6) {
                animals.add(animal);
                animalsQueue.remove(animal);
                updateTile();
                queueList.getItems().remove(stack);
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Sanctuary is full!");
                alert.showAndWait();
            }
        });
        return stack;
    }

    private void updateTile() {
        if (animals.isEmpty()) {
            return;
        }
        for (int i = 0; i < animals.size(); i++) {
            AnimalInfo animal = animals.get(i);
            tile.getChildren().set(i, animalBox(animal));
        }
    }
}

class AnimalInfo {
    private String name;
    private int health;
    private Enum<Animal> type;

    AnimalInfo(String name, int health, Enum<Animal> type) {
        if (name == null || name.equals("")) {
            this.name = "No Name Yet";
        } else {
            this.name = name;
        }
        if (0 <= health || health > 5) {
            this.health = 5;
        } else {
            this.health = health;
        }
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Enum<Animal> getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s", name, health, type);
    }
}