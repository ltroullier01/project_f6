package hi.f6.viewcontroller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import hi.f6.controllers.FlightController;
import hi.f6.gui.SearchDisplay;
import hi.f6.models.Flight;
import hi.f6.models.Seat;

public class SearchDisplayController {

    // Innitialization of attributs
    private SearchDisplay searchDisplay;
    private FlightController flightController;

    // Constructor
    public SearchDisplayController(SearchDisplay searchDisplay_var, FlightController flightController_var) {
        this.searchDisplay = searchDisplay_var;
        this.flightController = flightController_var;
    }

    // Search method depending on the different cases
    public List<Flight> search() {

        // Recovery of values
        String departureCity = this.searchDisplay.getTf_departureCity().getText();
        String arrivalCity = this.searchDisplay.getTf_destinationCity().getText();
        LocalDate departureDate = this.searchDisplay.getDp_departureTime().getValue();
        LocalDate arrivalDate = this.searchDisplay.getDp_arrivalTime().getValue();

        List<Flight> searchResult = new ArrayList<>();

        // Verification of the case
        if ((departureCity == "" || departureCity.equals("From")) && (arrivalCity == "" || arrivalCity.equals("To"))) {
            searchResult = this.flightController.searchWithoutDepartureAndArrivalCity(departureDate, arrivalDate);
        } else if (departureCity == "" || departureCity.equals("From")) {
            searchResult = this.flightController.searchWithoutDepartureCity(arrivalCity, departureDate, arrivalDate);
        } else if (arrivalCity == "" || arrivalCity.equals("To")) {
            searchResult = this.flightController.searchWithoutArrivalCity(departureCity, departureDate, arrivalDate);
        } else {
            searchResult = this.flightController.search(departureCity, arrivalCity, departureDate, arrivalDate);
        }

        return searchResult;
    }
}
