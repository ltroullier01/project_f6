package hi.f6.viewcontroller;

import hi.f6.gui.FlightDisplay;
import hi.f6.gui.MainView;
import hi.f6.models.Flight;
import java.util.List;

public class FlightDisplayController {

  FlightDisplay view;
  private MainView mainView;

  public FlightDisplayController(FlightDisplay view, MainView mainView) {
    this.view = view;
    this.mainView = mainView;
  }

  public void updateTable(List<Flight> flight_list) {
    this.view.getFlightTable().getItems().clear();
    this.view.getFlightTable().getItems().addAll(flight_list);
  }

  public void onItemClicked(Flight flight) {
    mainView.getBD().getController().updateFlightInfoOnClick(flight);
  }
}
