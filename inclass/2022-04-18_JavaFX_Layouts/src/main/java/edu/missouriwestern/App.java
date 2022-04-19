package edu.missouriwestern;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application{


    public static void main(String[] args) {
            Application.launch();
    }

    /*
    The top level of a JavaFX program is the "stage."  The stage is basically the window
    itself.  It is possible to have two different stages.  This would result in two different windows.
    Things like the title, width, and height can be set with setters.

    Scenes go on the stage.   It is possible to have multiple scenes and swap them out as the program runs.

    We put "panes" on the scene.  Basic controls like Buttons, Labels, and TextFields are technically panes.

    Layout Panes are containers that are intended to go on scenes.
    Every layoutpane has a different logic or strategy for arranging content.


     */

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("This is my dumb title");

        Button welcome = new Button("Hello");
        Label label = new Label("Greetings!");
        BorderPane bp = new BorderPane();
        bp.setCenter(label);
        bp.setBottom(welcome);



        Scene scene = new Scene(bp);

        stage.setScene(scene);
        stage.show();


    }
}
