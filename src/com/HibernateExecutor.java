package com;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

/**
 * Created by weiluo on 2/23/17.
 */
public class HibernateExecutor {
    private static SessionFactory factory;
    public boolean StarFactorySuccess(){
        try{
            factory=new Configuration().configure().buildSessionFactory();
            System.out.println("Start SessionFactory Successfully");
            return Boolean.TRUE;
        }catch (ExceptionInInitializerError error){
            error.printStackTrace();
            System.out.println("Start SessionFactory Failed");
            return Boolean.FALSE;
        }
    }
    public void FactoryShutdown(){
        factory.close();
    }
    public void saveCustomer(Customer customer){
        Session session=factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(customer);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
            System.out.println("Session is closed Successfully");
        }
    }
    private List<Customer> readCustomer(){
        Session session=factory.openSession();
        Transaction tx=null;
        List customer=null;
        try{
            tx=session.beginTransaction();
            customer=session.createQuery("FROM com.Customer").list();
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
            return customer;
        }
    }
    public void printCustomer(){
        List<Customer> customers=readCustomer();
        for(Customer eachCustomer: customers){
            Set<Responsible> responsibles=eachCustomer.getAuthorized();
            System.out.println("--------------------------------Customer");
            System.out.println("Customer id: "+eachCustomer.getId());
            System.out.println("Customer firstName: "+eachCustomer.getFirstName());
            System.out.println("Customer lastName: "+eachCustomer.getLastName());
            System.out.println("Customer accountNum: "+eachCustomer.getAccountNum());

            for(Responsible eachResponsible: responsibles){
                System.out.println("---Responsible");
                System.out.println("***Responsible id: "+eachResponsible.getId());
                System.out.println("***Responsible firstName: "+eachResponsible.getFirstName());
                System.out.println("***Responsible lastName: "+eachResponsible.getFirstName());
                System.out.println("***Responsible accountNum: "+eachResponsible.getAccountNumber());
                System.out.println("***Responsible customerId: "+eachResponsible.getCustomerId());
            }

        }
    }
    public void deleteCustomer(Integer id){
        Session session=factory.openSession();
        Transaction tx;
        try{
            tx=session.beginTransaction();
            Customer customer=session.get(Customer.class, id);
            session.delete(customer);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
