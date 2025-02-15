module com.noynaert.javafx010intro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.noynaert.javafx010intro to javafx.fxml;
    exports com.noynaert.javafx010intro;
}