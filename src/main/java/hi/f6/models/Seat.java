package hi.f6.models;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Seat {

  private String seatNumber;
  private String sclass;

  private boolean isAvailable;

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

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }
}
