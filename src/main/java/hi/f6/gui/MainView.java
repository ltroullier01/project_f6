package hi.f6.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {
    SearchDisplay sd;
    FlightDisplay fd;
    BookingDisplay bd;

    public MainView() {
        this.sd = new SearchDisplay();
        this.fd = new FlightDisplay();
        this.bd = new BookingDisplay();

        this.setLeft(this.sd);
        this.setCenter(this.fd);
        this.setRight(this.bd);

        BorderPane.setMargin(this.bd, new Insets(0, 20, 0, 0));
    }

}
