module edu.missouriwestern.noynaert.javafx_image {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens edu.missouriwestern.noynaert.javafx_image to javafx.fxml;
    exports edu.missouriwestern.noynaert.javafx_image;
}