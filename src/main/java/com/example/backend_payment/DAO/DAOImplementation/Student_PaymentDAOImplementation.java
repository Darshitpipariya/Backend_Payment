package com.example.backend_payment.DAO.DAOImplementation;

import com.example.backend_payment.Bean.Bills;
import com.example.backend_payment.Bean.Student_Payment;
import com.example.backend_payment.DAO.Student_PaymentDAO;
import com.example.backend_payment.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Student_PaymentDAOImplementation implements Student_PaymentDAO {
    @Override
    public boolean addPayment(Student_Payment student_payment){
        try(Session session= HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            Bills bills=session.get(Bills.class,student_payment.getBill().getBill_id());
            bills.setRemaining(bills.getRemaining()-student_payment.getAmount());
            student_payment.setRemaining(bills.getRemaining()-student_payment.getAmount());
            session.saveOrUpdate(bills);
            session.saveOrUpdate(student_payment);
            transaction.commit();

            return true;
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return false;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Student_Payment> getPaymentList(int billId){
        try(Session session=HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            Bills bills=session.get(Bills.class,billId);
            List<Student_Payment> student_paymentList=new ArrayList<>();
            for (final Object d : session.createQuery("from Student_Payment where bill= :bills").setParameter("bills",bills).list()) {
                student_paymentList.add((Student_Payment) d);
            }
            return student_paymentList;
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return null;
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }
    @Override
    public  List<Student_Payment> getAllPaymentsList(){
        try(Session session= HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            List<Student_Payment> student_paymentList =new ArrayList<>();
            for (final Object d : session.createQuery("from Student_Payment").list()) {
                student_paymentList.add((Student_Payment) d);
            }
            return student_paymentList;
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return null;
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Student_Payment getPayment(int paymentid){
        try (Session session=HibernateSessionUtil.getSession()){
            System.out.println("id: "+paymentid);
            return (Student_Payment) session.get(Student_Payment.class,paymentid);
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return null;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
