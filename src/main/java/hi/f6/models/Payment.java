package hi.f6.models;

import java.time.LocalDateTime;

public class Payment {
    final private int paymentID;
    final private int bookingID;
    private float amount;
    private String method;
    final private String statu;
    final private LocalDateTime transactionDate;

    public Payment(int paymentID,int bookingID,String method,String statu,LocalDateTime transactionDate){
        this.paymentID=paymentID;
        this.bookingID=bookingID;
        this.method=method;
        this.statu=statu;
        this.transactionDate=transactionDate;
    }

    public int getPaymentID(){
        return paymentID;
    }

    public int getBookingID(){
        return bookingID;
    }

    public float getAmount(){
        return amount;
    }
    
    public String getMethod(){
        return method;
    }

    public String getStatu(){
        return statu;
    }

    public LocalDateTime getTransactionDate(){
        return transactionDate;
    }

    public void setAmount(float amount){
        this.amount=amount;
    }

    public void setMethod(String method){
        this.method=method;
    }

    public void setStatu(String statu){
        this.statu=statu;
    }

    public void setTransactionDate(LocalDateTime transactionDate){
        this.transactionDate=transactionDate;
    }
}
