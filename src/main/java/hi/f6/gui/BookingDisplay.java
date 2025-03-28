package hi.f6.gui;

import hi.f6.controllers.FlightController;
import hi.f6.viewcontroller.BookingDisplayController;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BookingDisplay extends VBox {

        BookingDisplayController bkDbController;
        FlightController flightController;

        Text flightnumberText;
        Text desLocText;
        Text depLocText;

        Text depTimeText;
        Text arrTimeText;
        Text priceText;
        Text durationText;
        Text layoverText;
        Text cfootpText;
        Text nbSeatAvaibText;

        ChoiceBox classSelector;
        ChoiceBox seatSelector;

        Button bookingButton;

        public BookingDisplay(FlightController fl_cont) {

                // Component initialisation and creation

                this.bkDbController = new BookingDisplayController(this);
                this.flightController = fl_cont;

                this.setSpacing(13);

                HBox alignmentBoxFnb = new HBox();
                HBox alignmentBoxBook = new HBox();
                HBox boxSeat = new HBox();
                HBox boxClass = new HBox();

                this.flightnumberText = new Text("Flight ID: ");
                this.desLocText = new Text("Destination: ");
                this.depLocText = new Text("Departure: ");
                this.depTimeText = new Text("Departure time: ");
                this.arrTimeText = new Text("Arrival time: ");
                this.priceText = new Text("Price: ");
                this.durationText = new Text("Duration: ");
                this.layoverText = new Text("Layover: ");
                this.cfootpText = new Text("Carbone footprint: ");
                this.nbSeatAvaibText = new Text("Available seat: ");

                Text classText = new Text("Class: ");
                Text seatText = new Text("Seat: ");
                this.classSelector = new ChoiceBox<String>();
                this.seatSelector = new ChoiceBox<String>();

                this.bookingButton = new Button("Book");
                this.bookingButton.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 8;" +
                                                "-fx-border-color: lightgray;" +
                                                "-fx-border-width: 1;" +
                                                "-fx-padding: 8 15 8 15;");

                // Add to the view

                alignmentBoxFnb.getChildren().add(flightnumberText);
                alignmentBoxFnb.setAlignment(Pos.CENTER);
                alignmentBoxBook.getChildren().add(bookingButton);
                alignmentBoxBook.setAlignment(Pos.CENTER);

                boxClass.getChildren().addAll(classText, classSelector);
                boxSeat.getChildren().addAll(seatText, seatSelector);

                this.getChildren().addAll(
                                alignmentBoxFnb, depLocText, desLocText, depTimeText, arrTimeText,
                                durationText, layoverText, cfootpText, boxClass, nbSeatAvaibText, boxSeat, priceText,
                                alignmentBoxBook);

                // Event handler and controller calls

                this.classSelector.setOnAction(e -> {
                        this.bkDbController.updateAvaiSeat();
                });

                this.bookingButton.setOnMouseClicked(e -> {
                        this.bkDbController.bookFlight();
                });

                this.bookingButton.setOnMouseEntered(e -> {
                        this.bkDbController.hoverBookingButton();
                });

                this.bookingButton.setOnMouseExited(e -> {
                        this.bkDbController.resetHoverBookingButton();
                });

        }

        // Getter

        public Text getFlightnumberText() {
                return flightnumberText;
        }

        public Text getDesLocText() {
                return desLocText;
        }

        public Text getDepLocText() {
                return depLocText;
        }

        public Text getDepTimeText() {
                return depTimeText;
        }

        public Text getArrTimeText() {
                return arrTimeText;
        }

        public Text getPriceText() {
                return priceText;
        }

        public Text getDurationText() {
                return durationText;
        }

        public Text getLayoverText() {
                return layoverText;
        }

        public Text getCfootpText() {
                return cfootpText;
        }

        public Text getNbSeatAvaibText() {
                return nbSeatAvaibText;
        }

        public ChoiceBox getClassSelector() {
                return classSelector;
        }

        public ChoiceBox getSeatSelector() {
                return seatSelector;
        }

        public Button getBookingButton() {
                return bookingButton;
        }

}
