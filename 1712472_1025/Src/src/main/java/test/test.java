/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import BUS.AccountBUS;
import BUS.ConferenceBUS;
import DAO.AccountConferenceDAO;
import DAO.AccountDAO;
import POJOs.Conference;
import POJOs.Location;

import DAO.ConferenceDAO;
import DAO.LocationDAO;
import POJOs.Account;
import POJOs.UserHoinghi;
import POJOs.UserHoinghiId;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author hungh
 */
public class test {
    public static void main(String[] args) {
//        Account ac = AccountDAO.getAccount(1001);
//        Conference cf = ConferenceDAO.getConference(2);
//        
//        cf.getAccounts().add(ac);
//        boolean kq = ConferenceDAO.addConferenceAccount(cf);
//        if(kq)
//            System.out.println("True");
//        else System.out.println("False");

//        Account ac = AccountDAO.getAccount(1000);
//        System.out.println("Name: " + ac.getTen());
//        Iterator<Conference> iterator = ac.getConferences().iterator();
//        while(iterator.hasNext())
//        {
//            Conference temp = iterator.next();
//            System.out.println("Join: " + temp.getTen());
//        }
        
        //Account ac = AccountDAO.getAccount(1001);
//        Conference cf = ConferenceDAO.getConference(2);
//        Calendar calCon = Calendar.getInstance();
//        Calendar calToday = Calendar.getInstance();  
//        Date dateCon = cf.getThoiGian();
//        calCon.setTime(dateCon);
//        if(calCon.compareTo(calToday) <= 0)
//        {
//            System.out.println("Bé hơn");
//        }else System.out.println("Lớn hơn");

            Conference a = ConferenceBUS.getUpcomingConference();
            System.out.println("Name: "+ a.getIdHoiNghi());
//       
//        
//        int kq = AccountBUS.getStateOfAccountJoinConference(ac, cf);
            //int kq = ConferenceBUS.getNumberParticipantsAccpet(1);
        
        //System.out.println("kq = " + kq);
        
//        UserHoinghiId id = new UserHoinghiId(cf.getIdHoiNghi(), ac.getIdAccount());
//        
//        Iterator<UserHoinghi> iterator = cf.getUserHoinghis().iterator();
//        UserHoinghi userHoinghi  = null;
//        while (iterator.hasNext())
//        {
//            UserHoinghi t = iterator.next();
//            if(t.getAccount().getIdAccount() == 1001)
//            {
//                userHoinghi = t;
//                break;
//            }
//            
//        }
//        userHoinghi.setStatus(1);
        
//        System.out.println("iduser: "+ userHoinghi.getAccount().getIdAccount());
//            System.out.println("idHn: "+ userHoinghi.getConference().getIdHoiNghi());
//            System.out.println("status: "+userHoinghi.getStatus());
//        UserHoinghi userHoinghi = new UserHoinghi();
//        userHoinghi.setAccount(ac);
//        userHoinghi.setStatus(1);
//        userHoinghi.setConference(cf);
//        userHoinghi.setId(id);
//        //cf.getUserHoinghis().add(userHoinghi);
//        
//        //ac.getUserHoinghis().add(userHoinghi);
        //boolean kq = AccountConferenceDAO.updateConferenceAndAccount(userHoinghi);
//        //boolean kq = ConferenceDAO.addConferenceAccount(cf);
//        if(kq) System.out.println("True");
//        else System.out.println("False");

//        Iterator<UserHoinghi> iterator = cf.getUserHoinghis().iterator();
//        while (iterator.hasNext())
//        {
//            UserHoinghi t = iterator.next();
//            System.out.println("iduser: "+ t.getAccount().getIdAccount());
//            System.out.println("idHn: "+ t.getConference().getIdHoiNghi());
//            System.out.println("status: "+t.getStatus());
//        }
        
    }
    
}
