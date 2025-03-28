package hi.f6.viewcontroller;

import java.time.LocalDate;

import hi.f6.controllers.FlightController;
import hi.f6.gui.SearchDisplay;

public class SearchDisplayController {

    // Innitialization of attributs
    private SearchDisplay searchDisplay;
    private FlightController flightController;

    // Constructor
    public SearchDisplayController (SearchDisplay searchDisplay_var,FlightController flightController_var){
        this.searchDisplay = searchDisplay_var;
        this.flightController = flightController_var;
    }

    // Search methid depending on the different cases
    public void search(){

        // Recovery of values
        String departureCity = this.searchDisplay.getTf_departureCity().getText();
        String arrivalCity = this.searchDisplay.getTf_destinationCity().getText();
        LocalDate departureDate = this.searchDisplay.getDp_departureTime().getValue();
        LocalDate arrivalDate = this.searchDisplay.getDp_arrivalTime().getValue();

        // Verification of the case
        if((departureCity == ""||departureCity.equals("From"))&&(arrivalCity == ""||arrivalCity.equals("To"))){
            //this.flightController.searchWithoutDepartureAndArrivalCity();
            System.out.println("Without Departure & Arrival");
        }else if(departureCity == ""||departureCity.equals("From")){
            //this.flightController.searchWithoutDepartureCity();
            System.out.println("Without Departure");
            System.out.println("Destination : "+arrivalCity);
        }else if(arrivalCity == ""||arrivalCity.equals("To")){
            //this.flightController.searchWithoutArrivalCity();
            System.out.println("Without Arrival");
            System.out.println("Departure : "+departureCity);
        } else {
            //this.flightController.search();
            System.out.println("Departure : "+departureCity);
            System.out.println("Destination : "+arrivalCity);
        }
        System.out.println(departureDate);
        System.out.println(arrivalDate);
    }
}
