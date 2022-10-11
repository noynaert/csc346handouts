package fxControls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    static int clickCount = 0;

    @Override
    public void start(Stage stage) {

        Pane carPane;

        var label = new Label("Happy");
        Button button = new Button("Click Me!");
        Label report = new Label("Report will go here!");
        button.setPadding(new Insets(10,10,10,10));
        button.setOnAction( e -> {
            doClick(report);
        });
        report.setPadding(new Insets(10,10,10,10));
        Pane buttonPane = new FlowPane(Orientation.HORIZONTAL);
        buttonPane.getChildren().add(button);
        buttonPane.getChildren().add(report);



        Pane mainPane = new FlowPane(Orientation.VERTICAL);
        mainPane.setPadding(new Insets(50,0,10,100));
        mainPane.getChildren().add(label);
        mainPane.getChildren().add(new Label("Quiet"));
        mainPane.getChildren().add(buttonPane);
        carPane = setCarPane();
        mainPane.getChildren().add(carPane);



        var scene = new Scene(new StackPane(mainPane), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private Pane setCarPane() {
        Pane pane = new FlowPane();

        ChoiceBox<String> dropDown = new ChoiceBox<>();
        dropDown.setPadding(new Insets(0, 10, 0, 0));
        Button pickCarButton = new Button("click a button to pick a car");
        Label  pickedCarlabel = new Label("???");
        pickedCarlabel.setPadding(new Insets(0,0,0,10));

        //put items in the dropBox
        dropDown.getItems().add("Ford");
        dropDown.getItems().add("Chevrolet");
        dropDown.getItems().addAll("Dodge", "Kia", "Toyota", "Nissan");
        dropDown.setValue("Kia");

        String pick = "?????";
        pickCarButton.setOnAction(e -> pickCar( dropDown, pickedCarlabel));

        pane.getChildren().addAll(dropDown,pickCarButton,pickedCarlabel);

        return pane;
    }

    private void pickCar(ChoiceBox<String> dropDown,Label label) {
        String pick = dropDown.getValue();
        label.setText(pick);

    }

    private void doClick(Label label) {
        clickCount++;
        String message = String.format("I got clicked %d times so far",clickCount);
        label.setText(message);
        System.out.println(message);
    }

    public static void main(String[] args) {
        launch();
    }

}
