package hi.f6.viewcontroller;

import hi.f6.gui.FlightDisplay;
import hi.f6.gui.SearchDisplay;
import hi.f6.middleware.DatabaseUtil;
import hi.f6.models.Flight;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchDisplayController {

  //private FlightController flightController;
  private SearchDisplay searchDisplay;
  private FlightDisplay flightDisplay;

  public SearchDisplayController(
    SearchDisplay searchDisplay_var
    /*,FlightController flightController_var*/
  ) {
    this.searchDisplay = searchDisplay_var;
    //this.flightController = flightController_var;
  }

  public void setFlightDisplay(FlightDisplay flightDisplay) {
    this.flightDisplay = flightDisplay;
  }

  public void search() {
    String departureCity = this.searchDisplay.getTf_departureCity().getText();
    String arrivalCity = this.searchDisplay.getTf_destinationCity().getText();
    LocalDate departureDate =
      this.searchDisplay.getDp_departureTime().getValue();
    LocalDate arrivalDate = this.searchDisplay.getDp_arrivalTime().getValue();

    if (departureCity == "" || departureCity.equals("From")) {
      //this.flightController.searchWithoutDepartureCity();
      System.out.println("rien");
    }
    if (arrivalCity == "" || arrivalCity.equals("To")) {
      //this.flightController.searchWithoutArrivalCity();
      System.out.println("rien");
    }
    if (
      (departureCity == "" || departureCity.equals("From")) &&
      (arrivalCity == "" || arrivalCity.equals("To"))
    ) {
      //this.flightController.searchWithoutDepartureAndArrivalCity();
    }

    String from = this.searchDisplay.getTf_departureCity().getText().trim();
    String to = this.searchDisplay.getTf_destinationCity().getText().trim();
    LocalDate depDate = this.searchDisplay.getDp_departureTime().getValue();

    ObservableList<Flight> matchingFlights = FXCollections.observableArrayList();

    StringBuilder sql = new StringBuilder("SELECT * FROM Flight WHERE ");
    List<Object> params = new ArrayList<>();

    sql.append("departureTime BETWEEN ? AND ? ");

    LocalDateTime fromDate = depDate.atStartOfDay().minusDays(7);
    LocalDateTime toDate = depDate.atTime(LocalTime.MAX).plusDays(7);
    params.add(Timestamp.valueOf(fromDate));
    params.add(Timestamp.valueOf(toDate));
    // System.out.println(fromDate);

    if (!from.isBlank() && !from.equalsIgnoreCase("From")) {
      sql.append("AND departureCity = ? ");
      params.add(from);
    }

    if (!to.isBlank() && !to.equalsIgnoreCase("To")) {
      sql.append("AND destinationCity = ? ");
      params.add(to);
    }

    try (
      Connection conn = DatabaseUtil.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql.toString())
    ) {
      for (int i = 0; i < params.size(); i++) {
        stmt.setObject(i + 1, params.get(i));
      }

      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Flight flight = new Flight(rs.getInt("flightID"));
        flight.setDepartureCity(rs.getString("departureCity"));
        flight.setDestinationCity(rs.getString("destinationCity"));
        flight.setDepartureTime(
          rs.getTimestamp("departureTime").toLocalDateTime()
        );
        flight.setArrivalTime(rs.getTimestamp("arrivalTime").toLocalDateTime());
        flight.setPrice(rs.getFloat("price"));
        flight.setDuration(rs.getInt("duration"));
        flight.setLayovers(rs.getInt("layovers"));
        flight.setCarbonFootprint(rs.getFloat("carbonFootprint"));
        matchingFlights.add(flight);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (flightDisplay != null) {
      flightDisplay.setFlights(matchingFlights);
    }

    System.out.println(departureCity);
    System.out.println(arrivalCity);
    System.out.println(departureDate);
    System.out.println(arrivalDate);
  }
}
