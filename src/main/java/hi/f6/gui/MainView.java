package hi.f6.gui;

import hi.f6.controllers.FlightController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {
    SearchDisplay sd;
    FlightDisplay fd;
    BookingDisplay bd;
    FlightController flightController;

    public MainView() {
        this.flightController = new FlightController();
        this.sd = new SearchDisplay(this.flightController);
        this.fd = new FlightDisplay();
        this.bd = new BookingDisplay(flightController);

        this.setLeft(this.sd);
        this.setCenter(this.fd);
        this.setRight(this.bd);

        BorderPane.setMargin(this.bd, new Insets(0, 20, 0, 0));
    }

}
