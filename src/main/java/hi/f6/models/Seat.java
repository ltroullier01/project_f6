package hi.f6.models;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Seat {

  private String seatNumber;
  private String sclass;

  private boolean isAvailable;
  private int seatID;
  private int flightNumber;
  private String seatClass;

  public Seat(String seatNumber, boolean isAvailable) {
    this.seatNumber = seatNumber;
    this.isAvailable = isAvailable;
    this.sclass = "prem";
  }

  public static int getNbEco(List<Seat> seats) {
    return seats.stream().filter(seat -> seat.getSclass() == "eco").collect(Collectors.toList()).size();
  }

  public static int getNbPrenium(List<Seat> seats) {
    return seats.stream().filter(seat -> seat.getSclass() == "prem").collect(Collectors.toList()).size();

  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public String getSclass() {
    return sclass;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public int getSeatID() {
    return seatID;
  }

  public int getFlightNumber() {
    return flightNumber;
  }

  public String getSeatClass() {
    return seatClass;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public void setSeatID(int seatID) {
    this.seatID = seatID;
  }

  public void setFlightNumber(int flightNumber) {
    this.flightNumber = flightNumber;
  }

  public void setSeatClass(String seatClass) {
    this.seatClass = seatClass;
  }
}
