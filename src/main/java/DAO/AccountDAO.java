/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOs.Account;
import POJOs.Conference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hungh
 */
public class AccountDAO {
    public static Account getAccount(int idAccount)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account result = null;
        
        try {
            result = (Account)session.get(Account.class, idAccount);
        } catch (HibernateException e) {
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return result;
    }
    
    public static Account getAccountByUsername(String username)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account result = null;
        
        try {
            String hql = "select ac from Account ac where ac.username = :param1";
            Query hQuery = session.createQuery(hql);
            hQuery.setParameter("param1", username);
            result = (Account)hQuery.uniqueResult();
            
        } catch (HibernateException e) {
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return result;
    }
    
    
    
    public static List<Account> getListAccount()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Account> result = null;
        
        try {
            String hql = "select ac from Account ac";
            Query query = session.createQuery(hql);
            result = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        }
        finally
        {
            session.close();
        }
        return result;
    }
    
    public static boolean addAccount(Account account)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
//        if (AccountDAO.getAccount(account.getIdAccount()) != null)
//        {
//            return false;
//        }
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return true;
    }
    
    public static boolean addAccountConference(Account account)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        boolean kq = true;
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(account);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
            kq = false;
        }finally{
            session.close();
        }
        return kq;
    }
    
    public static boolean updateAccount(Account account)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        if (AccountDAO.getAccount(account.getIdAccount()) == null)
        {
            return false;
        }
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return true;
    }
    
    public static boolean deleteAccount(int idAccount)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Account account = AccountDAO.getAccount(idAccount);
        
        if (account == null)
        {
            return false;
        }
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return true;
    }
}
