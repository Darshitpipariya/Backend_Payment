package com.example.backend_payment.Bean;

import jakarta.persistence.*;

@Entity
@Table(name="Student_Payment")
public class Student_Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;
    @Column(name = "description")
    private String description;
    @Column(name="amount",nullable = false)
    private int amount;
    @Column(name="payment_date",nullable = false)
    private String payment_date;
    @ManyToOne
    @JoinColumn(name="bill_id")
    private Bills bill;

    @Column(name="remaining")
    private int remaining;

    public Student_Payment() {
    }

    public Student_Payment(int amount, String payment_date, Bills bill) {
        this.amount = amount;
        this.payment_date = payment_date;
        this.bill = bill;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }


    @Override
    public String toString() {
        return "Student_Payment{" +
                "amount=" + amount +
                ", payment_date='" + payment_date + '\'' +
                ", bill=" + bill +
                ", remaining=" + remaining +
                '}';
    }
}
