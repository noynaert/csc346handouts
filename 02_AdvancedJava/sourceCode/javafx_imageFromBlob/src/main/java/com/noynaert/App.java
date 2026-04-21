package com.noynaert;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;


/**
 * illustrates including an image from a file, and then from a blob.
 */
public class App extends Application {
    static String griffonFileName = "resources/GRIFFON.png";


    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        BorderPane root = new BorderPane();
        VBox center = new VBox();
        center.setSpacing(10);
        center.setAlignment(Pos.CENTER);
        root.setCenter(center);


        var label = new Label("Demonstrating inserting images");
        center.getChildren().add(label);
        Scene scene = new Scene (root, 640, 480);
        stage.setScene(scene);
        stage.show();
        displayGriffon(griffonFileName,center);
    }

    public static void main(String[] args) {
        launch();
    }
    /**
     * Adds a label containing the griffon file name to the scene.
     *
     * @param fileName the file name to display
     * @param pane the pane to add the label to  (it is probably an hbox)
     * note that scene was moved to a protected static field.
     */
    private void displayGriffon(String fileName, Pane pane) {
        var label = new Label(fileName);
        pane.getChildren().add(label);
        //add the image to the pane
        File file = new File(fileName);
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        pane.getChildren().add(imageView);
    }
}