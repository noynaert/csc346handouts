module edu.missouriwestern.noynaert.u02_140_javafx_choicebox {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens edu.missouriwestern.noynaert.u02_140_javafx_choicebox to javafx.fxml;
    exports edu.missouriwestern.noynaert.u02_140_javafx_choicebox;
}