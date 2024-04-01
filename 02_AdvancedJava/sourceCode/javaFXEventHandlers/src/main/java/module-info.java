module edu.missouriwestern.noynaert.javafxeventhandlers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens edu.missouriwestern.noynaert.javafxeventhandlers to javafx.fxml;
    exports edu.missouriwestern.noynaert.javafxeventhandlers;
}