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
        Account acc = AccountDAO.getAccountByUsername("hung125");
        if (acc == null)
        {
            System.out.println("Can't find this account!");
        }
        else
        {
            System.out.println("ID: "+ acc.getIdAccount());
            System.out.println("Name: " + acc.getTen());
            System.out.println("Pass: " + acc.getPassword());
            //acc.toString();
        }
       
 
    }
    
}
