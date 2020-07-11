/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.AccountDAO;
import POJOs.Conference;
import POJOs.Location;

import DAO.ConferenceDAO;
import DAO.LocationDAO;
import POJOs.Account;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;



/**
 *
 * @author hungh
 */
public class test {
    public static void main(String[] args) {
        Account ac = AccountDAO.getAccount(1000);
        Conference cf = ConferenceDAO.getConference(2);
        
        cf.getAccounts().add(ac);
        boolean kq = ConferenceDAO.addConferenceAccount(cf);
        if(kq)
            System.out.println("True");
        else System.out.println("False");
 
    }
    
}
