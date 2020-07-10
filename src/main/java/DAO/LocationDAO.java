/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOs.Location;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hungh
 */
public class LocationDAO {
    public static Location getLocation(int idLocation)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Location result = null;
        try {
            result = (Location)session.get(Location.class, idLocation);     
        } catch (HibernateException e) {
            System.err.println(e);
        }finally{
            session.close();
        }
        return result;
    }
    
    public static List<Location> getListLocation()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Location> result = null;
        
        try {
            String hql = "select lc from Location lc";
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
    
    public static boolean addLocation(Location lc)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
//        if(LocationDAO.getLocation(lc.getIdDiaDiem()) != null)
//        {
//            return false;
//        }
        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.save(lc);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return true;
    }
    
    public static boolean updateLocation(Location lc)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        if(LocationDAO.getLocation(lc.getIdDiaDiem()) == null)
        {
            return false;
        }
        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.update(lc);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
        }finally{
            session.close();
        }
        
        return true;
    }
    
    public static boolean deleteLocation(int idLocation)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Location location = LocationDAO.getLocation(idLocation);
        if(location == null)
        {
            return false;
        }
        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.delete(location);
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
