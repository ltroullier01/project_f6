package hi.f6.gui;

import hi.f6.models.Flight;
import hi.f6.viewcontroller.FlightDisplayController;
import java.util.function.Consumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FlightDisplay extends VBox {

  private TableView<Flight> flightTable;
  private ObservableList<Flight> flightList;
  private FlightDisplayController controller;

  public FlightDisplay(MainView mainView) {
    Text title = new Text("Available Flights");
    title.setFont(new Font(20));

    flightTable = new TableView<>();
    flightList = FXCollections.observableArrayList();

    // Table columns
    TableColumn<Flight, Integer> idCol = new TableColumn<>("ID");
    idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));

    TableColumn<Flight, String> depCol = new TableColumn<>("From");
    depCol.setCellValueFactory(new PropertyValueFactory<>("departureCity"));

    TableColumn<Flight, String> destCol = new TableColumn<>("To");
    destCol.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));

    TableColumn<Flight, String> depTimeCol = new TableColumn<>("Departure");
    depTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureTime"));

    TableColumn<Flight, String> arrTimeCol = new TableColumn<>("Arrival");
    arrTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));

    TableColumn<Flight, Float> priceCol = new TableColumn<>("Price");
    priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    flightTable
      .getColumns()
      .addAll(idCol, depCol, destCol, depTimeCol, arrTimeCol, priceCol);

    // Configure table
    flightTable.setItems(flightList);
    flightTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    flightTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    controller = new FlightDisplayController(this, mainView);
    flightTable
      .getSelectionModel()
      .selectedItemProperty()
      .addListener((obs, oldSel, newSel) -> {
        if (newSel != null) {
          controller.onItemClicked(newSel);
        }
      });

    this.setSpacing(10);
    this.getChildren().addAll(title, flightTable);
  }

  // Public method to populate flights
  public void setFlights(ObservableList<Flight> flights) {
    this.flightList.setAll(flights);
  }

  // Get selected flight
  public TableView<Flight> getFlightTable() {
    return flightTable;
  }

  public FlightDisplayController getFlightDisplayController() {
    return controller;
  }
}
