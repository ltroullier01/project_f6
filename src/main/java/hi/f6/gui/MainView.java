package hi.f6.gui;

import hi.f6.controllers.FlightController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {

  private FlightController flightController;
  SearchDisplay sd;
  FlightDisplay fd;
  BookingDisplay bd;

  public MainView() {
    this.flightController = new FlightController();
    this.sd = new SearchDisplay(this);
    this.fd = new FlightDisplay(this);
    this.bd = new BookingDisplay();

    this.setLeft(this.sd);
    this.setCenter(this.fd);
    this.setRight(this.bd);

    this.sd.controller.setFlightDisplay(this.fd);

    BorderPane.setMargin(this.bd, new Insets(0, 20, 0, 0));
  }

  public FlightDisplay getFD() {
    return fd;
  }

  public BookingDisplay getBD() {
    return this.bd;
  }

  public FlightController getFlightController() {
    return this.flightController;
  }
}
