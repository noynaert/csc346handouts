package com.noynaert.javafx_060_concurrency;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Button button = new Button("Do something that takes a lot of time!");
        Button poke = new Button("Poke!");

        poke.setOnAction(e -> System.out.println("I got poked!"));
        button.setOnAction(e -> {
            try {
                for (int i = 10; i >= 0; i--) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Done!");

        });

        root.getChildren().addAll(button, poke);

        Scene scene = new Scene(root, 300 * 1.618, 300);
        stage.setTitle("Concurrency!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}