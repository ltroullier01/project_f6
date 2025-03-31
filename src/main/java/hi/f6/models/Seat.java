package hi.f6.models;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Seat {

  private int id;
  private int flight_id;
  private String seatNumber;
  private String sclass;

  private boolean isAvailable;

  public Seat(int id_var, int fl_id, String seatNumber, boolean isAvailable, String claString) {
    this.id = id_var;
    this.flight_id = fl_id;
    this.seatNumber = seatNumber;
    this.isAvailable = isAvailable;
    this.sclass = claString;
  }

  public static List<Seat> getNbEco(List<Seat> seats) {
    return seats.stream().filter(seat -> (seat.getSclass().equals("eco") && seat.isAvailable()))
        .collect(Collectors.toList());
  }

  public static List<Seat> getNbPrenium(List<Seat> seats) {
    return seats.stream().filter(seat -> seat.getSclass().equals("prem") && seat.isAvailable())
        .collect(Collectors.toList());

  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public String getSclass() {
    return sclass;
  }

  public int getId() {
    return id;
  }

  public int getFlight_id() {
    return flight_id;
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

  @Override
  public String toString() {
    return seatNumber;
  }

}
