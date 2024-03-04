package edu.missouriwestern.noynaert.javafx_image;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HelloController {

    @FXML
    private Button helloButton;

    @FXML
    private Label title;

    @FXML
    private Label copyright;

    @FXML
    private ImageView pretty;

    @FXML
    private TextArea explanation;

    @FXML
    protected void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
        selectNextPicture();
    }

    protected void selectNextPicture(){
        HelloApplication.nextImage();
        HelloApplication.NasaImage image = HelloApplication.images[HelloApplication.imageIndex];
        //System.out.println(image);
        title.setText(image.title);
        copyright.setText(image.copyright);
        explanation.setText(image.explanation);
//        Image imageToShow = new Image(image.url);
//        pretty.setImage(imageToShow);

        InputStream stream = null;
        try {
            stream = new URL(image.url).openStream();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Image img = new Image(stream);
        pretty.setImage(img);

    }
}
