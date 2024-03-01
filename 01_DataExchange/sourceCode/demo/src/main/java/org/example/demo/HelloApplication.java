package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Hello!");

        VBox vbox = new VBox();

        Label label1 = new Label("Howdy");
        Label label2 = new Label("GoodBye");
        vbox.getChildren().add(label1);
        vbox.getChildren().add(label2);
        Scene scene = new Scene(vbox,300,200);
        label1.setText("Aloaha");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
