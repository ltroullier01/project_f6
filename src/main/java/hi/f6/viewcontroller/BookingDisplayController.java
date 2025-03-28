package hi.f6.viewcontroller;

import hi.f6.gui.BookingDisplay;

public class BookingDisplayController {

    BookingDisplay view;

    public BookingDisplayController(BookingDisplay view_var) {
        this.view = view_var;
    }

    public void updateFlightInfoOnClick() {

    }

    public void bookFlight() {

    }

    public void updateAvaiSeat() {

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
