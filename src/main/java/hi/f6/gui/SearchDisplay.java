package hi.f6.gui;

import hi.f6.controllers.FlightController;
import hi.f6.models.Flight;
import hi.f6.viewcontroller.SearchDisplayController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SearchDisplay extends VBox {

  // Innitialization of attributs
  private MainView mainView;
  private TextField tf_departureCity;
  private TextField tf_destinationCity;
  private DatePicker dp_departureTime;
  private DatePicker dp_arrivalTime;
  private Button b_search;

  // Initialization of the controller of the view
  SearchDisplayController controller;

  // Constructor
  public SearchDisplay(MainView mainView_var) {
    // MainView and Controller creation
    this.mainView = mainView_var;
    this.controller = new SearchDisplayController(this, this.mainView.getFlightController());

    // Title of the section
    HBox title = new HBox();
    Text t_title = new Text("Flight Reasearch");
    t_title.setFont(new Font(20));
    title.setAlignment(Pos.CENTER);
    title.getChildren().addAll(t_title);

    // Departure City components
    this.tf_departureCity = new TextField("From");
    VBox departureCityChoice = new VBox();
    departureCityChoice
      .getChildren()
      .addAll(new Text("From :"), this.tf_departureCity);

    // Destination City components
    this.tf_destinationCity = new TextField("To");
    VBox arrivalCityChoice = new VBox();
    arrivalCityChoice
      .getChildren()
      .addAll(new Text("To :"), this.tf_destinationCity);

    // Date&Time departure components
    LocalDate initDate = LocalDate.now();
    this.dp_departureTime = new DatePicker(initDate);
    VBox departureHourChoice = new VBox();
    departureHourChoice.setAlignment(Pos.CENTER);
    departureHourChoice
      .getChildren()
      .addAll(new Text("Departure Date :"), this.dp_departureTime);

    // Date&Time arrival components
    this.dp_arrivalTime = new DatePicker(initDate);
    VBox arrivalHourChoice = new VBox();
    arrivalHourChoice.setAlignment(Pos.CENTER);
    arrivalHourChoice
      .getChildren()
      .addAll(new Text("Arrival Date :"), this.dp_arrivalTime);

    // Search button
    this.b_search = new Button("SEARCH");
    this.b_search.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent e) {
            List<Flight> searchResult = new ArrayList<>();
            mainView.getFd().getFlightDisplayController().updateTable(controller.search());
          }
        }
      );
    HBox buttonCenter = new HBox();
    buttonCenter.setAlignment(Pos.CENTER);
    buttonCenter.getChildren().addAll(this.b_search);

    // Initialization of the view
    this.setSpacing(20);
    this.getChildren()
      .addAll(
        title,
        departureCityChoice,
        arrivalCityChoice,
        departureHourChoice,
        arrivalHourChoice,
        buttonCenter
      );
  }

  // GETTERS
  public TextField getTf_departureCity() {return tf_departureCity;}
  public TextField getTf_destinationCity() {return tf_destinationCity;}
  public DatePicker getDp_departureTime() {return dp_departureTime;}
  public DatePicker getDp_arrivalTime() {return dp_arrivalTime;}
  public Button getB_search() {return b_search;}
}
