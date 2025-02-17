package com.noynaert.javafx010intro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Paneful stuff!");
        Button button1 = new Button("I am a button");
        Button button2 = new Button("Another button");
        Label label1 = new Label("I am a label");
        Circle c = new Circle(10,Color.RED);
        Rectangle r = new Rectangle(20, 40, Color.BLUE);


        


        Scene primaryScene = new Scene(root,500,200);

        root.getChildren().addAll(r,c);
        stage.setScene(primaryScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}











