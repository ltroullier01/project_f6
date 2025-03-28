package hi.f6.gui;

import java.time.LocalDateTime;

import hi.f6.models.Flight;
import hi.f6.viewcontroller.FlightDisplayController;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class FlightDisplay extends VBox {

    TableView<Flight> flightTable;
    FlightDisplayController flightDisplayController;

    public FlightDisplay() {
        
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

        flightTable.getItems().add(new Flight(0, "132ED22E", "Paris", "Marseille", null, null, 200, 45, 2, null, 40));

        this.getChildren().add(flightTable);

    }

    // Getters

    public TableView<Flight> getFlightTable() {
        return flightTable;
    }

    public FlightDisplayController getFlightDisplayController() {
        return flightDisplayController;
    }
    

}
