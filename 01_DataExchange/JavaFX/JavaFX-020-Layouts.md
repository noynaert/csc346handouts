# JavaFX.020 Layouts

## The Components

* Window (frame and top bar, linked to OS)
* Stage (fills the Window)
* Scene (stuff that goes on the stage)
* Pane (there is a "root" pane for the scene.  It sets the size of the scene. It is a collection of components placed on the Pane)

The window contains the stage which contains the scene which contains the pane which contains more panes.

## Versions

Layouts are nearly the same in AWT, Swing, and JavaFX

## The Standard Layouts

* Hbox
* FlowPane
* Vbox
* StackPane
* GridPane
* BorderPane
  * Often the root, and it contains other layouts
  * Some regions may be empty.  They just disappear
  * Bottom is good for a status bar
  * Top is good for a menu or options
  * ![BorderPane](border.png)

