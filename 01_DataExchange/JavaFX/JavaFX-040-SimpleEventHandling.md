# JavaFX 040 Basic Event handling and Anonymous Inner Classes

Look at [https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html)

> When a button is pressed and released a ActionEvent is sent. Your application can perform some action based on this event by implementing an EventHandler to process the ActionEvent. Buttons can also respond to mouse events by implementing an EventHandler to process the MouseEvent

Programmers can trap and act on either ActionEvents or EventHandlers.  The Button is handy because it has the ActionEvent already set for it, so we only need to deal with the Event Handler.

## Anonymous Inner Class

The long way to create an object:

```java
Label label = new Label("just a label");
root.getChildren.add(label);
```

Sometimes we do not need the variable name because we will never use the object again.  So we create an anonymous object:

```java
root.getChildren.add(new Label("just a label));
```

Sometimes we only need one instance of a class, and we don't need to reference the class.  In these situations, we may use an "Anonymous Inner Class."   (See the example of the EventHandler class for the firstButton below)

## Lambda

Some methods require another method as an argument.

```java
private void printValue(String value){
    System.out.println(value);
}
...
outerMethod(printValue(value));
```

Java 8 introduced "Lambda" notation.  A lambda is a stand-in for a method call.  It is shorthand for declaring a function that can be anonymous.

If this parameter method is only going to be used once, we can skip giving it a name.  Give it the parameter list with (), then a `->` symbol, and the {statements}

```java
     outerMethod( (value) -> {System.out.println(value);})
```

* If there is only one argument, we may skip the ()
* If there is only one statement we may skip the ; and the {}

```java
   outerMethod( value -> System.out.println(value));
```

## Source code

```java
package com.noynaert.javafx_040eventhandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage stage;
    private Scene scene;
    private BorderPane root;
    private VBox center;
    private HBox bottom;
    private Button firstButton;
    private Button secondButton;
    private Button thirdButton;
    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setTitle("Event Handler Example");

        setupScene();

        //Using an anonymous inner class
        firstButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                statusLabel.setText("First Button clicked!");
                statusLabel.setTextFill(Color.RED);
            }
        });

        //Using a Lambda with one statement
        secondButton.setOnAction(event -> statusLabel.setText("Second Button clicked!"));

        //Using a Lambda with two statements in the body of the function
        thirdButton.setOnAction(event -> {
            statusLabel.setText("Third Button clicked!");
            statusLabel.setTextFill(Color.GREEN);
        });


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    private void setupScene() {
        firstButton = new Button("Click me");
        secondButton = new Button("Click me too");
        thirdButton = new Button("Once more, with feeling");
        statusLabel = new Label("Waiting...");

        center = new VBox();
        bottom = new HBox();

        center.getChildren().addAll(firstButton,secondButton,thirdButton);
        bottom.getChildren().add(statusLabel);

        center.setAlignment(Pos.CENTER);
        center.setSpacing(5);
        bottom.setSpacing(10);
        center.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        bottom.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        root = new BorderPane();
        root.setCenter(center);
        root.setBottom(bottom);

        scene = new Scene(root, 300, 250);
        stage.setScene(scene);
    }
}

```