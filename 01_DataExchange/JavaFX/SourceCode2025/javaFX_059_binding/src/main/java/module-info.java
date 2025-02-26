module com.noynaert.javafx_059_binding {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.noynaert.javafx_059_binding to javafx.fxml;
    exports com.noynaert.javafx_059_binding;
}