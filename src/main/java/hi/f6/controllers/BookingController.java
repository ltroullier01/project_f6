package hi.f6.controllers;

import java.sql.Connection;
import java.util.ArrayList;

import hi.f6.database.BookingDB;
import hi.f6.models.Booking;
import hi.f6.models.Flight;
import hi.f6.models.Payment;
import hi.f6.models.Seat;

public class BookingController {

    private Connection con;
    private BookingDB bookingDB;
    private ArrayList<Booking> bookings;
    private ArrayList<Payment> payments;

    public BookingController(Connection con_var) {
        this.con = con_var;
        this.bookingDB = new BookingDB(this.con);
    }

    public void addBooking(Seat seat, Flight flight) {
        this.bookingDB.createBooking(flight, seat);
    }

    public void deleteBooking(Booking booking) {
        bookings.remove(booking);

    }

    public ArrayList<Booking> getBookings() {
        return bookings;

    }

    public void addPayment(Payment payment) {
        payments.add(payment);

    }

    public void deletePayment(Payment payment) {
        payments.remove(payment);

    }

    public ArrayList<Payment> getPayment() {
        return payments;

    }

}
