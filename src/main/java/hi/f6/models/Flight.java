package hi.f6.models;

import java.time.LocalDateTime;

public class Flight {

  private int flightID;
  private String departureCity;
  private String destinationCity;
  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;
  private float price;
  private int duration;
  private int layovers;
  private Seat[] seats;
  private float carbonFootprint;

  public Flight(int flightID) {
    this.flightID = flightID;
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

  public LocalDateTime getDepartureTime() {
    return departureTime;
  }

  public LocalDateTime getArrivalTime() {
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

  public Seat[] getSeats() {
    return seats;
  }

  public float getCarbonFootprint() {
    return carbonFootprint;
  }

  // Setters
  public void setDepartureCity(String departureCity) {
    this.departureCity = departureCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public void setDepartureTime(LocalDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public void setArrivalTime(LocalDateTime arrivalTime) {
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

  public void setSeats(Seat[] seats) {
    this.seats = seats;
  }

  public void setCarbonFootprint(float carbonFootprint) {
    this.carbonFootprint = carbonFootprint;
  }
}
