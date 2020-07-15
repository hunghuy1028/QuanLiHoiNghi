/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOs.Account;
import POJOs.Conference;
import POJOs.UserHoinghi;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hungh
 */
public class AccountConferenceDAO {
    
    
    public static boolean addConferenceAndAccount(UserHoinghi uh)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean kq = true;
        if (uh == null)
        {
            return false;
        }        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(uh);
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
    
    public static boolean updateConferenceAndAccount(UserHoinghi uh)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean kq = true;
        if (uh == null)
        {
            return false;
        }        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(uh);
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
    
    public static boolean deleteConferenceAndAccount(UserHoinghi uh)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean kq = true;
        if (uh == null)
        {
            return false;
        }        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.delete(uh);
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
    
}
