package hi.f6.gui;

import java.time.LocalDateTime;
import java.time.Month;

import hi.f6.controllers.FlightController;
import hi.f6.models.Flight;
import hi.f6.models.Seat;
import hi.f6.viewcontroller.FlightDisplayController;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FlightDisplay extends VBox {

    MainView parent;

    TableView<Flight> flightTable;
    FlightDisplayController flightDisplayController;
    FlightController flightController;

    Flight selectedFlight;

    public FlightDisplay(MainView par, FlightController fController) {

        this.setSpacing(13);

        this.parent = par;
        this.flightController = fController;

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

        Text title = new Text("Research results: ");
        title.setFont(new Font(30));
        HBox hBoxTitle = new HBox(title);
        hBoxTitle.setAlignment(Pos.CENTER);

        this.getChildren().addAll(hBoxTitle, flightTable);

        // Controller calls and event handler

        flightTable.setRowFactory(tv -> {
            TableRow<Flight> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    this.selectedFlight = row.getItem();
                    this.flightDisplayController.onItemClicked(this.selectedFlight);
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

    public FlightController getFlightController() {
        return flightController;
    }

}
