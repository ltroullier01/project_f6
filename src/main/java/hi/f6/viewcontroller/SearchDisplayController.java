package hi.f6.viewcontroller;

import java.time.LocalDate;

import hi.f6.gui.SearchDisplay;

public class SearchDisplayController {

    //private FlightController flightController;
    private SearchDisplay searchDisplay;

    public SearchDisplayController (SearchDisplay searchDisplay_var/*,FlightController flightController_var*/){
        this.searchDisplay = searchDisplay_var;
        //this.flightController = flightController_var;
    }

    public void search(){
        String departureCity = this.searchDisplay.getTf_departureCity().getText();
        String arrivalCity = this.searchDisplay.getTf_destinationCity().getText();
        LocalDate departureDate = this.searchDisplay.getDp_departureTime().getValue();
        LocalDate arrivalDate = this.searchDisplay.getDp_arrivalTime().getValue();

        if(departureCity == ""||departureCity.equals("From")){
            //this.flightController.searchWithoutDepartureCity();
            System.out.println("rien");
        }
        if(arrivalCity == ""||arrivalCity.equals("To")){
            //this.flightController.searchWithoutArrivalCity();
            System.out.println("rien");
        }
        if((departureCity == ""||departureCity.equals("From"))&&(arrivalCity == ""||arrivalCity.equals("To"))){
            //this.flightController.searchWithoutDepartureAndArrivalCity();
        }
        
        System.out.println(departureCity);
        System.out.println(arrivalCity);
        System.out.println(departureDate);
        System.out.println(arrivalDate);
    }
}
