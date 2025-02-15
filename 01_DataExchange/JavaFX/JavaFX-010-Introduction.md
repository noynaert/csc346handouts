# JavaFX 010 - Introduction

## History

* AWT was the original GUI interface.  Everyone called it "Awful Window Tool."
* Swing -- Somewhat better than AWT.  It was not OOP, and it still used a lot of AWT components
* JavaFX
  * Was part of the Java standard library
  * Now it is a separate package.  Intellij and most modern IDEs have a shortcut that will install the needed files and template programs.


## Approaches

* Graphics drawn on the canvas
* Managing components with OOP specialized containers
  * Works in terms of Pane and derivative layouts
* FXML (generally, the most powerful, flexible, and maintainable)
  * Configuring with XML files
  * Styling with CSS and Boostrap-type formatting
  * Scene Builder to provide a gui interface for building and managing the XML file
* Combination of pane-based layouts and FXML.
* Other packages such as the [libGDX package](https://libgdx.com/)  Other packages do things like producing graphs and charts

## Mixed metaphores

### Window

The window is the top level.  It is the frame around the app along with the open/close/minimize buttons.  These are often controlled by the Operating System's Display manager.

The Title is part of the window

### Stage and Scene

The Stage is the top level organizer.  The stage is like a theater stage.  There may be more than one stage, but often there is one stage that has the scenes swapped out as the program runs.

Scenes are collections of components such as buttons, text areas, and images.  They also include things like scroll bars.

### Panes and Layouts

Back to the idea of the Window Pane

The Pane is a Parent that has children.  The children are nodes that are part of the scene

Pane is the super class  The other classes are called layouts.

Both FXML and OOP approaches use Panes and Layouts.

## Java Program structure.

The Main class in Java must extend `Application

* Application is an abstract class.  It requires us to create a `start(Stage stage)` method.
  * The start() method is where we, as programmers, do the types of things we would normally do in main(String[] args)
* The main() method calls `launch()`
* The launch() method does a lot of behind the scenes stuff
  * There is an init() method we can override to do initializations
  * launch() ends up calling our start() method
  
## The basic program pattern

* The `start(Start start)` method gives us the main stage as an a parameter.
  * Set the title to the Application (optional, but common)
* Create a "root" Pane or layout manager
* Create a root Pane of some type.
* Create a Scene using the root Pane
* Add children nodes (more Panes, in most cases) to the root pane
* Show the stage