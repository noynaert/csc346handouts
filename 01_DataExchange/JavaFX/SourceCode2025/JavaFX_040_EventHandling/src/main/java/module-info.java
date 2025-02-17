module com.noynaert.javafx_040_eventhandling {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.noynaert.javafx_040_eventhandling to javafx.fxml;
    exports com.noynaert.javafx_040_eventhandling;
}