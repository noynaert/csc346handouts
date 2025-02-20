package com.noynaert.javafx010intro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Paneful stuff!");
        Button button1 = new Button("I am a button");
        Button button2 = new Button("Another button");
        Label label1 = new Label("I am a label");
        Text text1 = new Text("I am a text");
        Text text2 = new Text("I am another text");
        Circle c = new Circle(10,Color.RED);
        Rectangle r = new Rectangle(20, 40, Color.BLUE);

        Button b1 = new Button("One");
        Button b2 = new Button("Two");
        Button b3 = new Button("Three");
        Button b4 = new Button("Four");
        Button b5 = new Button("Five");
//        BorderPane root = new BorderPane(b1,b2,b3,b4,b5);
        //BorderPane root = new BorderPane();
//        root.setTop(b1);
//        root.setBottom(b2);
//        root.setLeft(b3);
//        root.setRight(b4);
//        root.setCenter(b5);

        HBox top = new HBox(new Button("I am the TOP button"),new Button("I am not the BOTTOM button"));
        top.setSpacing(20);

        HBox bottom = new HBox(text1);
        VBox left = new VBox(label1);
        VBox right = new VBox(button1,button2);
        VBox center = new VBox(b1,b2,b3,b4,b5);
        center.setSpacing(20);

        top.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        center.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        bottom.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        center.setAlignment(Pos.CENTER);
        //left.setPrefWidth(250);
        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setBottom(bottom);
        root.setLeft(left);
        root.setRight(right);
        root.setCenter(center);

        Scene primaryScene = new Scene(root,500,200);

        stage.setScene(primaryScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}











