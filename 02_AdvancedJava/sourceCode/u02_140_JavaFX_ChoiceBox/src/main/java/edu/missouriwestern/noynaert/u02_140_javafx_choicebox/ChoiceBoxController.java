package edu.missouriwestern.noynaert.u02_140_javafx_choicebox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Map;

public class ChoiceBoxController  {
    private Map<String,String> colorMap = new HashMap<>();

    @FXML
    private ChoiceBox<String> personChoiceBox;

    @FXML
    private Label personLabel;

    @FXML
    protected Circle colorCircle;


    @FXML
    private void personChoiceBoxChanged(ActionEvent event){
        String person = personChoiceBox.getValue();
        System.out.println("The person selected was " + person);
        personLabel.setText("Selected: " + person);
        personLabel.setVisible(true);
    }
    @FXML
    private void colorChoiceBoxChanged(ActionEvent event){
        String choice = colorChoiceBox.getValue();
        String hexColor = colorMap.get(choice);
        System.out.println(choice + " (" + hexColor+")");

        System.out.println("The hex code is " + hexColor);
        Color color = Color.web(hexColor);
        colorCircle.setFill(color);
        colorLabel.setText(choice + " ("+hexColor+")");
        colorLabel.setVisible(true);

    }


    @FXML
    protected Label colorLabel;

    @FXML
    private ChoiceBox<String> colorChoiceBox;
    public void initialize() {
        System.out.println("I am in the initializer");
        personChoiceBox.getItems().addAll("John", "Jane", "Bob");
        personChoiceBox.setOnAction(this::personChoiceBoxChanged);

        Color c = Color.web("0xFFFFFF",1.0);
        colorCircle.setFill(c);

        //hard code the color choices
        colorMap.put("Greenback Dollar", "0x33634c");
        colorMap.put("Banana", "0xffcc33");
        colorMap.put("Bob", "0xabcdef");

        // Finally, set up the choiceBox

        colorChoiceBox.getItems().addAll(colorMap.keySet());
        colorChoiceBox.setOnAction(this::colorChoiceBoxChanged);

        }

}
