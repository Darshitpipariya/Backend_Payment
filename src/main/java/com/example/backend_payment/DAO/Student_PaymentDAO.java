package com.example.backend_payment.DAO;

import com.example.backend_payment.Bean.Student_Payment;

import java.util.List;

public interface Student_PaymentDAO {
    boolean addPayment(Student_Payment student_payment);
    //get Payments for particular bill
    List<Student_Payment> getPaymentList(int billid);
    List<Student_Payment> getAllPaymentsList();
    Student_Payment getPayment(int paymentid);
}
