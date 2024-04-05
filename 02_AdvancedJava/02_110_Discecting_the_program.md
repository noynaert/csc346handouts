# 02.110 Dissecting the running JavaFX program

```java
    1	package edu.missouriwestern;
    2	
    3	import javafx.application.Application;
    4	import javafx.scene.Scene;
    5	import javafx.scene.control.Label;
    6	import javafx.scene.layout.StackPane;
    7	import javafx.stage.Stage;
    8	
    9	/**
   10	 * JavaFX App
   11	 */
   12	public class App extends Application {
   13	
   14	    @Override
   15	    public void start(Stage stage) {
   16	        var javaVersion = SystemInfo.javaVersion();
   17	        var javafxVersion = SystemInfo.javafxVersion();
   18	
   19	        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
   20	        var scene = new Scene(new StackPane(label), 640, 480);
   21	        stage.setScene(scene);
   22	        stage.show();
   23	    }
   24	
   25	    public static void main(String[] args) {
   26	        launch();
   27	    }
   28	
   29	}
```

## Extending Application

Note that our main App.java file (or whatever we call our main file) extends the abstract class `Application`.  The Application class has an abstract method called `start()`.  So the programmer must immediately implement start.

In the archetype we are using the template includes a basic start() method.  But some ways of creating a JavaFX program require the programmer to type it out.

## `main()`

Main appears in lines 25 through 27.  The main() method only launches the static method `launch()`.  With Maven and modern versions of JavaFX it is possible to call launch() directly and not have main() at all.

## What does `launch()` do?

It does quite a bit of setup.  Then it calls start()

## `start()`

The archetype we are using gives us a good start.

## The JavaFX Metaphor

At the heart of JavaFX is a theater metaphor.  The window itself is the ***Stage***.  The programmer writes a series of ***Scenes*** that go onto the stage.  A program may have several stages that get swapped onto the stage.

A stage is a container.  It holds multiple nodes that are arranged in a tree.  

The arrangement of the nodes when they are displayed on the screen is handled by layout managers.

After the stage and scene, the theater metaphor breaks down.  The stage contains containers.  Various types of Panes are the main thing added to the scene. 

The process of adding elements to a page is done by calling .getChildren().  This gives us the tree.  Then we can add things to the tree.

## Layout Managers

* [https://blog.idrsolutions.com/2014/05/layout-manager-swing-javafx-tutorial/](https://blog.idrsolutions.com/2014/05/layout-manager-swing-javafx-tutorial/)
* [https://zetcode.com/gui/javafx/layoutpanes/](https://zetcode.com/gui/javafx/layoutpanes/)


## How to design your screen

There are generally three ways to design how your gui program will look.

1. Programmatically -- This iss what we are doing when we call .getChildren() and add things
2. XML -- FXML Allows us to design the program as an XML tree
3. Using a GUI designer -- Ther is one built into IntelliJ.  There are also third-party ones available.  They allow drag-and-drop design.  The output of the GUI is an FXML file.  You may edit the file as XML, or you may edit it in a gui.  In Idea, the program is called "SceneBuilder."  Instructions for using it are at [https://www.jetbrains.com/help/idea/opening-fxml-files-in-javafx-scene-builder.html](https://www.jetbrains.com/help/idea/opening-fxml-files-in-javafx-scene-builder.html)