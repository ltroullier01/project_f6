package hi.f6.controllers;

import java.sql.Connection;
import java.util.ArrayList;

import hi.f6.models.PassengerReview;
import hi.f6.models.User;

public class UserController {

    private Connection con;
    private ArrayList<User> users;
    private ArrayList<PassengerReview> passengerReviews;

    public UserController(Connection con_var){
        this.con = con_var;
    }

    public void register(User user) {

    }

    public void unregister(User user) {

    }

    public boolean login(User user) {
        return true;
    }

    public boolean logout(User user) {
        return true;
    }

    public void addUser(User user) {

    }

    public void deleteUser(User user) {

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addPassengerReview(PassengerReview passengerReview) {

    }

    public void deletePassengerReview(PassengerReview passengerReview) {

    }

    public ArrayList<PassengerReview> getPassengerReviews() {
        return passengerReviews;
    }

}
