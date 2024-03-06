module com.noynaert.javafx02 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.noynaert.javafx02 to javafx.fxml;
    exports com.noynaert.javafx02;
}