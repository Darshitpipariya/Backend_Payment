package com.example.backend_payment.Util;


import com.example.backend_payment.Bean.Bills;
import com.example.backend_payment.Bean.Student_Payment;
import com.example.backend_payment.Bean.Students;
import com.example.backend_payment.DAO.BillsDAO;
import com.example.backend_payment.DAO.DAOImplementation.BillsDAOImplementation;
import com.example.backend_payment.DAO.DAOImplementation.Student_PaymentDAOImplementation;
import com.example.backend_payment.DAO.DAOImplementation.StudentsDAOImplementation;
import com.example.backend_payment.DAO.Student_PaymentDAO;
import com.example.backend_payment.DAO.StudentsDAO;

import java.util.Arrays;
import java.util.List;

public class InitializeDB {
    public static void main(String[] args) {
        List<List<Object>> students = Arrays.asList(
                Arrays.asList( "Darshit", "Pipariya", 2022001, "Darshit.Pipariya@gmail.com",8.5f,16,2024,"darshit"),
                Arrays.asList( "Aryan", "Patel", 2022002, "Aryan.Patel@gmail.com",8.0f,16,2024,"aryan"),
                Arrays.asList( "Anish", "Sharma", 2022003, "Anish.Sharma@gmail.com",8.7f,16,2024,"anish"),
                Arrays.asList( "Abhirup", "Chakraborty", 2022004, "Abhirup.Chakraborty@gmail.com",8.9f,16,2024,"abhirup"),
                Arrays.asList( "Anuj", "Jain", 2022005, "Anuj.Jain@gmail.com",8.9f,16,2024,"anuj")
        );

        List<List<Object>> bills = Arrays.asList(
                Arrays.asList(1000000,"10-10-2022",1,1000000),
                Arrays.asList(2000000,"11-10-2022",1,2000000),
                Arrays.asList(1000000,"10-10-2022",2,1000000),
                Arrays.asList(2000000,"11-10-2022",2,2000000),
                Arrays.asList(1000000,"10-10-2022",3,1000000),
                Arrays.asList(2000000,"11-10-2022",3,2000000),
                Arrays.asList(1000000,"10-10-2022",4,1000000),
                Arrays.asList(2000000,"11-10-2022",4,2000000),
                Arrays.asList(1000000,"10-10-2022",5,1000000),
                Arrays.asList(2000000,"11-10-2022",5,2000000)
        );

        List<List<Object>> bill_payments = Arrays.asList(
                Arrays.asList(100000,"10-10-2022",1),
                Arrays.asList(200000,"11-10-2022",1),
                Arrays.asList(100000,"10-10-2022",2),
                Arrays.asList(200000,"11-10-2022",2),
                Arrays.asList(100000,"10-10-2022",3),
                Arrays.asList(200000,"11-10-2022",3),
                Arrays.asList(100000,"10-10-2022",4),
                Arrays.asList(200000,"11-10-2022",4),
                Arrays.asList(100000,"10-10-2022",5),
                Arrays.asList(200000,"11-10-2022",5),
                Arrays.asList(100000,"10-10-2022",6),
                Arrays.asList(200000,"11-10-2022",6),
                Arrays.asList(100000,"10-10-2022",7),
                Arrays.asList(200000,"11-10-2022",7),
                Arrays.asList(100000,"10-10-2022",8),
                Arrays.asList(200000,"11-10-2022",8),
                Arrays.asList(100000,"10-10-2022",9),
                Arrays.asList(200000,"11-10-2022",9),
                Arrays.asList(100000,"10-10-2022",10),
                Arrays.asList(200000,"11-10-2022",10)
        );

        StudentsDAO studentsDAO=new StudentsDAOImplementation();
        for(List<Object> student:students){
            Students s=new Students((String) student.get(0),
                    (String) student.get(1),
                    (int) student.get(2),
                    (String) student.get(3),
                    (float) student.get(4),
                    (int) student.get(5),
                    (int) student.get(6),
                    (String) student.get(7)
            );
            studentsDAO.addStudent(s);
        }

        BillsDAO billsDAO=new BillsDAOImplementation();
        for (List<Object> bill:bills){
            Bills b=new Bills(
                    (int) bill.get(0),
                    (String) bill.get(1),
                    (Students) studentsDAO.getStudent((int)bill.get(2)),
                    (int) bill.get(3)
            );
            billsDAO.addBills(b);
        }

        Student_PaymentDAO student_paymentDAO=new Student_PaymentDAOImplementation();
        for(List<Object> payment:bill_payments){
            Student_Payment student_payment=new Student_Payment(
                    (int) payment.get(0),
                    (String) payment.get(1),
                    (Bills) billsDAO.getBill((int) payment.get(2))
            );
            student_paymentDAO.addPayment(student_payment);
        }
    }
}
