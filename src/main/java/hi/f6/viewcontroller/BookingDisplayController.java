package hi.f6.viewcontroller;

import java.lang.reflect.Array;
import java.util.Arrays;

import hi.f6.gui.BookingDisplay;
import hi.f6.models.Flight;
import hi.f6.models.Seat;

public class BookingDisplayController {

    BookingDisplay view;

    public BookingDisplayController(BookingDisplay view_var) {
        this.view = view_var;
    }

    public void bookFlight() {
        // Database call
    }

    public void updateAvaiSeat() {

    }

    public void updateInfoFlightOnClick(Flight flight) {
        this.view.getFlightnumberText().setText("Flight Ref: " + flight.getFlightRef());
        this.view.getDesLocText().setText("Destination: " + flight.getDestinationCity());
        this.view.getDepLocText().setText("Departure: " + flight.getDepartureCity());
        this.view.getDepTimeText().setText("Departure time: " + flight.getDepartureTime().toString());
        this.view.getArrTimeText().setText("Arrival time: " + flight.getArrivalTime().toString());
        this.view.getPriceText().setText("Price: " + flight.getPrice());
        this.view.getDurationText().setText("Duration: " + flight.getDuration());
        this.view.getLayoverText().setText("Layover: " + flight.getLayovers());
        this.view.getCfootpText().setText("Carbone footprint: " + flight.getCarbonFootprint());
        this.view.getNbSeatAvaibText()
                .setText("Available seat: ");

    }

    public void hoverBookingButton() {
        this.view.getBookingButton().setStyle(
                "-fx-background-color: #f0f0f0;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-color: lightgray;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 8 15 8 15;");
    }

    public void resetHoverBookingButton() {
        this.view.getBookingButton().setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-color: lightgray;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 8 15 8 15;");
    };

}
