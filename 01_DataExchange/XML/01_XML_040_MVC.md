# 01 XML Model View Controller

The MVC model advocates breaking an application into three parts

* Model -- This is the data and the "business logic."
* View -- This is how the data looks on screen and how the user interacts with it.
* Controller -- Moves objects between the view and the model.

Our JavaFX up until now has muddled all of those together.  That is bad.

JavaFX encourages the use of FXML to provide MVC separation.

## Keep the View dumb

The view is essentially an FXML file.  It does not contain any business logic or know exactly what is being displayed.  Mainly, it displays the data it is given, and it knows what part of the controller to call when something happens.

## A simple FXML file

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.VBox?>

<?import javafx.scene.control.Button?>
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.noynaert.xml_040_simple.HelloController">
   
    <Label fx:id="welcomeText"/>
    <Button text="Hello!" onAction="#onHelloButtonClick"/>
</VBox>

```

### Things to note

* Standard XML prolog
* The `<?import ...?>` statements are basically bringing in DTDs for the elements we are using
* Note the attributes on the VBox.  It sets up the fx: namespace and ties the view to a controller.
* The Label has an fx:id attribute.  This is how the controller knows where to send the data when a button is clicked
* The Button has an onAction field that tells what method in the controller to call.

## The Controller

```java

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
```