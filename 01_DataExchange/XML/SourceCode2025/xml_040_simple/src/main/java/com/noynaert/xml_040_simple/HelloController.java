package com.noynaert.xml_040_simple;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    public Text clickMessage;


    public void onButtonClick(ActionEvent actionEvent) {
       ClickerModel.incrementClicks();
       String message = String.format("I have been clicked %d times.", ClickerModel.getClicks());
       clickMessage.setText(message);
    }
}