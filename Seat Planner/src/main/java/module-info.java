module com.example.seatplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.seatplanner to javafx.fxml;
    exports com.example.seatplanner;
}