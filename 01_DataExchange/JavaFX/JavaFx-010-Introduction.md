# JavaFX 010 - Introduction

## History

* AWT was the original GUI interface.  Everyone called it "Awful Window Tool."
* Swing -- Somewhat better than AWT.  It was not OOP, and it still used a lot of AWT components
* JavaFX


## Approaches

* Graphics drawn on the canvas
* Managing components with OOP specialized containers
  * Works in terms of Pane and derivative layouts
* FXML (generally, the most powerful, flexible, and maintainable)
  * Configuring with XML files
  * Styling with CSS and Boostrap-type formatting
  * Scene Builder to provide a gui interface for building and managing the XML file
* Combination of pane-based layouts and FXML.

## Mixed metaphores

### Window

The window is the top level.  It is the frame around the app along with the open/close/minimize buttons.  These are often controlled by the Operating System's Display manager.

The Title is part of the window

### Stage and Scene

The Stage is the top level organizer.  The stage is like a theater stage.  There may be more than one stage, but often there is one stage that has the scenes swapped out as the program runs.

Scenes are collections of components such as buttons, text areas, and images.  They also include things like scroll bars.

### Panes and Layouts

Back to the idea of the Window Pane

Pane is the super class  The other classes are called layouts.

Both FXML and OOP approaches use Panes and Layouts.

## Java Program structure.

* The main() method calls `launch()`
* The launch() method does a lot of behind the scenes stuff
  * There is an init() method we can override to do initializations
* The `start()` method
  * The start() method is called by launch()
  * The start() method is where we, as programmers, start programming.