package edu.missouriwestern.noynaert;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        //Adding a picture
        InputStream lizStream;
        try {
            lizStream = new FileInputStream("liz.png");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
        Image lizImage= new Image(lizStream);
        ImageView lizView = new ImageView();
        lizView.setImage(lizImage);
        lizView.setFitWidth(100);
        lizView.setPreserveRatio(true);


        var label = new Label("Halloween is coming!");
        var label2 = new Label("Halloween is October 31");
        Scene  scene;
        Pane pane = new FlowPane(Orientation.VERTICAL);
        pane.getChildren().add(label);
        pane.getChildren().add(label2);
        scene = new Scene(pane, 640, 480);
        pane.getChildren().add(new Label("Halloween is on a Monday this year."));

        pane.getChildren().add(new Rectangle(100,50, Color.RED));
        pane.getChildren().add(lizView);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
