package hi.f6.viewcontroller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hi.f6.controllers.FlightController;
import hi.f6.gui.SearchDisplay;
import hi.f6.models.Flight;

public class SearchDisplayController {

    // Innitialization of attributs
    private SearchDisplay searchDisplay;
    private FlightController flightController;

    // Constructor
    public SearchDisplayController (SearchDisplay searchDisplay_var, FlightController flightController_var){
        this.searchDisplay = searchDisplay_var;
        this.flightController = flightController_var;
    }

    // Search methid depending on the different cases
    public List<Flight> search(){

        // Recovery of values
        String departureCity = this.searchDisplay.getTf_departureCity().getText();
        String arrivalCity = this.searchDisplay.getTf_destinationCity().getText();
        LocalDate departureDate = this.searchDisplay.getDp_departureTime().getValue();
        LocalDate arrivalDate = this.searchDisplay.getDp_arrivalTime().getValue();

        List<Flight> searchResult = new ArrayList<>();

        // Verification of the case
        if((departureCity == ""||departureCity.equals("From"))&&(arrivalCity == ""||arrivalCity.equals("To"))){
            searchResult = this.flightController.searchWithoutDepartureAndArrivalCity(departureDate, arrivalDate);
            System.out.println("Without Departure & Arrival");
        }else if(departureCity == ""||departureCity.equals("From")){
            searchResult = this.flightController.searchWithoutDepartureCity(arrivalCity, departureDate, arrivalDate);
            System.out.println("Without Departure");
            System.out.println("Destination : "+arrivalCity);
        }else if(arrivalCity == ""||arrivalCity.equals("To")){
            searchResult = this.flightController.searchWithoutArrivalCity(departureCity, departureDate, arrivalDate);
            System.out.println("Without Arrival");
            System.out.println("Departure : "+departureCity);
        } else {
            searchResult = this.flightController.search(departureCity, arrivalCity, departureDate, arrivalDate);
            System.out.println("Departure : "+departureCity);
            System.out.println("Destination : "+arrivalCity);
        }
        System.out.println(departureDate);
        System.out.println(arrivalDate);

        searchResult.add(new Flight(0, "152TR22E", "Prague", "Marseille", null, null, 9000, 45, 2, null, 40));
        searchResult.add(new Flight(0, "132PL67E", "Praque", "Lille", null, null, 20, 45, 2, null, 40));
        return searchResult;
    }
}
