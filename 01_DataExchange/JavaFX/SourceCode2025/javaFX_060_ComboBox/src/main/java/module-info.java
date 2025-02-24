module com.noynaert.javafx_060_combobox {
    requires javafx.controls;
    requires javafx.fxml;
    requires lorem;


    opens com.noynaert.javafx_060_combobox to javafx.fxml;
    exports com.noynaert.javafx_060_combobox;
}