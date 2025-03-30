# 01 CSV -- Java Beans

POJOs and Beans are classes that hold data.  They usually have constructors.

We are using a lot of builders and factories.  Those are usually for more operational classes.  Somewhere in between we have things like LocalDate classes.  They are mainly data, but also contain functionality.  There are often created with operational methods such as the .of() methods.