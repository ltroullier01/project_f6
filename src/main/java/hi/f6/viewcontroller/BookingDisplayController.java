package hi.f6.viewcontroller;

import java.lang.reflect.Array;
import java.util.Arrays;

import hi.f6.gui.BookingDisplay;
import hi.f6.models.Flight;
import hi.f6.models.Seat;

public class BookingDisplayController {

    BookingDisplay view;

    Flight selectedFlight;

    public BookingDisplayController(BookingDisplay view_var) {
        this.view = view_var;
    }

    public void bookFlight() {
        this.view.getFlightController().bookSeat(this.view.getSeatSelector().getValue());
        this.view.getBookingController().addBooking(this.view.getSeatSelector().getValue(), selectedFlight);
    }

    public void updateAvaiSeat() {
        if (this.selectedFlight != null) {
            this.view.getSeatSelector().getItems().clear();
            if (this.view.getClassSelector().getValue() == "eco") {
                this.view.getNbSeatAvaibText()
                        .setText("Available seat: " + Seat.getNbEco(this.selectedFlight.getSeats()).size());
                this.view.getSeatSelector().getItems().addAll(Seat.getNbEco(this.selectedFlight.getSeats()));
            } else {
                this.view.getNbSeatAvaibText()
                        .setText("Available seat: " + Seat.getNbPrenium(this.selectedFlight.getSeats()).size());
                this.view.getSeatSelector().getItems().addAll(Seat.getNbPrenium(this.selectedFlight.getSeats()));
            }
        }
    }

    public void updateInfoFlightOnClick(Flight flight) {
        this.selectedFlight = flight;
        this.view.getFlightnumberText().setText("Flight Ref: " + flight.getFlightRef());
        this.view.getDesLocText().setText("Destination: " + flight.getDestinationCity());
        this.view.getDepLocText().setText("Departure: " + flight.getDepartureCity());
        this.view.getDepTimeText().setText("Departure time: " + flight.getDepartureTime().toString());
        this.view.getArrTimeText().setText("Arrival time: " + flight.getArrivalTime().toString());
        this.view.getPriceText().setText("Price: " + flight.getPrice());
        this.view.getDurationText().setText("Duration: " + flight.getDuration());
        this.view.getLayoverText().setText("Layover: " + flight.getLayovers());
        this.view.getCfootpText().setText("Carbone footprint: " + flight.getCarbonFootprint());
        updateAvaiSeat();

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
