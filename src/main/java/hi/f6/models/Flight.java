package hi.f6.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Flight {

  private int flightID;
  private String flightRef;
  private String departureCity;
  private String destinationCity;
  private LocalDate departureTime;
  private LocalDate arrivalTime;
  private float price;
  private int duration;
  private int layovers;
  private List<Seat> seats;
  private float carbonFootprint;

  public Flight(int flightID) {
    this.flightID = flightID;
  }

  public Flight(int flightID, String flightRef, String departureCity, String destinationCity,
      LocalDate departureTime, LocalDate arrivalTime, float price, int duration, int layovers, List<Seat> seats,
      float carbonFootprint) {
    this.flightID = flightID;
    this.flightRef = flightRef;
    this.departureCity = departureCity;
    this.destinationCity = destinationCity;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.price = price;
    this.duration = duration;
    this.layovers = layovers;
    this.seats = seats;
    this.carbonFootprint = carbonFootprint;
  }

  public Flight(int flightID, String flightRef, String departureCity, String destinationCity, LocalDate departureTime,
      LocalDate arrivalTime, float price, int duration, int layovers, float carbonFootprint) {
    this.flightID = flightID;
    this.flightRef = flightRef;
    this.departureCity = departureCity;
    this.destinationCity = destinationCity;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.price = price;
    this.duration = duration;
    this.layovers = layovers;
    this.carbonFootprint = carbonFootprint;
  }

  // Getters
  public int getID() {
    return flightID;
  }

  public String getDepartureCity() {
    return departureCity;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  public LocalDate getDepartureTime() {
    return departureTime;
  }

  public LocalDate getArrivalTime() {
    return arrivalTime;
  }

  public float getPrice() {
    return price;
  }

  public int getDuration() {
    return duration;
  }

  public int getLayovers() {
    return layovers;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public float getCarbonFootprint() {
    return carbonFootprint;
  }

  public int getFlightID() {
    return flightID;
  }

  public String getFlightRef() {
    return flightRef;
  }

  // Setters
  public void setDepartureCity(String departureCity) {
    this.departureCity = departureCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public void setDepartureTime(LocalDate departureTime) {
    this.departureTime = departureTime;
  }

  public void setArrivalTime(LocalDate arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void setLayovers(int layovers) {
    this.layovers = layovers;
  }

  public void setSeats(List<Seat> seats) {
    this.seats = seats;
  }

  public void setCarbonFootprint(float carbonFootprint) {
    this.carbonFootprint = carbonFootprint;
  }

  public void setFlightID(int flightID) {
    this.flightID = flightID;
  }

  public void setFlightRef(String flightRef) {
    this.flightRef = flightRef;
  }
}
