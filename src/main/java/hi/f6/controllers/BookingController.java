package hi.f6.controllers;

import java.util.ArrayList;

import hi.f6.models.Booking;
import hi.f6.models.Payment;

public class BookingController {

    private ArrayList<Booking> bookings;
    private ArrayList<Payment> payments;


    public void addBooking(Booking booking){
        bookings.add(booking);

    }

    public void deleteBooking(Booking booking){
        bookings.remove(booking);

    }
    
    public ArrayList<Booking> getBookings(){
        return bookings;

    }

    public void addPayment(Payment payment){
        payments.add(payment);

    }

    public void deletePayment(Payment payment){
        payments.remove(payment);

    }

    public ArrayList<Payment> getPayment(){
        return payments;

    }
    
}
