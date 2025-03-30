package hi.f6.controllers;

import hi.f6.models.PassengerReview;
import hi.f6.models.User;
import java.util.ArrayList;

public class UserController {

  private ArrayList<User> users;
  private ArrayList<PassengerReview> passengerReviews;

  public void register(User user) {}

  public void unregister(User user) {}

  public boolean login(User user) {
    //check if user exists
    return true;
  }

  public boolean logout(User user) {
    //check if user exists
    return true;
  }

  public void addUser(User user) {}

  public void deleteUser(User user) {}

  public ArrayList<User> getUsers() {
    return users;
  }

  public void addPassengerReview(PassengerReview passengerReview) {}

  public void deletePassengerReview(PassengerReview passengerReview) {}

  public ArrayList<PassengerReview> getPassengerReviews() {
    return passengerReviews;
  }
}
