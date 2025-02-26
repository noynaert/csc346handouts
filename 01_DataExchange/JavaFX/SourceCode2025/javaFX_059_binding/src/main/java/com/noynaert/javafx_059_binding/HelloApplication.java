package com.noynaert.javafx_059_binding;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *   This program was originally going to illustrate a couple of things that I am skipping
 *   in the interest of time.  But it does illustrate the concept of "binding" properties of nodes
 *   in the scene
 *
 * @author J. Evan Noynaert
 * @since February, 2025
 */

public class HelloApplication extends Application {
    static private Stage stage;
    static private Scene scene;
    static private BorderPane root;
    static private VBox center;
    static          HBox bottom;
    static private Label firstNameLabel;
    static private Label lastNameLabel;
    static private HBox firstNameBox;
    static private HBox lastNameBox;
    static private HBox buttonBox;
    static        TextField firstNameTextField;
    static        TextField lastNameTextField;
    static private Button firstButton;
    static private Button combineButton;
    static private Button clearButton;
    static private Label fullNameLabel;
    static        Text fullNameTextField;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setTitle("Name Games");
        createScene();

        //Illustrate Binding
        combineButton.disableProperty().bind(firstNameTextField.textProperty().isEmpty().or(lastNameTextField.textProperty().isEmpty()));
        bottom.visibleProperty().bind(fullNameTextField.textProperty().isNotEmpty());

        combineButton.setOnAction(event -> {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            fullNameTextField.setText(lastName + ", " + firstName);
            // bottom.setVisible(true);
        });

        clearButton.setOnAction(new ClearHandler());

        stage.setScene(scene);
        stage.show();
    }

    public void createScene() {
        //setup borderPane
        root = new BorderPane();
        center = new VBox(10);

        //set up first name line as an HBox
        firstNameLabel = new Label("First Name:");
        firstNameTextField = new TextField();
        firstNameBox = new HBox(10);
        firstNameBox.getChildren().addAll(firstNameLabel, firstNameTextField);

        //set up last name as an HBox
        lastNameLabel = new Label("Last Name:");
        lastNameTextField = new TextField();
        lastNameBox = new HBox(10);
        lastNameBox.getChildren().addAll(lastNameLabel, lastNameTextField);

        //set up button bar
        combineButton = new Button("Combine");
        clearButton = new Button("Clear");
        buttonBox = new HBox(20);
        buttonBox.getChildren().addAll(combineButton, clearButton);

        //set up center pane
        center.setAlignment(javafx.geometry.Pos.CENTER);
        center.getChildren().addAll(firstNameBox,lastNameBox,buttonBox);

        root.setCenter(center);
        scene = new Scene(root,300*1.618, 300);

        //set up bottom bar
        bottom = new HBox(10);
        fullNameTextField = new Text();
        fullNameLabel = new Label("Full Name:");
        bottom.getChildren().addAll(fullNameLabel, fullNameTextField);
        //bottom.setVisible(false);
        root.setBottom(bottom);

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("I am in the init method");
    }
}
class ClearHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Button button = (Button)event.getSource();

        button.setTextFill(javafx.scene.paint.Color.RED);
        HelloApplication.firstNameTextField.clear();
        HelloApplication.lastNameTextField.clear();
        HelloApplication.fullNameTextField.setText("");
        // HelloApplication.bottom.setVisible(false);


    }
}