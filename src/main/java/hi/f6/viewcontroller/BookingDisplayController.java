package hi.f6.viewcontroller;

import hi.f6.gui.BookingDisplay;
import hi.f6.middleware.DatabaseUtil;
import hi.f6.models.Flight;
import java.sql.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookingDisplayController {

  BookingDisplay view;
  private Flight selectedFlight;

  public BookingDisplayController(BookingDisplay view_var) {
    this.view = view_var;
  }

  public void updateFlightInfoOnClick(Flight flight) {
    if (flight == null) return;

    this.selectedFlight = flight;

    view.getFlightnumberText().setText("Flight ID: " + flight.getID());
    view.getDepLocText().setText("Departure: " + flight.getDepartureCity());
    view.getDesLocText().setText("Destination: " + flight.getDestinationCity());
    view
      .getDepTimeText()
      .setText("Departure time: " + flight.getDepartureTime().toString());
    view
      .getArrTimeText()
      .setText("Arrival time: " + flight.getArrivalTime().toString());
    view.getPriceText().setText("Price: " + flight.getPrice());
    view.getDurationText().setText("Duration: " + flight.getDuration());
    view.getLayoverText().setText("Layover: " + flight.getLayovers());
    view
      .getCfootpText()
      .setText("Carbone footprint: " + flight.getCarbonFootprint());

    view.getClassSelector().getItems().clear();
    view.getSeatSelector().getItems().clear();

    updateAvailableSeatsAndClasses(flight);
  }

  public void bookFlight() {
    if (selectedFlight == null) {
      System.out.println("No flight selected.");
      return;
    }

    String seat = (String) view.getSeatSelector().getValue();
    String flightClass = (String) view.getClassSelector().getValue();

    String message =
      "You have booked the following flight:\n" +
      "Flight ID: " +
      selectedFlight.getID() +
      "\n" +
      "From: " +
      selectedFlight.getDepartureCity() +
      "\n" +
      "To: " +
      selectedFlight.getDestinationCity() +
      "\n" +
      "Departure: " +
      selectedFlight.getDepartureTime() +
      "\n" +
      "Arrival: " +
      selectedFlight.getArrivalTime() +
      "\n" +
      "Seat: " +
      seat +
      "\n" +
      "Class: " +
      flightClass;

    System.out.println(message);

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Booking Confirmed");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  public void updateAvailableSeatsAndClasses(Flight flight) {
    if (flight == null) return;

    ObservableList<String> availableSeats = FXCollections.observableArrayList();
    ObservableList<String> availableClasses = FXCollections.observableArrayList();

    try (
      Connection conn = DatabaseUtil.getConnection();
      PreparedStatement stmt = conn.prepareStatement(
        "SELECT seatNumber, seatClass FROM Seat WHERE flightID = ? AND isAvailable = TRUE"
      )
    ) {
      stmt.setInt(1, flight.getID());
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        availableSeats.add(rs.getString("seatNumber"));
        String seatClass = rs.getString("seatClass");
        if (!availableClasses.contains(seatClass)) {
          availableClasses.add(seatClass);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    view.getSeatSelector().setItems(availableSeats);
    view.getClassSelector().setItems(availableClasses);

    if (!availableSeats.isEmpty()) {
      view.getSeatSelector().setValue(availableSeats.get(0));
    }

    if (!availableClasses.isEmpty()) {
      view.getClassSelector().setValue(availableClasses.get(0));
    }
  }

  public void hoverBookingButton() {
    this.view.getBookingButton()
      .setStyle(
        "-fx-background-color: #f0f0f0;" +
        "-fx-background-radius: 8;" +
        "-fx-border-color: lightgray;" +
        "-fx-border-width: 1;" +
        "-fx-padding: 8 15 8 15;"
      );
  }

  public void resetHoverBookingButton() {
    this.view.getBookingButton()
      .setStyle(
        "-fx-background-color: white;" +
        "-fx-background-radius: 8;" +
        "-fx-border-color: lightgray;" +
        "-fx-border-width: 1;" +
        "-fx-padding: 8 15 8 15;"
      );
  }
}
