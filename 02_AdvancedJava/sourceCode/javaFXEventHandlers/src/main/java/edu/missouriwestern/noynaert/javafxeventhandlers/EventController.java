package edu.missouriwestern.noynaert.javafxeventhandlers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class EventController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

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
