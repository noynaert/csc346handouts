package com.noynaert;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.noynaert.monsters.Cook;
/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
  //      var label = new Label("Boo");
  //      var scene = new Scene(new StackPane(label), 640, 480);

        //Generate some dummy strings for the VBox contents
        //Your game will produce this for the final.

        String s = "Four score and seven years ago our fathers brought forth. mvn archetype:generate -DarchetypeGroupId=org.openjfx -DarchetypeArtifactId=javafx-archetype-simple -DarchetypeVersion=0.0.3 -DgroupId=\"\" -DartifactId=finalExamTony -Dversion=1.0.0 -Djavafx-version=17.0.1";
        String[] words = s.split("[^A-Za-z]+");

        Cook cook = new Cook();
        VBox vbox = new VBox();
        for(int i = 0; i< words.length; i++){
            vbox.getChildren().add(new TextField(words[i]));
        }
        ScrollPane scrollPane = new ScrollPane(vbox);

        Scene scene = new Scene(scrollPane, 100, 300);
        stage.setScene(scene);
        stage.show();
        vbox.getChildren().add(new TextField(cook.toString()));
    }

    public static void main(String[] args) {
        launch();
    }

}
