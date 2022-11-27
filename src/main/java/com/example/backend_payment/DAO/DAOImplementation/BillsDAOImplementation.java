package com.example.backend_payment.DAO.DAOImplementation;

import com.example.backend_payment.Bean.Bills;
import com.example.backend_payment.Bean.Students;
import com.example.backend_payment.DAO.BillsDAO;
import com.example.backend_payment.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BillsDAOImplementation implements BillsDAO {
    @Override
    public boolean addBills(Bills bills){
        try(Session session= HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(bills);
            transaction.commit();
            return true;
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return false;
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public Bills getBill(int billid){
        try (Session session=HibernateSessionUtil.getSession()){
            System.out.println("id: "+billid);
            return (Bills)session.get(Bills.class,billid);
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
    public List<Bills> getBillList(int stuid){
        try(Session session=HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            Students stuobj=(Students)session.get(Students.class,stuid);
            List<Bills> billsList=new ArrayList<>();
            for (final Object d : session.createQuery("from Bills where students= :stuobj").setParameter("stuobj",stuobj).list()) {
                billsList.add((Bills) d);
            }
            return billsList;
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
    public List<Bills> getAllBillsList(){
        try(Session session=HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            List<Bills> billsList=new ArrayList<>();
            for (final Object d : session.createQuery("from Bills").list()) {
                billsList.add((Bills) d);
            }
            return billsList;
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return null;
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }

}

