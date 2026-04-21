package com.noynaert;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;


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
        display0001("resources/0001.png", center);
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

    /**
     * Gets an array of bytes from a file.  Normally we would be getting the bytes from a blob in a database.
     *
     * @param fileName
     * @return
     */
  private static byte[] getBytes(String fileName) {
        byte[] bytes = null;
        Path path = Paths.get(fileName);
        try {
            bytes = java.nio.file.Files.readAllBytes(path);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("--------------------------");
            System.out.println("Could not read file " + fileName);
            System.out.println(e.getMessage());
            System.out.println("--------------------------");

        }
        return bytes;
  }

  private void display0001(String fileName, Pane pane){
      byte[] bytes = getBytes(fileName);
      InputStream fakeFile = new ByteArrayInputStream(bytes);
      Image image = new Image(fakeFile);
      ImageView imageView = new ImageView(image);
      imageView.setFitWidth(100);
      imageView.setPreserveRatio(true);
      pane.getChildren().add(imageView);
  }
}
