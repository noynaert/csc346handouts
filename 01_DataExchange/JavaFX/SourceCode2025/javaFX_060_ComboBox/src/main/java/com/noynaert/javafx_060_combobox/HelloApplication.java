package com.noynaert.javafx_060_combobox;

import com.thedeanda.lorem.LoremIpsum;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;

/** Demonstrates the use of combo boxes as a drop-down list
 *
 * @author J. Evan Noynaert
 * @since February, 2025
 *
 */

public class HelloApplication extends Application {
    static private Stage stage;
    static private Scene scene;
    static private VBox root;
    static private Label personChosenLabel;
    static private ComboBox<String> peopleComboBox;
    static private ObservableList<String> peopleList;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        root = new VBox(50);

        scene = new Scene(root,200 * 1.618, 200);
        stage.setTitle("Picking People");

        peopleComboBox = new ComboBox<>(peopleList);
        peopleComboBox.setVisibleRowCount(3);
        peopleComboBox.setValue(peopleList.get(0));

        personChosenLabel = new Label("Ann Nonymous");
        personChosenLabel.setVisible(false);

       // peopleComboBox.setOnAction(event -> personChosenLabel.setText("?????????????"));
          peopleComboBox.setOnAction(new personHandler());


        root.getChildren().addAll(peopleComboBox, personChosenLabel);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        LoremIpsum lorem = new LoremIpsum();
        System.out.println(lorem.getWords(100));
        System.out.println(lorem.getName());

        peopleList = FXCollections.observableArrayList();
        for(int i = 0; i < 10; i++) {
            String person = lorem.getName();
            peopleList.add(person);
            System.out.println(person);
        }
        Collections.sort(peopleList);

    }
    static class personHandler implements EventHandler {

        @Override
        public void handle(Event event) {
             ComboBox<String> cb = (ComboBox<String>) event.getSource();
             String person = cb.getValue();
             if(person != null) {
                 personChosenLabel.setText(person);
                 personChosenLabel.setVisible(true);
             }else{
                 personChosenLabel.setText("Please pick a person");
             }
        }
    }

    public static void main(String[] args) {
        launch();
    }

}


