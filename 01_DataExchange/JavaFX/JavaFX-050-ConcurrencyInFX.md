# Java FX Concurrency 050

* JavaFX concurrency is build on the regular Java Concurrency model.
* If there are multiple threads, only the thread that creates the scene can change the scene.
  
## The problem without threads

```java

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       stage.setTitle("Concurrency 1");
       VBox root = new VBox();
       root.setAlignment(Pos.CENTER);
       Button busy = new Button("Go do something that takes time");
       busy.setOnAction(event -> {
           try {
               System.out.println("Going to sleep");
               for(int i=10;i>0;i--) {
                   System.out.println(i);
                   Thread.sleep(1000);
               }
               System.out.println("Waking up");
           } catch (InterruptedException e) {
               System.out.println(e.getMessage());
               e.printStackTrace();
           }
       });
       Button poke = new Button("Poke");
       poke.setOnAction(event -> System.out.println("I have been poked"));

        root.getChildren().addAll(busy, poke);
        Scene scene = new Scene(root,300*1.618, 300);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
```

