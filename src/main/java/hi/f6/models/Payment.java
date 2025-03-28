package hi.f6.models;

import java.time.LocalDateTime;

public class Payment {
    private int paymentID;
    private int bookingID;
    private float amount;
    private String method;
    private String statu;
    private LocalDateTime transactionDate;

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
