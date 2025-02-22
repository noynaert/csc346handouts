module com.noynaert.javafx_060_concurrency {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.noynaert.javafx_060_concurrency to javafx.fxml;
    exports com.noynaert.javafx_060_concurrency;
}