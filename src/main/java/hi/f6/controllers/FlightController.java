package hi.f6.controllers;

import hi.f6.models.Flight;
import hi.f6.models.Seat;
import java.util.ArrayList;

public class FlightController {

  private ArrayList<Flight> flights;
  private ArrayList<Seat> seats;

  public FlightController() {
    this.flights = new ArrayList<>();
    this.seats = new ArrayList<>();
  }

  public void addFlight(Flight flight) {
    flights.add(flight);
  }

  public void deleteFlight(Flight flight) {
    flights.remove(flight);
  }

  public Flight[] getFlights() {
    return flights.toArray(new Flight[0]);
  }

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
