package hi.f6.models;

import java.time.LocalDateTime;

import java.util.ArrayList;

public class Booking {

    private int bookingID;
    private User user;
    private Flight flight;
    private Seat seat;
    private int baggage;
    private LocalDateTime bookingDate;
    private Payment payment;
    private float price;


    //Get functions

    public int getBookingID(){
        return bookingID;

    }

    public User getUser(){
        return user;

    }

    public Flight getFlight(){
        return flight;

    }

    public Seat getSeat(){
        return seat;

    }

    public int getBaggage(){
        return baggage;

    }

    public Date getBookingDate(){
        return bookingDate;

    }

    public Payment getPaymnet(){
        return payment;

    }

    public float getPrice(){
        return price;

    }

    //Set functions

    public void setUser(User user){
        this.user= user; 

    }

    public void setFlight(Flight flight){
        this.flight=flight;

    }

    public void setSeat(Seat seat){
        this.seat=seat;

    }

    public void setBaggage(int baggage){
        this.baggage=baggage;

    }

    public void setBookingDate(LocalDateTime bookingDate){
        this.bookingDate=bookingDate;

    }

    public void setPayment(Payment payment){

        if(bookingID==payment.getBookingID()){
            this.payment=payment;
        } else{
            System.out.println("BookingID does not match");
        }

    }

    public void setPrice(Flight flight, int baggage, Seat seat){
        
        float totalPrice;
        float seatPrice;
        float flightPrice = flight.getPrice();
        float baggagePrice = baggage*1000;

        if (seat.getClass()=="Economy") {
            seatPrice=1000;
        }else{
            seatPrice=5000;
        }

        totalPrice = seatPrice+flightPrice+baggagePrice;


        payment.setAmount(totalPrice);
        this.price=totalPrice;

    }

    
}
