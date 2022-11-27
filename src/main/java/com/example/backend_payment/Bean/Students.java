package com.example.backend_payment.Bean;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.*;
@Entity
@Table(name="Students")
public class Students {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    @Column(name="fname",nullable = false)
    private String fname;
    @Column(name="lname")
    private String lname;
    @Column(name="roll_number",nullable = false,unique = true)
    private int roll_number;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(name="cgpa",nullable = false,precision = 2)
    @ColumnDefault(value = "0.0")
    private float cgpa;
    @Column(name="total_credit",nullable = false)
    private int total_credit;
    @Column(name="graduation_year")
    private int graduation_year;
    @Column(name = "password")
    private String password;

    public Students() {
    }

    public Students(String fname, String lname, int roll_number, String email, float cgpa, int total_credit, int graduation_year, String password) {
        this.fname = fname;
        this.lname = lname;
        this.roll_number = roll_number;
        this.email = email;
        this.cgpa = cgpa;
        this.total_credit = total_credit;
        this.graduation_year = graduation_year;
        this.password = password;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public int getTotal_credit() {
        return total_credit;
    }

    public void setTotal_credit(int total_credit) {
        this.total_credit = total_credit;
    }

    public int getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(int graduation_year) {
        this.graduation_year = graduation_year;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Students{" +
                "student_id'"+student_id+'\''+
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", roll_number=" + roll_number +
                ", email='" + email + '\'' +
                ", cgpa=" + cgpa +
                ", total_credit=" + total_credit +
                ", graduation_year=" + graduation_year +
                '}';
    }
}
