/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOs.Conference;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hungh
 */
public class ConferenceDAO {
    public static List<Conference> getListConference()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Conference> list = null;
        try {
            //result = (Conference)session.get(Conference.class, idConference);
            String hql = "select hn from Conference hn";
            Query query = session.createQuery(hql);
            list = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        }
        finally
        {
            session.close();
        }
        return list;
    }
    
    public static Conference getConference(int idConference)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Conference result = null;
        try {
            result = (Conference)session.get(Conference.class, idConference);
            
        } catch (HibernateException e) {
            System.err.println(e);
        }
        finally
        {
            session.close();
        }
        return result;
    }
    
    public static boolean addConference(Conference c)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        if (ConferenceDAO.getConference(c.getIdHoiNghi()) != null)
//        {
//            return false;
//        }
        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return true;
    }
    
    public static boolean updateConference(Conference c)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ConferenceDAO.getConference(c.getIdHoiNghi()) == null)
        {
            return false;
        }
        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.update(c);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return true;
    }
    
    public static boolean deleteConference(int idConference)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Conference conference = ConferenceDAO.getConference(idConference);
        if (conference == null)
        {
            return false;
        }
        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.delete(conference);
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
