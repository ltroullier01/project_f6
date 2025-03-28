package hi.f6.gui;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SearchDisplay extends VBox{
    Text t_title;
    TextField tf_departureCity;
    TextField tf_destinationCity;
    DatePicker dp_departureTime;
    DatePicker dp_arrivalTime;
    TextField tf_hourDeparture;
    TextField tf_hourArrival;
    Button b_search;

    public SearchDisplay(){
        this.setSpacing(10);

        this.t_title = new Text("Flight Reasearch");
        this.t_title.setFont(new Font(30));

        this.tf_departureCity = new TextField("From");
        VBox departureCityChoice = new VBox();
        departureCityChoice.getChildren().addAll(new Text("From :"),this.tf_departureCity);

        this.tf_destinationCity = new TextField("To");
        VBox arrivalCityChoice = new VBox();
        arrivalCityChoice.getChildren().addAll(new Text("To :"),this.tf_destinationCity);

        LocalDate initDate = LocalDate.now(); 
        this.dp_departureTime = new DatePicker(initDate);
        LocalTime initHour = LocalTime.now();
        this.tf_hourDeparture = new TextField(String.valueOf(initHour.getHour()));
        HBox departureChoice = new HBox();
        departureChoice.getChildren().addAll(this. dp_departureTime, this.tf_hourDeparture, new Text("h"));
        departureChoice.setAlignment(Pos.CENTER);
        VBox departureHourChoice = new VBox();
        departureHourChoice.getChildren().addAll(new Text("Departure Time :"),departureChoice);

        this.dp_arrivalTime = new DatePicker(initDate);
        this.tf_hourArrival = new TextField(String.valueOf(initHour.getHour()));
        HBox arrivalChoice = new HBox();
        arrivalChoice.getChildren().addAll(this.dp_arrivalTime, this.tf_hourArrival, new Text("h"));
        arrivalChoice.setAlignment(Pos.CENTER);
        VBox arrivalHourChoice = new VBox();
        arrivalHourChoice.getChildren().addAll(new Text("Arrival Date :"), arrivalChoice);

        this.b_search = new Button("SEARCH");

        this.getChildren().addAll(
            this.t_title, 
            departureCityChoice,
            arrivalCityChoice,
            departureHourChoice,
            arrivalHourChoice,
            this.b_search
            );
    }
}
