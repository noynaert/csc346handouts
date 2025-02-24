# JavaFX 050 Deeper Dive into Events

We will still be staying rather superficial.  

* We will not be doing background events
* We will not be doing concurrency.  

## Types of foreground events

A short, simplified list:

* Mouse events
* Key events
* Drag events
* Window events

A longer list is available at [https://www.tutorialspoint.com/javafx/javafx_using_convenience_methods.htm](https://www.tutorialspoint.com/javafx/javafx_using_convenience_methods.htm).  If you look at the list, there are several different types of mouse events.

## The scene tree

The stage is a tree.  At any one time, the stage has one descendent, the scene.  Discussion of events happens in terms of the "scene tree."  The scene is also a tree.  

## All nodes may react to events

All nodes may listen to any event.  Multiple nodes may be listening for the same event.  Figuring out which nodes get priority becomes an issue.  The scene tree is used to manage priorities when events happen.

Sometimes things move up the scene tree, sometimes they move down the tree.

## Route construction

The route has two phases.  The first phase is the Event Capture Phase.  The second phase is the Event Bubbling Phase.

### Event Capture Phase

When an event happens, there is an "Event Dispatch Chain" is created.  It is a path that starts at the stage, moves down to the scene, and then through the scene tree.

Nodes on the tree may "register" a filter for events.  This moves from the tree root to the leaves.

### Event Bubbling Phase

The Bubbling phase moves from the node where it occured toward the root.  Event Handlers are activated during the Bubbling Phase.
