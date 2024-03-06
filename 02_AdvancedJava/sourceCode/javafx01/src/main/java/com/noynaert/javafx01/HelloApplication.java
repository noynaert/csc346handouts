package com.noynaert.javafx01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        VBox vBox = new VBox();
        Scene scene = new Scene(vBox, 320, 240);

        Label labelHello = new Label("Hello.");
        Label labelGoodbye = new Label("GoodBye");

        vBox.getChildren().add(labelHello);
        vBox.getChildren().add(labelGoodbye);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        labelHello.setText("Aloha");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
