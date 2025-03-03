module com.noynaert.xml_040_simple {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.noynaert.xml_040_simple to javafx.fxml;
    exports com.noynaert.xml_040_simple;
}