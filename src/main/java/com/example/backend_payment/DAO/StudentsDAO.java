package com.example.backend_payment.DAO;

import com.example.backend_payment.Bean.Student_Payment;
import com.example.backend_payment.Bean.Students;

import java.util.List;

public interface StudentsDAO {
    boolean addStudent(Students stuObj);
    List<Students> getStudentList();
    Students getStudent(int id);
    List<Student_Payment> getDetails(int id);
    Students login(Students students);
}