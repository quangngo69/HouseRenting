package model;

import java.sql.Date;

public class RentalPayment {
    private int paymentId;
    private int rentingId;
    private double totalAmount;
    private double commissionAmount;
    private String status;
    private Date paidDay;

    // Constructor
    public RentalPayment(int paymentId, int rentingId, double totalAmount, double commissionAmount, String status, Date paidDay) {
        this.paymentId = paymentId;
        this.rentingId = rentingId;
        this.totalAmount = totalAmount;
        this.commissionAmount = commissionAmount;
        this.status = status;
        this.paidDay = paidDay;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getRentingId() {
        return rentingId;
    }

    public void setRentingId(int rentingId) {
        this.rentingId = rentingId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPaidDay() {
        return paidDay;
    }

    public void setPaidDay(Date paidDay) {
        this.paidDay = paidDay;
    }
}