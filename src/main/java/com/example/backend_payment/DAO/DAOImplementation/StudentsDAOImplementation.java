package com.example.backend_payment.DAO.DAOImplementation;

import com.example.backend_payment.Bean.Student_Payment;
import com.example.backend_payment.Bean.Students;
import com.example.backend_payment.DAO.StudentsDAO;
import com.example.backend_payment.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentsDAOImplementation implements StudentsDAO {
    @Override
    public boolean addStudent(Students stuObj){
        try(Session session= HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            session.save(stuObj);
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
    public List<Students> getStudentList(){
        try(Session session=HibernateSessionUtil.getSession()){
            List<Students> studentsList = new ArrayList<>();
            for (final Object d : session.createQuery("from Students ").list()) {
                studentsList.add((Students) d);
            }
            return studentsList;
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return null;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Students getStudent(int Stuid){
        try (Session session=HibernateSessionUtil.getSession()){
            System.out.println("id: "+Stuid);
            return (Students)session.get(Students.class,Stuid);
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return null;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Student_Payment> getDetails(int StudId){
        try(Session session=HibernateSessionUtil.getSession()){
            System.out.println("Id: "+ StudId);
            List<Student_Payment> result=(List<Student_Payment>) session.createQuery("from Student_Payment where bill.students.student_id= :StudId").setParameter("StudId",StudId).list();
            return result;
        }
    }

    @Override
    public Students login(Students students){
        try(Session session=HibernateSessionUtil.getSession()){
            String StudentEmail=students.getEmail();
            String StudentPassword=students.getPassword();

            Students students1=(Students) session.createQuery("from Students where email= :StudentEmail and password= :StudentPassword").setParameter("StudentPassword",StudentPassword).setParameter("StudentEmail",StudentEmail).uniqueResult();
            if(students1==null){
                return null;
            }else{
                return students1;
            }
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
