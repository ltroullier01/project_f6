package hi.f6.models;

public class Seat {

  private String seatNumber;
  private boolean isAvailable;
  private int seatID;
  private int flightNumber;
  private String seatClass;

  public Seat(String seatNumber, boolean isAvailable) {
    this.seatNumber = seatNumber;
    this.isAvailable = isAvailable;
  }

  public String getSeatNumber() {
    return seatNumber;
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
