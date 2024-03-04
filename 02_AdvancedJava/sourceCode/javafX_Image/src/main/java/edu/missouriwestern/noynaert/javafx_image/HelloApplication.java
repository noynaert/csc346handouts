package edu.missouriwestern.noynaert.javafx_image;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static NasaImage[] images = new NasaImage[2];
    public static int imageIndex = 0;  //Only 0 and 1

    public static void nextImage() {
        imageIndex = (imageIndex + 1) % images.length;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1020, 980);
        stage.setTitle("Astronomy Image of the Day");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        images[0] = new NasaImage();
        images[1] = new NasaImage();
        images[0].title = "Odysseus and The Dish";
        images[0].copyright=" John Sarkissian (ATNF Parkes Radio Observatory)";
        images[0].url = "https://apod.nasa.gov/apod/image/2403/The_Dish_Tracking_IM-1_22February2024_04s.jpg";
            images[0].explanation="Murriyang, the CSIRO’s Parkes Radio Telescope, points toward a nearly Full Moon in this image from New South Wales, Australia, planet Earth. Bathed in moonlight, the 64 meter dish is receiving weak radio signals from Odysseus, following the robotic lander's February 22 touch down some 300 kilometers north of the Moon's south pole. The landing of Odysseus represents the first U.S. landing on the Moon since the Apollo 17 mission in 1972. Odysseus' tilted orientation on the lunar surface prevents its high-gain antenna from pointing toward Earth. But the sensitivity of the large, steerable Parkes dish significantly improved the reception of data from the experiments delivered to the lunar surface by the robotic moon lander. Of course the Parkes Radio Telescope dish became famous for its superior lunar television reception during the Apollo 11 mission in 1969, allowing denizens of planet Earth to watch the first moonwalk.";
        images[1].title = "Supernova Remnant Simeis 147";
        images[1].copyright="Stéphane Vetter (Nuits sacrées)";
        images[1].url = "https://apod.nasa.gov/apod/image/2402/Simeis147_Vetter_960.jpg";
        images[1].explanation="It's easy to get lost following the intricate, looping, and twisting filaments of supernova remnant Simeis 147. Also cataloged as Sharpless 2-240, the filamentary nebula goes by the popular nickname the Spaghetti Nebula. Seen toward the boundary of the constellations of the Bull (Taurus) and the Charioteer (Auriga), the impressive gas structure covers nearly 3 degrees on the sky, equivalent to 6 full moons. That's about 150 light-years at the stellar debris cloud's estimated distance of 3,000 ";

        launch();
    }
    static class NasaImage{
        String title;
        String copyright;
        String url;
        String explanation;

        @Override
        public String toString() {
            return "NasaImage{" +
                    "title='" + title + '\'' +
                    ", copyright='" + copyright + '\'' +
                    ", url='" + url + '\'' +
                    ", explanation='" + explanation + '\'' +
                    '}';
        }
    }
}
