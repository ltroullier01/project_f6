module hi.f6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens hi.f6 to javafx.fxml;
    exports hi.f6;
}
