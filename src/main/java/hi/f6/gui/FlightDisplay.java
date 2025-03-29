package hi.f6.gui;

import java.time.LocalDateTime;
import java.time.Month;

import hi.f6.models.Flight;
import hi.f6.models.Seat;
import hi.f6.viewcontroller.FlightDisplayController;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class FlightDisplay extends VBox {

    MainView parent;

    TableView<Flight> flightTable;
    FlightDisplayController flightDisplayController;

    public FlightDisplay(MainView par) {

        this.parent = par;

        this.flightDisplayController = new FlightDisplayController(this);
        flightTable = new TableView<>();

        TableColumn<Flight, String> column1 = new TableColumn<>("Reference");
        column1.setCellValueFactory(new PropertyValueFactory<>("flightRef"));

        TableColumn<Flight, String> column2 = new TableColumn<>("Departure");
        column2.setCellValueFactory(new PropertyValueFactory<>("departureCity"));

        TableColumn<Flight, String> column3 = new TableColumn<>("Destination");
        column3.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));

        TableColumn<Flight, LocalDateTime> column4 = new TableColumn<>("Departure Time");
        column4.setCellValueFactory(new PropertyValueFactory<>("departureTime"));

        TableColumn<Flight, Float> column5 = new TableColumn<>("Price");
        column5.setCellValueFactory(new PropertyValueFactory<>("price"));

        flightTable.getColumns().add(column1);
        flightTable.getColumns().add(column2);
        flightTable.getColumns().add(column3);
        flightTable.getColumns().add(column4);
        flightTable.getColumns().add(column5);

        flightTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        Seat[] seat = new Seat[3];
        seat[0] = new Seat("null", true);
        seat[1] = new Seat("null", true);
        seat[2] = new Seat("null", true);
        flightTable.getItems().add(new Flight(0, "132ED22E", "Paris", "Marseille", LocalDateTime.of(
                2021, Month.APRIL, 24, 14, 33),
                LocalDateTime.of(
                        2021, Month.APRIL, 24, 18, 13),
                200, 45, 2, seat, 40));

        this.getChildren().add(flightTable);

        // Controller calls and event handler

        flightTable.setRowFactory(tv -> {
            TableRow<Flight> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    this.flightDisplayController.onItemClicked(row.getItem());
                }
            });
            return row;
        });

    }

    // Getters

    public TableView<Flight> getFlightTable() {
        return flightTable;
    }

    public FlightDisplayController getFlightDisplayController() {
        return flightDisplayController;
    }

    public MainView getParent_() {
        return parent;
    }

}
