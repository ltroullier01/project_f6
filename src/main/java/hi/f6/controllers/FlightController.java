package hi.f6.controllers;

import hi.f6.database.FlightDB;
import hi.f6.database.SeatDB;
import hi.f6.models.Flight;
import hi.f6.models.Seat;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightController {

  private Connection con;
  private FlightDB flightDB;
  private SeatDB seatDB;
  private ArrayList<Flight> flights;
  private ArrayList<Seat> seats;

  public FlightController(Connection con_var) {
    this.con = con_var;
    this.flightDB = new FlightDB(this.con);
    this.seatDB = new SeatDB(this.con);
    this.flights = new ArrayList<>();
    this.seats = new ArrayList<>();
  }


  //FLIGHT CONTROLLER
  public void addFlight(Flight flight) {
    flights.add(flight);
  }

  public void deleteFlight(Flight flight) {
    flights.remove(flight);
  }

  public Flight[] getFlights() {
    return flights.toArray(new Flight[0]);
  }

  public List<Flight> search(String departureCity, String arrivalCity, LocalDate departureDate, LocalDate ArrivalDate){
    List<Flight> listeFlight = new ArrayList<>();
    //listeFlight = flightDB.getWithoutDepartureCity(departureCity, arrivalCity, departureDate, ArrivalDate);
    return listeFlight;
  }

  public List<Flight> searchWithoutDepartureCity(String departureCity, LocalDate departureDate, LocalDate ArrivalDate){
    List<Flight> listeFlight = new ArrayList<>();
    //listeFlight = flightDB.getWithoutDepartureCity(departureCity, departureDate, ArrivalDate);
    return listeFlight;
  }

  public List<Flight> searchWithoutArrivalCity(String arrivalCity, LocalDate departureDate, LocalDate ArrivalDate){
    List<Flight> listeFlight = new ArrayList<>();
    //listeFlight = flightDB.getWithoutArrivalCity(arrivalCity, departureDate, ArrivalDate);
    return listeFlight;
  }

  public List<Flight> searchWithoutDepartureAndArrivalCity(LocalDate departureDate, LocalDate ArrivalDate){
    List<Flight> listeFlight = new ArrayList<>();
    //listeFlight = flightDB.getWithoutDepartureAndArrivalCity(departureDate, ArrivalDate);
    return listeFlight;
  }






  //SEAT CONTROLLER

  public void addSeat(Seat seat) {
    seats.add(seat);
  }

  public void deleteSeat(Seat seat) {
    seats.remove(seat);
  }

  public Seat[] getSeats() {
    return seats.toArray(new Seat[0]);
  }

  public void bookSeat(Seat seat) {
    if (seats.contains(seat) && seat.isAvailable()) {
      seat.setAvailable(false);
      System.out.println(
        "Seat " + seat.getSeatNumber() + " booked successfully."
      );
    } else {
      System.out.println("Seat is either not found or already booked.");
    }
  }
}
