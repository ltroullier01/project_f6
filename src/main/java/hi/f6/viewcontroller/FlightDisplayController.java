package hi.f6.viewcontroller;

import java.util.List;

import hi.f6.gui.FlightDisplay;
import hi.f6.models.Flight;

public class FlightDisplayController {

    FlightDisplay view;

    public FlightDisplayController(FlightDisplay view_var) {
        this.view = view_var;
    }

    public void updateTable(List<Flight> flight_list) {
        this.view.getFlightTable().getItems().clear();
        this.view.getFlightTable().getItems().addAll(flight_list);
    }

    public void onItemClicked(Flight flight) {
        this.view.getParent_().getBd().getBkDbController().updateInfoFlightOnClick(flight);
    }

}
