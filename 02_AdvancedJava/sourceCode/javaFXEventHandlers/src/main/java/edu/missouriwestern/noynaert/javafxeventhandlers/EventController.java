package edu.missouriwestern.noynaert.javafxeventhandlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.*;

public class EventController {
    private Map<String,String> customMap = createCustomColors();
    private Map<String,String> createCustomColors(){
        Map<String,String> map = new Hashtable<>();

        map.put("Dollar","#85BB65");
        map.put("Bob", "#abcdef");
        map.put("Banana", "#ffe135");

        return map;
    }

    @FXML
    private ChoiceBox choiceBox = makeChoiceBox();

    private ChoiceBox makeChoiceBox(){
        ChoiceBox cb = new ChoiceBox();
//        ObservableList<String> colorList = FXCollections.observableArrayList(customMap.keySet());
//        cb.setItems(colorList);
        cb.getItems().addAll("item1", "item2", "item3");
        System.out.println("In makeChoiceBox");
        return cb;
    }

    @FXML
    private Circle mwsuCircle;
    @FXML
    private Button blackButton;
    @FXML
    private Button goldButton;
    @FXML
    private Label colorNameLabel;
    @FXML
    private TextField colorTextField;
    @FXML
    private Button submitButton;


    private Color currentColor;
    private String currentColorName;

    @FXML
    protected void paintItBlack(){
        currentColor = Color.BLACK;
        currentColorName = "Black";
        changeColor();
    }
    @FXML
    protected void paintItGold() {
        currentColor = Color.GOLD;
        currentColorName = "Gold";
        changeColor();
    }
    @FXML
    protected void paintFromText(){
        try {
            currentColor = Color.web(colorTextField.getText());
            currentColorName = colorTextField.getText();
        }catch(Exception e){
            currentColor= Color.WHITE;
            currentColorName = "Unknown";
        }
        changeColor();
    }



    private void changeColor(){
        System.out.println("The current color is " + currentColorName);
        mwsuCircle.setFill(currentColor);
        mwsuCircle.setStroke(currentColor);
        colorNameLabel.setText(currentColorName);
    }
}
